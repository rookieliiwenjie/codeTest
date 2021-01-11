阻塞队列之二：LinkedTransferQueue
一、LinkedTransferQueue简介
TransferQueue是一个继承了BlockingQueue的接口，并且增加若干新的方法。LinkedTransferQueue是TransferQueue接口的实现类，其定义为一个无界的队列，具有先进先出(FIFO)的特性。


有人这样评价它："TransferQueue是是ConcurrentLinkedQueue、SynchronousQueue (公平模式下)、无界的LinkedBlockingQueues等的超集。"

 LinkedTransferQueue实现了一个重要的接口TransferQueue，该接口含有下面几个重要方法：
     1. transfer(E e)：若当前存在一个正在等待获取的消费者线程，即立刻移交之；否则，会插入当前元素e到队列尾部，并且等待进入阻塞状态，到有消费者线程取走该元素。
     2. tryTransfer(E e)：若当前存在一个正在等待获取的消费者线程（使用take()或者poll()函数），使用该方法会即刻转移/传输对象元素e；若不存在，则返回false，并且不进入队列。这是一个不阻塞的操作。
     3. tryTransfer(E e, long timeout, TimeUnit unit)：若当前存在一个正在等待获取的消费者线程，会立即传输给它；否则将插入元素e到队列尾部，并且等待被消费者线程获取消费掉；若在指定的时间内元素e无法被消费者线程获取，则返回false，同时该元素被移除。
     4. hasWaitingConsumer()：判断是否存在消费者线程。
     5. getWaitingConsumerCount()：获取所有等待获取元素的消费线程数量。　　
     6.size()：因为队列的异步特性，检测当前队列的元素个数需要逐一迭代，可能会得到一个不太准确的结果，尤其是在遍历时有可能队列发生更改。
     7.批量操作：类似于addAll，removeAll, retainAll, containsAll, equals, toArray等方法，API不能保证一定会立刻执行。因此，我们在使用过程中，不能有所期待，这是一个具有异步特性的队列。

LinkedTransferQueue采用的一种预占模式。意思就是消费者线程取元素时，如果队列为空，那就生成一个节点（节点元素为null）入队，然后消费者线程park住，后面生产者线程入队时发现有一个元素为null的节点，生产者线程就不入队了，直接就将元素填充到该节点，唤醒该节点上park住线程，被唤醒的消费者线程拿货走人。这就是预占的意思：有就拿货走人，没有就占个位置等着，等到或超时。

TransferQueue
LinkedTransferQueue实现了TransferQueue接口，这个接口继承了BlockingQueue。之前BlockingQueue是队列满时再入队会阻塞，而这个接口实现的功能是队列不满时也可以阻塞，实现一种有阻塞的入队功能。而这个接口在之前SynChronousQueue内种也有体现，作为内部抽象类Transferer，然后公平非公平2中实现，可以体会下。看下TransferQueue接口的代码：

复制代码
public interface TransferQueue<E> extends BlockingQueue<E> {
    /**
     * 立即转交一个元素给消费者，如果此时队列没有消费者，那就false
     */
    boolean tryTransfer(E e);

    /**
     * 转交一个元素给消费者，如果此时队列没有消费者，那就阻塞
     */
    void transfer(E e) throws InterruptedException;

    /**
     * 带超时的tryTransfer
     */
    boolean tryTransfer(E e, long timeout, TimeUnit unit)
        throws InterruptedException;

    /**
     * 是否有消费者等待接收数据，瞬时状态，不一定准
     */
    boolean hasWaitingConsumer();

    /**
     * 返回还有多少个等待的消费者，跟上面那个一样，都是一种瞬时状态，不一定准
     */
    int getWaitingConsumerCount();
}
复制代码
其实transfer方法在SynchronousQueue的实现中就已存在了,只是没有做为API暴露出来。SynchronousQueue有一个特性:它本身不存在容量,只能进行线程之间的元素传送。SynchronousQueue在执行offer操作时，如果没有其他线程执行poll，则直接返回false.线程之间元素传送正是通过transfer方法完成的。

