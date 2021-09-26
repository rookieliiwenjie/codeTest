/*
package com.company.ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

*/
/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-26 17:36
 *//*

public class ABCDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition lockA = lock.newCondition();
    private static Condition lockB = lock.newCondition();
    private static Condition lockC = lock.newCondition();
    static int count = 1;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            lock.lock();
            try {
                while (count % 3 == 1) {
                    System.out.println(" A");
                    lockA.await();
                }
                lockB.signal();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread b = new Thread(() -> {
            lock.lock();
            while (count % 3 == 2) {
                System.out.println("B");
                lockB.await();
            }
            lock.unlock();
        });
        Thread c = new Thread(() -> {
            while (count % 3 == 0) {
                System.out.println("C");
            }
        });
        a.start();
        b.start();
        c.start();
        while ()
    }
}
*/
