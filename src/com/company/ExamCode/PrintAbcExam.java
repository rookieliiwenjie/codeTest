package com.company.ExamCode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintAbcExam {
    public static Lock lock = new ReentrantLock();
    static AtomicInteger count = new AtomicInteger(1);
    static Condition aPrint = lock.newCondition();
    static Condition bPrint = lock.newCondition();
    static Condition cPrint = lock.newCondition();

    public static void main(String[] args) {
        PrintA a = new PrintA();
        PrintB b = new PrintB();
        PrintC c = new PrintC();
        a.start();
        b.start();
        c.start();

    }

    static class PrintA extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count.get() % 3 == 1) {
                        try {
                            aPrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    count.incrementAndGet();
                    bPrint.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class PrintB extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count.get() % 3 != 2) {
                        try {
                            bPrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    count.incrementAndGet();
                    cPrint.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class PrintC extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {

                for (int i = 0; i < 10; i++) {
                    while (count.get() % 3 != 0) {
                        try {
                            cPrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count.incrementAndGet();
                    System.out.println("C");
                    aPrint.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}