二、ArrayBlockingQueue源码分析
2.1、ArrayBlockingQueue的lock
这里没有锁，用的是CAS

复制代码
// CAS methods for fields
private boolean casTail(Node cmp, Node val) {
    return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
}

private boolean casHead(Node cmp, Node val) {
    return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
}

private boolean casSweepVotes(int cmp, int val) {
    return UNSAFE.compareAndSwapInt(this, sweepVotesOffset, cmp, val);
}
复制代码
还有node中的cas

复制代码
        // CAS methods for fields
        final boolean casNext(Node cmp, Node val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        final boolean casItem(Object cmp, Object val) {
            // assert cmp == null || cmp.getClass() != Node.class;
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }
复制代码
 

2.2、数据结构(基于单链表)
先看下大概样子：

isData	item	next	waiter
isData：表示该节点是存放数据还是获取数据； 
item：存放数据，isData为false时，该节点为null，为true时，匹配后，该节点会置为null； 
next：指向下一个节点； 
waiter：上面原理部分说的会park住消费者线程，线程就放在这里。

 View Code
2.2、成员变量
复制代码
/** 判断多核 */
private static final boolean MP =
    Runtime.getRuntime().availableProcessors() > 1;

/**
 * 作为第一个等待节点在阻塞park前自旋次数
 */
private static final int FRONT_SPINS   = 1 << 7;

/**
 * 前驱节点正在处理，当前节点需要自旋的次数
 */
private static final int CHAINED_SPINS = FRONT_SPINS >>> 1;

/**
 * The maximum number of estimated removal failures (sweepVotes)
 * to tolerate before sweeping through the queue unlinking
 * cancelled nodes that were not unlinked upon initial
 * removal. See above for explanation. The value must be at least
 * two to avoid useless sweeps when removing trailing nodes.
 */
static final int SWEEP_THRESHOLD = 32;

 /** head of the queue; null until first enqueue */
transient volatile Node head;

/** tail of the queue; null until first append */
private transient volatile Node tail;

/** The number of apparent failures to unsplice removed nodes */
private transient volatile int sweepVotes;

/*
 * 调用xfer时候需要传入,区分不同处理
 */
private static final int NOW   = 0; // for untimed poll, tryTransfer
private static final int ASYNC = 1; // for offer, put, add
private static final int SYNC  = 2; // for transfer, take
private static final int TIMED = 3; // for timed poll, tryTransfer
复制代码
2.4、构造函数
复制代码
    public LinkedTransferQueue() {
    }

    public LinkedTransferQueue(Collection<? extends E> c) {
        this();
        addAll(c);
    }
复制代码
2.5、入队
复制代码
    public void put(E e) {
        xfer(e, true, ASYNC, 0);
    }

    public boolean offer(E e) {
        xfer(e, true, ASYNC, 0);
        return true;
    }

    public boolean add(E e) {
        xfer(e, true, ASYNC, 0);
        return true;
    }

    public boolean tryTransfer(E e) {
        return xfer(e, true, NOW, 0) == null;
    }

    public void transfer(E e) throws InterruptedException {
        if (xfer(e, true, SYNC, 0) != null) {
            Thread.interrupted(); // failure possible only due to interrupt
            throw new InterruptedException();
        }
    }
复制代码
xfer()方法：

复制代码
/**
 * 所有入队出队都调用该方法
 */
private E xfer(E e, boolean haveData, int how, long nanos) {
    if (haveData && (e == null)) //put时非空校验
        throw new NullPointerException();
    Node s = null;                        // the node to append, if needed

    retry:
    for (;;) {                            // restart on append race

        for (Node h = head, p = h; p != null;) { // 从head开始查找匹配的节点，p为null队列为空
            boolean isData = p.isData;
            Object item = p.item;
            if (item != p && (item != null) == isData) { // 如果找到的节点没有匹配过
                if (isData == haveData)   // 节点类型跟待处理的类型一样，那肯定不行，例如找到的是一个data节点，匹配的肯定是一个false的reservation,你给一个data节点来匹配肯定不行
                    break;
                if (p.casItem(item, e)) { // 可以匹配，那就casItem，2中情况，如果p的item原来是data，那么匹配后item为null，原来为null，现在有值了
                    for (Node q = p; q != h;) { //这里是帮助推进head节点，跟之前的SynchronousQueue类似效果
                        Node n = q.next;  // update by 2 unless singleton
                        if (head == h && casHead(h, n == null ? q : n)) {
                            h.forgetNext();
                            break;
                        }                 // advance and retry
                        if ((h = head)   == null ||
                            (q = h.next) == null || !q.isMatched())
                            break;        // unless slack < 2
                    }
                    LockSupport.unpark(p.waiter); //匹配后将p上park的线程unpark，还是2种情况
                    return this.<E>cast(item); //返回item
                }
            }
            Node n = p.next; //如果上面找到的节点已经匹配过了，那就往后再找
            p = (p != n) ? n : (h = head); // 如果p的next指向p本身，说明p节点已经有其他线程处理过了，只能从head重新开始
        }

        if (how != NOW) {                 // 如果上面没有找到匹配的，对不同how进来的处理不同，NOW为untimed poll, tryTransfer，不需要入队
            if (s == null)
                s = new Node(e, haveData);
            Node pred = tryAppend(s, haveData); //append节点，返回前驱节点
            if (pred == null)
                continue retry;           // 返回的前驱节点为null，那就是有race，被其他的抢了，那就continue 整个for
            if (how != ASYNC) //这里就是SYNC  = 2; transfer, take 和TIMED = 3; timed poll, tryTransfer需要阻塞等待匹配
                return awaitMatch(s, pred, e, (how == TIMED), nanos);
        }
        return e; // Now 和 ASYNC = 1; for offer, put, add，无界队列返回就是
    }
}
复制代码
大体流程还算清晰，总结下： 
1. find match，主要是判断匹配条件，节点本身还未匹配，且isData类型和待匹配的不一样就行，匹配后就是casItem，unpark匹配节点waiter，返回就是； 
2. unmatched，如果没找到，那就根据不同方法入参how处理了，now的就直接返回，其他的3种先入队，然后ASYNC入队后返回，SYNC和TIMED阻塞等待匹配。

复制代码
/** append一个节点到tail */
private Node tryAppend(Node s, boolean haveData) {
    for (Node t = tail, p = t;;) {        // 从tail节点开始
        Node n, u;                        // temps for reads of next & tail
        if (p == null && (p = head) == null) { //队列空
            if (casHead(null, s)) //将节点设置成head
                return s;                 // initialize
        }
        else if (p.cannotPrecede(haveData))
            return null;                  // lost race vs opposite mode
        else if ((n = p.next) != null)    // not last; keep traversing
            p = p != t && t != (u = tail) ? (t = u) : // stale tail
                (p != n) ? n : null;      // restart if off list
        else if (!p.casNext(null, s))
            p = p.next;                   // re-read on CAS failure
        else {
            if (p != t) {                 // update if slack now >= 2
                while ((tail != t || !casTail(t, s)) &&
                       (t = tail)   != null &&
                       (s = t.next) != null && // advance and retry
                       (s = s.next) != null && s != t);
            }
            return p;
        }
    }
}

/** 等待匹配或者超时时间到,大体流程跟SynchronousQueue的那个awaitFulfill类似 */
private E awaitMatch(Node s, Node pred, E e, boolean timed, long nanos) {
    long lastTime = timed ? System.nanoTime() : 0L;
    Thread w = Thread.currentThread();
    int spins = -1; // initialized after first item and cancel checks
    ThreadLocalRandom randomYields = null; // bound if needed

    for (;;) {
        Object item = s.item;
        if (item != e) {                  // 匹配后，xfer会有个casItem操作，这里park被唤醒后检查是否有变化
            // assert item != s;
            s.forgetContents();           // avoid garbage
            return this.<E>cast(item);
        }
        if ((w.isInterrupted() || (timed && nanos <= 0)) &&
                s.casItem(e, s)) {        // 超时了
            unsplice(pred, s); //将节点unlink
            return e;
        }

        if (spins < 0) {                  // 自旋 establish spins at/near front
            if ((spins = spinsFor(pred, s.isData)) > 0) //自旋次数
                randomYields = ThreadLocalRandom.current();
        }
        else if (spins > 0) {             // spin
            --spins;
            if (randomYields.nextInt(CHAINED_SPINS) == 0) //这里没太明白为什么要yield
                Thread.yield();           // occasionally yield
        }
        else if (s.waiter == null) {
            s.waiter = w;                 // park前肯定会调用一次
        }
        else if (timed) { //超时的park
            long now = System.nanoTime();
            if ((nanos -= now - lastTime) > 0)
                LockSupport.parkNanos(this, nanos);
            lastTime = now;
        }
        else {
            LockSupport.park(this); //没有超时的park
        }
    }

}

/** 将节点s从队列断开 */
final void unsplice(Node pred, Node s) {
    s.forgetContents(); // forget unneeded fields
    /*
     * See above for rationale. Briefly: if pred still points to
     * s, try to unlink s.  If s cannot be unlinked, because it is
     * trailing node or pred might be unlinked, and neither pred
     * nor s are head or offlist, add to sweepVotes, and if enough
     * votes have accumulated, sweep.
     */
    if (pred != null && pred != s && pred.next == s) {
        Node n = s.next;
        if (n == null ||
            (n != s && pred.casNext(s, n) && pred.isMatched())) {
            for (;;) {               // check if at, or could be, head
                Node h = head;
                if (h == pred || h == s || h == null)
                    return;          // at head or list empty
                if (!h.isMatched())
                    break;
                Node hn = h.next;
                if (hn == null)
                    return;          // now empty
                if (hn != h && casHead(h, hn)) //推进head节点
                    h.forgetNext();  // advance head
            }
            if (pred.next != pred && s.next != s) { // recheck if offlist
                for (;;) {           // 通过sweepVotes变量控制到达足够次数后清除matched节点
                    int v = sweepVotes;
                    if (v < SWEEP_THRESHOLD) {
                        if (casSweepVotes(v, v + 1))
                            break;
                    }
                    else if (casSweepVotes(v, 0)) {
                        sweep();
                        break;
                    }
                }
            }
        }
    }
}

/** 通过pre节点计算自旋次数 */
private static int spinsFor(Node pred, boolean haveData) {
    if (MP && pred != null) { //必须多核
        if (pred.isData != haveData)      // phase change
            return FRONT_SPINS + CHAINED_SPINS;
        if (pred.isMatched())             // pre已经匹配了，那就可以少自旋一些 probably at front
            return FRONT_SPINS;
        if (pred.waiter == null)          // pre节点在匹配中了，那可以再少自旋一点 pred apparently spinning
            return CHAINED_SPINS;
    }
    return 0;
}
复制代码
2.6、出队
    public E poll() {
        return xfer(null, false, NOW, 0);
    }
2.7、peek方法
返回队列头元素但不移除该元素，队列为空，返回null

复制代码
    public E peek() {
        return firstDataItem();
    }
    
    private E firstDataItem() {
        for (Node p = head; p != null; p = succ(p)) {
            Object item = p.item;
            if (p.isData) {
                if (item != null && item != p)
                    return LinkedTransferQueue.<E>cast(item);
            }
            else if (item == null)
                return null;
        }
        return null;
    }
复制代码
三、JDK或开源框架中使用
四、使用示例
========================================================================================================实例源码：生产者和消费者进程模拟

生产者源码（Producer）：

复制代码
package com.dxz.queue;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private final TransferQueue<String> queue;

    public Producer(TransferQueue<String> queue) {
        this.queue = queue;
    }

    private String produce() {
        return " your lucky number " + (new Random().nextInt(100));
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (queue.hasWaitingConsumer()) {
                    queue.transfer(produce());
                }
                TimeUnit.SECONDS.sleep(1);// 生产者睡眠一秒钟,这样可以看出程序的执行过程
            }
        } catch (InterruptedException e) {
        }
    }
}
复制代码
消费者源码（Consumer）：

