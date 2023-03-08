package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/9 5:22 下午
 * @Description:
 */
public class SemaphoreAbcDemo {
//    private static Semaphore semaphoreA = new Semaphore(0);
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644878
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644879
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644879
//    A Thread.currentThread().getName()+pool-1-thread-1System.currentTimeMillis() = 1675997644879
//    A
//            A
//    A
//    A Thread.currentThread().getName()+pool-1-thread-1System.currentTimeMillis() = 1675997644879
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644879
//    B
//            B
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644880
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644880
//    C
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644880
//    A Thread.currentThread().getName()+pool-1-thread-1System.currentTimeMillis() = 1675997644880
//    A
//            A
//    A
//    A Thread.currentThread().getName()+pool-1-thread-1System.currentTimeMillis() = 1675997644880
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644880
//    B
//            B
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644880
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644880
//    C
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644880
//    A Thread.currentThread().getName()+pool-1-thread-1System.currentTimeMillis() = 1675997644880
//    A
//            A
//    A
//    B Thread.currentThread().getName()+pool-1-thread-2System.currentTimeMillis() = 1675997644880
//    B
//            B
//    C Thread.currentThread().getName()+pool-1-thread-3System.currentTimeMillis() = 1675997644880
//    C
private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(1);
    private static Semaphore semaphoreC = new Semaphore(1);
    private static int num = 1;

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
                try {
                    semaphoreA.acquire();
                    System.out.println(name + " Thread.currentThread().getName()+" + Thread.currentThread().getName() + "System.currentTimeMillis() = " + System.currentTimeMillis());
                    while (num % 3 == 1) {
                        for (int j = 0; j < 3; j++) {
                            System.out.println(name);
                        }
                        num++;
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreB.release();
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
                try {
                    semaphoreB.acquire();
                    System.out.println(name + " Thread.currentThread().getName()+" + Thread.currentThread().getName() + "System.currentTimeMillis() = " + System.currentTimeMillis());
                    while (num % 3 == 2) {
                        for (int j = 0; j < 2; j++) {
                            System.out.println(name);
                        }
                        num++;
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreC.release();
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
                try {
                    semaphoreC.acquire();
                    System.out.println(name + " Thread.currentThread().getName()+" + Thread.currentThread().getName() + "System.currentTimeMillis() = " + System.currentTimeMillis());

                    while (num % 3 == 0) {
                        for (int j = 0; j < 1; j++) {
                            System.out.println(name);
                        }
                        num++;
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreA.release();
                }
            }

        }
    }
}
