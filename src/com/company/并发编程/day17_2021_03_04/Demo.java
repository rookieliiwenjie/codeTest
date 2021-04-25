package com.company.并发编程.day17_2021_03_04;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/4
 */
public class Demo {
   static MeuxLock meuxLock = new MeuxLock();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new ThreadDemo(),"A");
        Thread threadB = new Thread(new ThreadDemo(),"B");
        threadB.start();
        threadA.interrupt();
        threadA.start();

    }
    static class ThreadDemo implements Runnable{

        @Override
        public void run() {
            meuxLock.lock();
            System.out.println(" main +Thread.currentThread().getName() = " + Thread.currentThread().getName());
            meuxLock.unlock();
        }
    }
}
