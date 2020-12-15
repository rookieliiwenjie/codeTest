package com.company.UnFairAndFairDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lwj32 on 2020/5/24.
 * 自旋锁：实现原理unsafe+CAS
 * 不会引起线程的阻塞，而是采用循环的方式去获取锁，这样的好处是减少线程上下文切换的消耗，缺点就是会引起cpu的消耗
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {

        }
        System.out.println(Thread.currentThread().getName() + " myLock");
    }

    public void unMyLock() {
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + "unMyLock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.unMyLock();
            }
        }, "A").start();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            spinLockDemo.myLock();
        }, "C").start();
    }
}
