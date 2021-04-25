package com.company.并发编程.day19_2021_03_17;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author rookie.li
 * @create 2021/3/17
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
        //thread.interrupt();
        try {
            // c.reset();
            // c.await();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(c.isBroken());
        }*/
        countDownLatchDemo();
    }

    public static void countDownLatchDemo() throws InterruptedException {

            CountDownLatch countDownLatch = new CountDownLatch(3);
            Thread thread = new Thread(() -> {
                System.out.println(" 进入");
                countDownLatch.countDown();
                System.out.println("countDownLatch.getCount()  in thread= " + countDownLatch.getCount());
            });
            thread.start();
            System.out.println("countDownLatch.getCount()  start after= " + countDownLatch.getCount());
            thread.interrupt();
            Thread threadB = new Thread(() -> {
                System.out.println(" 进入");
                countDownLatch.countDown();
                System.out.println("countDownLatch.getCount()  in thread= " + countDownLatch.getCount());
            });
            threadB.start();
            System.out.println("countDownLatch.getCount()  interrupt after= " + countDownLatch.getCount());
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("countDownLatch = " + countDownLatch.getCount());
            }
            countDownLatch.await();
            System.out.println("完成");
        }

}

