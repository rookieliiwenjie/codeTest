package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/10 10:41 上午
 * @Description:
 */
public class CountDownLatchABCDemo {

    private static CountDownLatch countDownLatchA = new CountDownLatch(3);

    public static void main(String[] args) {
        countDownLatch();
    }

    public static void countDownLatch() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println("before Thread.currentThread().getName() = " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("after Thread.currentThread().getName() = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatchA.countDown();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println("before Thread.currentThread().getName() = " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
                System.out.println("after Thread.currentThread().getName() = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatchA.countDown();
            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println("before Thread.currentThread().getName() = " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(20);
                System.out.println("after Thread.currentThread().getName() = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatchA.countDown();
            }
        });
        try {
            countDownLatchA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 主线程执行完成 ");
        threadPoolExecutor.shutdown();


    }
}
