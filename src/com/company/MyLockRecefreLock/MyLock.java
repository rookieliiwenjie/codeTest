package com.company.MyLockRecefreLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class MyLock implements Lock {
    private volatile boolean FLAG = false;
    volatile Thread byLock = null;
    volatile int lockCount;
    @Override
    public synchronized void lock() {
        Thread nowThread = Thread.currentThread();
        while (FLAG && nowThread!=byLock){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
        lockCount++;
        byLock = nowThread;
        FLAG=true;
    }
    @Override
    public synchronized void unlock() {
        Thread nowThread = Thread.currentThread();
        if(nowThread==byLock){
            notify();
            lockCount--;
            if(lockCount==0){
                FLAG=false;

            }
        }

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
    public Condition newCondition() {
        return null;
    }
}
