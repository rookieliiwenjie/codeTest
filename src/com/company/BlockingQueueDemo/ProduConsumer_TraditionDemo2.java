package com.company.BlockingQueueDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2020/5/27.
 * 1.线程操作资源类
 * 2.判断 干活 通知
 * 3.防止虚假线程唤醒
 */
class ShareData2 {
    private int number = 0;
    volatile Object object = new Object();

    public void deNumber() {
        synchronized (object) {
            try {

                while (number == 0) {
                    object.wait();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "\tnumber = " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                object.notifyAll();

            }
        }


    }

    public void addNumber() {
        synchronized (object) {
            try {

                while (number != 0) {
                    object.wait();
                }
                number++;
                System.out.println(Thread.currentThread().getName() + "\tnumber = " + number);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                object.notifyAll();
            }
        }

    }
}

public class ProduConsumer_TraditionDemo2 {
    public static void main(String[] args) {
        ShareData2 shareData = new ShareData2();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.addNumber();

            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.deNumber();

            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.addNumber();

            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.deNumber();

            }
        }, "D").start();

     /*   new Thread(()->{
            for(int i=0;i<5;i++){
                shareData.addNumber();

            }
        },"D").start();
        new Thread(()->{
            for(int i=0;i<5;i++){
                shareData.deNumber();


            }
        },"B").start();*/
    }
}
