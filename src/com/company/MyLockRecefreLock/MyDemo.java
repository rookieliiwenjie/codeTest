package com.company.MyLockRecefreLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class MyDemo {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(()->{
            myLock.lock();

            System.out.println(" A");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unlock();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{

            myLock.lock();
            System.out.println(" B");
            myLock.unlock();
        },"B").start();
    }
}
