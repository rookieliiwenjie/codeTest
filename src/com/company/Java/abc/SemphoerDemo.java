package com.company.Java.abc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoerDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();
                System.out.println("thread end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();
                System.out.println("thread2 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();
                System.out.println("thread3 4 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();
                System.out.println("Thread 4 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
