package com.company.dem;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
    int a = 1;
    private int b = 2;
    static int c = 1;
    int time = 0;

    public MyRunnable() {
    }

    public MyRunnable(int time) {
        this.time = time;
    }

    public static void main(String args[]) throws IOException {

        MyRunnable myRunnable = new MyRunnable();
        int c = MyRunnable.c;
        myRunnable.run();
        System.in.read();

    }

//定义线程要执行的run方法逻辑

    @Override

    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        for (int i = 0; i < 10; i++) {
//
//            System.out.println("我的线程：正在执行！" + i);
//
//        }

    }

}