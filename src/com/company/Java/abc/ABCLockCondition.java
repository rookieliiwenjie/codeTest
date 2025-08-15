package com.company.Java.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ABCLockCondition {
    static ReentrantLock lock = new ReentrantLock();
    static int state = 0;
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            print(conditionA, conditionB, "A", 0);
        });
        Thread b = new Thread(() -> {
            print(conditionB, conditionC, "B", 1);
        });
        Thread c = new Thread(() -> {
            print(conditionC, conditionA, "C", 2);
        });
        a.start();
        b.start();
        c.start();
    }

    public static void print(Condition now, Condition after, String name, Integer targetState) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            while (state % 3 != targetState) {
                try {
                    now.await();
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            state++;
            after.signal();
            lock.unlock();
        }
    }
}
