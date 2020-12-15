package com.company.CountDownLatchDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lwj32 on 2020/5/25.
 */
public class  CounntDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("秦国完成大业");
            }
        });
        for(int i = 0;i<10;i++){
            int finalI = i;
            new Thread(()->{
                try {

                    cyclicBarrier.await();
                    System.out.println(  finalI+" 别灭 ");



                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

      /*  CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 被灭");

                countDownLatch.countDown();


            }, CountryEnum.CountryForEach(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "统一");*/
    }
}
