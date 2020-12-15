package com.company.BlockingQueueDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lwj32 on 2020/5/27.
 * 1.线程操作资源类
 * 2.判断 干活 通知
 * 3.防止虚假线程唤醒
 */
class ShareData {
    private int number = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    void deNumber() {
        reentrantLock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\tnumber = " + number);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }

    void addNumber() {
        reentrantLock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\tnumber = " + number);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}

public class ProduConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.addNumber();

            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.deNumber();


            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.addNumber();

            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.addNumber();


            }
        }, "B").start();
    }
}
