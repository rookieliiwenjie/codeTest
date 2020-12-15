package com.company.UnFairAndFairDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2020/5/24.
 */

public class AbcDemo {
    //对象锁
    private static int state = 1;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        //重入锁
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();


    }


    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    reentrantLock.lock();
                    while (state % 3 == 1) {
                        System.out.println("A");
                        state++;
                        i++;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    reentrantLock.lock();
                    while (state % 3 == 2) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                try {
                    reentrantLock.lock();
                    while (state % 3 == 0) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }


}
