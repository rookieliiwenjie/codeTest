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
 * 3.等待是否可中断
 * synchronize 不可中断
 * reentrantLock.lockInterruptibly();（）
 */
class ShareRease2 {

    int number = 1;
    Semaphore semaphore = new Semaphore(1);
    Semaphore semaphoreb = new Semaphore(0);
    Semaphore semaphorec = new Semaphore(0);

    public void print5() throws InterruptedException {
        //判断
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lockInterruptibly();

        //工作
        semaphore.acquire();
        System.out.print("A");
        semaphoreb.release();


    }

    public void print10() throws InterruptedException {
        //判断
        semaphoreb.acquire();
        System.out.print("B");

        semaphorec.release();


    }

    public void print15() throws InterruptedException {
        semaphorec.acquire();
        System.out.print("c");

        semaphore.release();


    }
}

public class AbcDemo {
    public static void main(String[] args) {
        ShareRease2 shareRease = new ShareRease2();
        new Thread(() -> {

            try {
                for (int i = 0; i < 10; i++) {
                    shareRease.print5();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareRease.print10();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareRease.print15();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

