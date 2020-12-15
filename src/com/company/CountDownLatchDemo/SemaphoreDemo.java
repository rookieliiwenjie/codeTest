package com.company.CountDownLatchDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2020/5/26.
 * CountDownLatch做减法，CyclicBarrier做减法，
 * 多个线程抢多个资源
 * 目的1.为了用于多个共享资源的互斥使用，2.另一个用于并发线程数的控制
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t入库");
                    System.out.println(Thread.currentThread().getName() + "\t停车2秒");
                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "\t出库");
                }

            }, String.valueOf(i)).start();
        }

    }

}
