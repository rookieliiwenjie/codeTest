package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/10 3:12 下午
 * @Description:
 */
public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            try {
                System.out.println("before executorService = " + Thread.currentThread().getName());
                cyclicBarrier.await();
                System.out.println("after executorService = " + Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("before executorService = " + Thread.currentThread().getName());
                cyclicBarrier.await();
                System.out.println("after executorService = " + Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


        executorService.submit(() -> {
            try {
                System.out.println("before executorService = " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("----------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cyclicBarrier.await();

                System.out.println("after executorService = " + Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        System.out.println(" 开始  isBroken------" + cyclicBarrier.isBroken());
        System.out.println(" 开始  getParties-------" + cyclicBarrier.getParties());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cyclicBarrier.reset();
        System.out.println(" 完成  isBroken" + cyclicBarrier.isBroken());
        System.out.println(" 完成  isBroken" + cyclicBarrier.getParties());
        executorService.shutdown();
        //cyclicBarrier.reset();
    }
}
