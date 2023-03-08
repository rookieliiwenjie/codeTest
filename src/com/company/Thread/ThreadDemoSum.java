package com.company.Thread;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread implements Runnable {
    //10张车票
//    private volatile int ticket = 10;
    public     int  ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在卖票：" +ticket--);
            } else {
                System.out.println("卖完了");
            }
        }
    }
}

class ThreadTicket {

    public static void main(String[] args) {
        //资源共享
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        new Thread(mt, "1号窗口").start();
        new Thread(mt2, "2号窗口").start();
        new Thread(mt3, "3号窗口").start();
    }
}