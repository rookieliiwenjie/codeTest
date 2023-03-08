package com.company.javaEigt.JavaEightDemo.threaddemo;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/8 2:47 下午
 * @Description:
 */
public class AbcPrintReentrantLockDemo {
    private static AtomicInteger num = new AtomicInteger(1);
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(new PrintA());
        threadPoolExecutor.execute(new PrintB());
        threadPoolExecutor.execute(new PrintC());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num = " + num.get());
        threadPoolExecutor.shutdown();
    }

    static class PrintA implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            while (num.get() <= 30) {
                reentrantLock.lock();
                try {
                    while (num.get() <= 30 && num.get() % 3 == 1) {
                        System.out.println(" A ");
                        num.incrementAndGet();
                    }
                } catch (Exception e) {
                    throw new Exception(e);
                } finally {
                    reentrantLock.unlock();
                }

            }
        }
    }

    static class PrintB implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            while (num.get() <= 30) {
                reentrantLock.lock();
                try {
                    while (num.get() <= 30 && num.get() % 3 == 2) {
                        System.out.println(" B ");
                        num.incrementAndGet();
                    }
                } catch (Exception e) {
                    throw new Exception(e);
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }

    static class PrintC implements Runnable {
        @SneakyThrows
        @Override
        public void run() {

            while (num.get() <= 30) {
                reentrantLock.lock();
                try {
                    while (num.get() <= 30 && num.get() % 3 == 0) {
                        System.out.println(" C ");
                        num.incrementAndGet();
                    }
                } catch (Exception e) {
                    throw new Exception(e);
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }
}
