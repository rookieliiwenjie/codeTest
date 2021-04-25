package com.company.并发编程.day09_2021_2_18_3_5LOCK;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author rookie.li
 * @create 2021/2/18
 */
public class ReecenrLock {
    static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static final Unsafe unsafe;
    private static final long stateOffset;
    public int state;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            //UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ReecenrLock.class;
            stateOffset = unsafe.objectFieldOffset
                    (k.getDeclaredField("state"));

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        ReecenrLock reecenrLock = new ReecenrLock();
        reecenrLock.state = 2;
       /* for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                reecenrLock.test();

            }, i + "").start();
        }*/
        int queueLength = reentrantLock.getQueueLength();
        System.out.println("queueLength = " + queueLength);
        System.out.println("stateOffset = " + stateOffset);
        final boolean b = reecenrLock.compareAndSwapState(reecenrLock.state, 2);
        System.out.println("b = " + b);
        System.out.println("state = " + reecenrLock.state);


    }

    public final boolean compareAndSwapState(long e, long u) {
        //ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //reentrantReadWriteLock.readLock();
        return unsafe.compareAndSwapLong(this, stateOffset, e, u);

    }

    public void test() {
        //ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //reentrantReadWriteLock.readLock();
        reentrantLock.lock();
        try {
            //
            TimeUnit.SECONDS.sleep(3);
            int i = 10;
            i++;
            System.out.println("i = " + i);
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
