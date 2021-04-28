package com.company.并发编程.day22_04_26;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author rookie.li
 * @create 2021/4/26
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        System.out.println(" main begin ");
        Thread thread = new Thread(() -> {
            System.out.println(" begin ");
            LockSupport.park(Thread.currentThread().getName());
            try {
                System.out.println(" Time");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" time after ");
            System.out.println(" after");

        }, "A");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println("blocker = " + blocker);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
        Object afterblocker = LockSupport.getBlocker(thread);
        System.out.println("after blocker = " + afterblocker);
        System.out.println(" main end ");
    }
}
