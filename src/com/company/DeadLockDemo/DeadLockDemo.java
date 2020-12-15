package com.company.DeadLockDemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2020/6/1.
 */
class MyHoldLock implements Runnable {
    String lockA;
    String lockB;
    String name;

    MyHoldLock(String lockA, String lockB, String name) {
        this.lockA = lockA;
        this.lockB = lockB;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "自己持有 = " + lockA + "尝试获得lockb");
            try {
                TimeUnit.SECONDS.sleep(1L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {

                System.out.println(Thread.currentThread().getName() + "自己持有 = " + lockB + "尝试获得" + lockA);
                try {
                    TimeUnit.SECONDS.sleep(1L);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        String locka = "LockA";
        String lockb = "LockB";
        new Thread(new MyHoldLock(locka, lockb, locka), "AAA").start();
        new Thread(new MyHoldLock(lockb, locka, lockb), "BBB").start();
    }
}
