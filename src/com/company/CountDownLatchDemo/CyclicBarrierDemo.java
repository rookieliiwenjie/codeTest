package com.company.CountDownLatchDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lwj32 on 2020/5/26.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("完成打野");
        });
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "go\n");
                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

    public static void x() {
        System.out.println("结束");

    }

}
