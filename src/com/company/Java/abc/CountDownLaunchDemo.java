package com.company.Java;

import LeetCode.Strig.Count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLaunchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        setCountDownLatch();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.getCount();
        System.out.println("-----" + countDownLatch.getCount());
        setCountDownLatch();
    }

    public static void setCountDownLatch() {
        Thread thread = new Thread(() -> {
            try {

                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println("thread end");
            System.out.println("thread end-----" + countDownLatch.getCount());
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println("thread2 end");
        });
        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("thread end-----" + countDownLatch.getCount());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println("thread3 end");
            System.out.println("thread end-----" + countDownLatch.getCount());
        });
        thread3.start();
        thread.start();
        thread2.start();
        try {
            countDownLatch.await();
            System.out.println("完成"+countDownLatch.getCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
