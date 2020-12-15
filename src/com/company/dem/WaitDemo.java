package com.company.dem;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitDemo {
    public static final Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + "T1 wait");
                    object.wait();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + "T1 end");
        }
    }
    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + "T2 no");
                object.notify();
                System.out.println(System.currentTimeMillis() + "T2 end");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                /* ��Ҫ��objectmoniter�û��������� */
//				AtomicInteger
            }

        }

    }

    public static void main(String args[]) {

        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();

        t2.start();


    }

}
