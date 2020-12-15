package com.company.BlockingQueueDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2020/5/28.
 * synchronized和lock区别
 * 1.synchronized 是关键字属于JVM底层，通过monitor对象完成，其实wait/notify等方法也是依赖于monitor对象只有在
 * 同步块或方法中才能调用wait和notify等等发
 * lock是api层面的锁
 * 2.使用方法
 * synchronized不需要用户手动释放锁，
 * ReentrantLock则需要用户去手动释放锁，若没有主动释放就可能出现死锁，
 * 3.是否公平锁
 * synchonried 是非公平锁
 * lock 默认也为非公平锁
 * 但是可以通过true开启公平锁
 * 4.是否可以打断   lock.lockInterruptibly();
 * 5.绑定多个条件Codition
 */
class ShareRease {
    int number = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionb = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lockInterruptibly();
        //判断
        lock.lock();
        try {
            while (number != 1) {
                conditionA.await();
            }
            //工作
            for (int i = 0; i < 5; i++) {
                System.out.print("A");
            }
            number = 2;
            //通知
            conditionb.signalAll();
        } finally {
            lock.unlock();

        }


    }

    public void print10() throws InterruptedException {
        //判断
        lock.lock();
        try {
            while (number != 2) {
                conditionb.await();
            }
            //工作
            for (int i = 0; i < 5; i++) {
                System.out.print("B");
            }
            number = 3;
            //通知
            conditionC.signalAll();
        } finally {
            lock.unlock();

        }


    }

    public void print15() throws InterruptedException {
        //判断
        lock.lock();
        try {
            while (number != 3) {
                conditionC.await();
            }
            //工作
            for (int i = 0; i < 5; i++) {
                System.out.print("C");
            }
            number = 1;
            //通知
            conditionA.signalAll();
        } finally {
            lock.unlock();

        }


    }
}

public class SynchronizedAndLockDemo {
    public static void main(String[] args) {
        ShareRease shareRease = new ShareRease();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareRease.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    shareRease.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    shareRease.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

