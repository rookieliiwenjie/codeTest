package com.company.并发编程.day018_2021_03_07;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author rookie.li
 * @create 2021/3/7
 */
public class TwinsLock implements Lock {
    private Sync sync = new Sync(2);

    @Override
    public void lock() {
        //sync.tryAcquireSharedNanos(1);
        //sync.acquireInterruptibly(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        public int getCount() {
            return getState();
        }

        @Override
        protected int tryAcquireShared(int count) {
            for (; ; ) {
                int current = getState();
                int newCount = current - count;
                if (newCount >= 0 && compareAndSetState(current, newCount)) {

                }
            }
        }
    }

}
