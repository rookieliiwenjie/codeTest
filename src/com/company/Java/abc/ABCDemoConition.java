package com.company.Java.abc;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCDemoConition {
    private static AtomicInteger state = new AtomicInteger(0);
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            print(conditionB, conditionA, "A", 0);
        });
        Thread b = new Thread(() -> {
            print(conditionC, conditionB, "B", 1);
        });
        Thread c = new Thread(() -> {
            print(conditionA, conditionC, "C", 2);
        });
        a.start();
        b.start();
        c.start();

    }

    public static void print(Condition nextLock, Condition myLock, String name, Integer tarGetstate) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (state.get() % 3 != tarGetstate) {
                    try {
                        myLock.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                state.getAndIncrement();
                System.out.println(name);
                nextLock.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }
}
