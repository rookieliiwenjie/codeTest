package com.company.javaEigt.JavaEightDemo.threaddemo;

import com.company.rocketMqDemo.ThreadFactoryImpl;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/8 2:47 下午
 * @Description:
 */
public class AbcPrintDemo {
    private volatile static int num = 1;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(new PrintA("A", 10));
        threadPoolExecutor.execute(new PrintC("C", 10));
        threadPoolExecutor.execute(new PrintB("B", 10));
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        threadPoolExecutor.shutdown();
    }

    static class PrintA implements Runnable {

        String name;
        int printNum;

        public PrintA(String name, int printNum) {
            this.name = name;
            this.printNum = printNum;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < this.printNum;) {
                synchronized (obj) {
                    while (num % 3 != 1) {
                        obj.wait();
                    }
                    System.out.println(name);
                    num++;
                    i++;
                    obj.notifyAll();
                }
            }
        }
    }

    static class PrintB implements Runnable {
        String name;
        int printNum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrintNum() {
            return printNum;
        }

        public void setPrintNum(int printNum) {
            this.printNum = printNum;
        }

        public PrintB(String name, int printNum) {
            this.name = name;
            this.printNum = printNum;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < this.printNum; ) {
                synchronized (obj) {
                    while (num % 3 != 2) {
                        obj.wait();
                    }
                    System.out.println(name);
                    num++;
                    i++;
                    obj.notifyAll();
                }
            }
        }
    }

    static class PrintC implements Runnable {
        String name;
        int printNum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrintNum() {
            return printNum;
        }

        public void setPrintNum(int printNum) {
            this.printNum = printNum;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < this.printNum; ) {
                synchronized (obj) {
                    while (num % 3 != 0) {
                        obj.wait();
                    }
                    System.out.println(name);
                    num++;
                    i++;
                    obj.notifyAll();
                }
            }
        }
        public PrintC(String name, int printNum) {
            this.name = name;
            this.printNum = printNum;
        }
    }
}
