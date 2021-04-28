package com.company.并发编程.day_23_04_27_Contion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author rookie.li
 * @create 2021/4/27
 */
public class ConditionDemo {
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    private static String state = "A";

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (!("A".equals(state))) {
                        conditionA.await();
                        conditionA.awaitUninterruptibly();
                    }
                    state = "B";
                    System.out.println("A");
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A");
        Thread B = new Thread(() ->

        {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (!state.equals("B")) {
                        conditionB.await();
                    }
                    state = "C";
                    System.out.println("B");
                    conditionC.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "B");


        Thread C = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    if (!state.equals("C")) {
                        conditionC.await();
                    }
                    state = "A";
                    System.out.println("C");
                    conditionA.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "C");
        A.start();
        C.isInterrupted();
        Thread.interrupted();
        B.start();
        C.start();

    }
}
