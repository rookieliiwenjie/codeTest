package com.company.ExamCode;

import com.company.SingleonDemo.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-09 17:36
 */
public class ABCDemo2 {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition APrint = reentrantLock.newCondition();
    static Condition BPrint = reentrantLock.newCondition();
    static Condition CPrint = reentrantLock.newCondition();
    static volatile int state = 1;

    static class AprintThread extends Thread {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (state % 3 != 1) {
                        try {
                            APrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(" A ");
                    state++;
                    BPrint.signalAll();
                }
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
            }

        }
    }

    static class BprintThread extends Thread {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (state % 3 != 2) {
                        try {
                            BPrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(" B");
                    state++;
                    CPrint.signalAll();
                }
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
            }

        }
    }

    static class CprintThread extends Thread {

        @Override
        public void run() {

            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (state % 3 != 0) {
                        try {
                            CPrint.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(" C");
                    state++;
                    APrint.signalAll();
                }
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        AprintThread aPrint = new AprintThread();
        aPrint.start();
        BprintThread bprintThread = new BprintThread();
        bprintThread.start();
        CprintThread cprintThread = new CprintThread();
        cprintThread.start();
    }
}

