package com.company.BlockingQueueDemo;

import java.util.concurrent.Semaphore;

/**
 * Created by lwj32 on 2020/5/27.
 */
public class ProductAndCuDemo2 {
    private static volatile Semaphore semaphoreP = new Semaphore(1);
    private static volatile Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            new Thread(new ProductThread()).start();
            new Thread(new CouThread()).start();
        }
    }

    static class ProductThread implements Runnable {

        @Override
        public void run() {
            try {
                semaphoreP.acquire();
                System.out.println("生成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphoreC.release();
            }

        }
    }

    static class CouThread implements Runnable {

        @Override
        public void run() {

            try {
                semaphoreC.acquire();
                System.out.println("消费");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphoreP.release();
            }
        }
    }
}
