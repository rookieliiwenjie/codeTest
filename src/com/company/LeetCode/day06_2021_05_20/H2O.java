package com.company.LeetCode.day06_2021_05_20;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2021/5/22.
 */
public class H2O {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition hCondition = reentrantLock.newCondition();
    static Condition oCondition = reentrantLock.newCondition();
    static int num = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (num == 2) {
                oCondition.signalAll();
                hCondition.await();
            }
            releaseHydrogen.run();
            num++;
            // 避免最后都是H元素，O元素的线程一直在wait
            if (num == 2) {
                hCondition.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (num != 2) {
                oCondition.await();
            }
            num = 0;
            releaseOxygen.run();
            hCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
    }
}