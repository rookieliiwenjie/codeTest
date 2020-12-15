package com.company.ABADemo;

/**
 * Created by lwj32 on 2020/5/17.
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 问题描述：CAS操作是在取某一时间内存中的值，因此会出现一个时间差问题
 * 举例：当A线程取值时为 1，线程B取值时也是1，但线程B首先将1变成2，然后再将2变为1，这个过程线程A是不感知的，
 * 因此线程A任然可以将1，改为其他数值下面方法一模仿ABA过程，这
 */
public class AbaDemo {
    public static void main(String args[]) {
        //AbaFuntion();
        AbaFuntion2();
    }

    //ABA问题复现
    public static void AbaFuntion() {
        AtomicInteger atomicInteger = new AtomicInteger();
        new Thread(() -> {
            atomicInteger.set(1);
            atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.get());
            atomicInteger.compareAndSet(2, 1);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.get());
        }, "A").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                atomicInteger.compareAndSet(1, 2019);
                System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "B").start();
        System.out.println("=============ABA问题产生======");
    }

    //ABA问题解决
    public static void AbaFuntion2() {
        AtomicStampedReference atomicInteger = new AtomicStampedReference(100, 1);
        System.out.println("=============ABA问题解决======");

        new Thread(() -> {
            int stamp = atomicInteger.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(100, 101, atomicInteger.getStamp(), atomicInteger.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.getReference() + "\t" + atomicInteger.getStamp());
            atomicInteger.compareAndSet(101, 100, atomicInteger.getStamp(), atomicInteger.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicInteger.getReference() + "\t" + atomicInteger.getStamp());
        }, "A").start();
        new Thread(() -> {

            int stamp = atomicInteger.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Lock lock = new ReentrantLock();
            lock.lock();
            boolean reustlt = atomicInteger.compareAndSet(100, 2019, atomicInteger.getStamp(), atomicInteger.getStamp()+1);
            System.out.println(reustlt + Thread.currentThread().getName() + "\t" + atomicInteger.getReference() + "\t" + atomicInteger.getStamp());
        }, "B").start();
    }
}
