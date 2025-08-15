package com.company.Java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrankLockDemo {
    private static int state = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread a = new Thread(() -> {
            print(lock, condition,"A", 0);
        });
        Thread b = new Thread(() -> {
            print(lock, condition,"B", 1);
        });
        Thread c = new Thread(() -> {
            print(lock, condition,"C", 2);
        });
        a.start();
        b.start();
        c.start();

    }
    public static void print(ReentrantLock lock, Condition condition,String name, Integer tarGetstate) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (state % 3 != tarGetstate) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(name);
                state++;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
