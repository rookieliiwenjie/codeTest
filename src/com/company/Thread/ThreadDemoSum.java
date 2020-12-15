package com.company.Thread;

class MyThread implements Runnable {

    private int ticket = 10;  //10张车票

    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在卖票：" + this.ticket--);
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
        new Thread(mt, "2号窗口").start();
        new Thread(mt, "3号窗口").start();

    }
}