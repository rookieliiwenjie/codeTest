package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/9 1:54 下午
 * @Description: A3 B 2 C 1 三轮
 */
public class A3B2C1SynchDemo {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(new PrintA(3, "A"));
        threadPoolExecutor.execute(new PrintB(3, "B"));
        threadPoolExecutor.execute(new PrintC(3, "C"));
        threadPoolExecutor.shutdown();
    }

    static class PrintA implements Runnable {
        int printNum;
        String name;

        public PrintA(int printNum, String name) {
            this.printNum = printNum;
            this.name = name;
        }

        public int getPrintNum() {
            return printNum;
        }

        public void setPrintNum(int printNum) {
            this.printNum = printNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < printNum; ) {
                lock.lock();
                try {
                    while (num.get() % 3 == 1) {
                        for (int j = 0; j < 3; j++) {
                            System.out.println(name);
                        }
                        num.incrementAndGet();
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintB implements Runnable {
        int printNum;
        String name;

        public PrintB(int printNum, String name) {
            this.printNum = printNum;
            this.name = name;
        }

        public int getPrintNum() {
            return printNum;
        }

        public void setPrintNum(int printNum) {
            this.printNum = printNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < printNum; ) {
                lock.lock();
                try {
                    while (num.get() % 3 == 2) {
                        for (int j = 0; j < 2; j++) {
                            System.out.println(name);
                        }
                        num.incrementAndGet();
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintC implements Runnable {
        int printNum;
        String name;

        public PrintC(int printNum, String name) {
            this.printNum = printNum;
            this.name = name;
        }

        public int getPrintNum() {
            return printNum;
        }

        public void setPrintNum(int printNum) {
            this.printNum = printNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < printNum; ) {
                lock.lock();
                try {
                    while (num.get() % 3 == 0) {
                        for (int j = 0; j < 1; j++) {
                            System.out.println(name);
                        }
                        num.incrementAndGet();
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
