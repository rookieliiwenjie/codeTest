package com.company.ExamCode;

import com.company.SingleonDemo.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2.写两个线程，一个线程打印 1~52，另一个线程打印字母A-Z。打印顺序为12A34B56C……5152Z
 *
 * @author rookie.li
 * @date 2021-10-15 16:16
 */
public class AliExamThreadPrint {
    static AtomicInteger nums = new AtomicInteger(1);
    static AtomicInteger tatal = new AtomicInteger(0);
    final static ReentrantLock reentrantLock = new ReentrantLock();
    final static Condition conditionNum = reentrantLock.newCondition();
    final static Condition conditionChar = reentrantLock.newCondition();

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        PrintChar printChar = new PrintChar();
        printNum.start();
        printChar.start();
    }

    static class PrintNum extends Thread {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                while (nums.get() <= 52) {
                    while (tatal.get() > 1) {
                        conditionNum.await();
                    }
                    System.out.println(nums.get());
                    nums.addAndGet(1);
                    tatal.addAndGet(1);
                    conditionChar.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }
    }

    static class PrintChar extends Thread {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 24; i++) {
                    while (tatal.get() < 2) {
                        conditionChar.await();
                    }
                    System.out.println("A");
                    tatal.set(0);
                    conditionNum.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