复制代码
package com.dxz.queue;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private final TransferQueue<String> queue;

    public Consumer(TransferQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(" Consumer " + Thread.currentThread().getName() + queue.take());
        } catch (InterruptedException e) {
        }
    }
}
复制代码
测试类源码：

复制代码
package com.dxz.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LuckyNumberGenerator {

    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();
        Thread producer = new Thread(new Producer(queue));
        producer.setDaemon(true); // 设置为守护进程使得线程执行结束后程序自动结束运行
        producer.start();
        for (int i = 0; i < 10; i++) {
            Thread consumer = new Thread(new Consumer(queue));
            consumer.setDaemon(true);
            consumer.start();
            try {
                // 消费者进程休眠一秒钟，以便以便生产者获得CPU，从而生产产品
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
复制代码
运行结果（一种可能的结果）：

 

复制代码
 Consumer Thread-1 your lucky number 96
 Consumer Thread-2 your lucky number 28
 Consumer Thread-3 your lucky number 24
 Consumer Thread-4 your lucky number 77
 Consumer Thread-5 your lucky number 59
 Consumer Thread-6 your lucky number 45
 Consumer Thread-7 your lucky number 12
 Consumer Thread-8 your lucky number 93
 Consumer Thread-9 your lucky number 94
复制代码
在Grizzly中，自带了LinkedTransferQueue，和JDK 7自带的LinkedTransferQueue有所不同，不同之处就是使用PaddedAtomicReference来提升并发性能，其实这是一种错误的编码技巧，没有意义！

AtomicReference和LinkedTransferQueue的本质是乐观锁，乐观锁的在激烈竞争的时候性能都很糟糕，乐观锁应使用在非激烈竞争的场景，为乐观锁优化激烈竞争下的性能，是错误的方向，因为如果需要激烈竞争，就应该使用悲观锁。

以下是一个JDK中内置乐观锁悲观锁的对照表：

乐观锁           ----->  悲观锁

AtomicInteger   ----->  Lock + volatile int

AtomicLong      ----->  Lock + volatile long

AtomicReference ----->  Lock + volatile

LinkedTransferQueue -----> LinkedBlockingQueue

在激烈竞争中，LinkedTransferQueue的性能，远远低于LinkedBlockingQueue，使用PaddedAtomicReference优化也是一样的。如果不激烈竞争，Padded-LinkedTransferQueue和LinkedTransferQueue相比也没有什么优势。

所以Padded-AtomicReference也是一个伪命题，如果激励竞争，为什么不使用Lock + volatile，如果非激烈竞争，使用PaddedAtomicReference对于AtomicReference又没有优势。所以使用Padded-AtomicReference是一个错误的编码技巧。

以下是测试代码，50个线程争用10个对象，这种激烈竞争下，使用LinkedTransferQueue比LinkedBlockingQueue大约慢10倍。

复制代码
package com.alibaba.study;

import java.util.concurrent.*;

public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; ++i) {
            loop();
        }        
    }
    
    private static void loop() throws InterruptedException {
        final BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
//        final BlockingQueue<Object> queue = new LinkedTransferQueue<Object>();

        for (int i = 0; i < 10; ++i) {
            queue.put(i);
        }

        final int THREAD_COUNT = 50;
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; ++i) {
            Thread thread = new Thread() {
                public void run() {
                    try {
                        startLatch.await();
                    } catch (InterruptedException e) { e.printStackTrace(); }

                    try {
                        for (int i = 0; i < 1000 * 20; ++i) {
                            Object item = queue.take();
                            queue.put(item);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        endLatch.countDown();
                    }
                }
            };
            thread.start();
        }

        long startMillis = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        long millis = System.currentTimeMillis() - startMillis;
        System.out.println(queue.getClass().getName() + " : " + millis);
    }
}
复制代码