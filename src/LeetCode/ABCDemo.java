package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/8 4:42 下午
 * @Description:
 */
public class ABCDemo {
    private static final Object logck = new Object();
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.start();
        b.start();
        c.start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (logck) {
                    while (atomicInteger.get() != 0) {
                        try {
                            logck.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A" + Thread.currentThread().getName());
                    atomicInteger.set(1);
                    logck.notifyAll();

                }
            }

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (logck) {
                    while (atomicInteger.get() != 1) {
                        try {
                            logck.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("B" + Thread.currentThread().getName());
                    atomicInteger.set(2);
                    logck.notifyAll();

                }
            }

        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (logck) {
                    while (atomicInteger.get() != 2) {
                        try {
                            logck.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("C" + Thread.currentThread().getName());
                    atomicInteger.set(0);
                    logck.notifyAll();

                }
            }

        }
    }
}
