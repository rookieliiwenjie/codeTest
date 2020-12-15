package com.company.dem;

import java.io.IOException;

public class MyRunnable implements Runnable {
    int a = 1;
    private int b = 2;
    static int c = 1;

    public static void main(String args[]) throws IOException {

        MyRunnable myRunnable = new MyRunnable();
        int c = MyRunnable.c;
        myRunnable.run();
        System.in.read();

    }

//定义线程要执行的run方法逻辑

    @Override

    public void run() {


        for (int i = 0; i < 10; i++) {

            System.out.println("我的线程：正在执行！" + i);

        }

    }

}