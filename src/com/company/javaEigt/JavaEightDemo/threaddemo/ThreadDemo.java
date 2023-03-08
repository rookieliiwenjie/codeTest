package com.company.javaEigt.JavaEightDemo.threaddemo;

import com.company.rocketMqDemo.ThreadFactoryImpl;

import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/7 3:16 下午
 * @Description: 测试销毁线程是谁，根据测试随机删除，而不是删除后创建的最大线程。
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 6, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10), new ThreadFactoryImpl("ThreadPoolName"), new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            int activeCountBefore = poolExecutor.getActiveCount();
            System.out.println("activeCountBefore = " + activeCountBefore);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            int activeCountAfter = poolExecutor.getActiveCount();
            System.out.println("activeCountAfter = " + activeCountAfter);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (int i = 0; i < 10; i++) {
//            poolExecutor.execute(() -> {
//                System.out.println("100000Thread.currentThread().getName() = " + Thread.currentThread().getName());
//            });
//            int activeCount = poolExecutor.getActiveCount();
//            System.out.println("activeCount = " + activeCount);
//        }
//
//
//        try {
//            TimeUnit.MINUTES.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        for (int i = 0; i < 100000; i++) {
            poolExecutor.execute(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            });
            int activeCount = poolExecutor.getActiveCount();
            System.out.println("activeCount = " + activeCount);
        }
        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 15; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            poolExecutor.execute(() -> {
                System.out.println("------Thread.currentThread()------.getName() = " + Thread.currentThread().getName());
            });
            int activeCount = poolExecutor.getActiveCount();
            System.out.println("activeCount = " + activeCount);
        }


        poolExecutor.shutdown();

    }
}
