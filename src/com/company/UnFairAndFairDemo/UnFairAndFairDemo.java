package com.company.UnFairAndFairDemo; /**
 * Created by lwj32 on 2020/5/21.
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 如何创建
 * 1.通过ReentrantLock的构造函数去创建默认为false
 * new ReentrantLock(isFair)
 * 2.区别
 * 公平锁是将request放到一个队列中遵循先进先出的原则去竞争锁
 * 非公平锁unfair是通过所有的上来来抢占锁，当抢占锁失败以后，
 * 会遵循类似于（可能是优先级的问题）公平锁的方式
 * 非公平锁的吞吐量要远远高于公平锁
 * 3.出现的问题：非公平锁可能会出现优先级反转和饥饿状态(有些可能一直抢占不上锁)
 */
public class UnFairAndFairDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        ReentrantLock lock = new ReentrantLock();
        //NoPair具体实现
        /*static final class NonfairSync extends ReentrantLock.Sync {
            private static final long serialVersionUID = 7316153563782823691L;

            *//**
         * Performs lock.  Try immediate barge, backing up to normal
         * acquire on failure.
         *//*
            final void lock() {
                if (compareAndSetState(0, 1))
                    setExclusiveOwnerThread(Thread.currentThread());
                else
                    acquire(1);
            }*/
        //Pair实现
       /* static final class FairSync extends ReentrantLock.Sync {
            private static final long serialVersionUID = -3000897897090466540L;

            final void lock() {
                acquire(1);
            }*/
        /**
         *  public final void acquire(int arg) {
         *         if (!tryAcquire(arg) &&
         *             acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
         *             selfInterrupt();
         *     }
         */

        /**
         *  public ReentrantLock(boolean fair) {
         *         sync = fair ? new FairSync() : new NonfairSync();
         *     }
         */
    }

}
