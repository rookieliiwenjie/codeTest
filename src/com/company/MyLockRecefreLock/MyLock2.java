package com.company.MyLockRecefreLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class MyLock2 implements Lock {
    private volatile boolean FLAG = false;

    @Override
    public synchronized void lock() {
        while (FLAG){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
        FLAG=true;
    }
    @Override
    public synchronized void unlock() {
            notify();
                FLAG=false;


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
