package com.company.Java;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {




        Thread thread = new Thread(() -> {
            Integer val = threadLocal.get();
            val++;
            threadLocal.set(val);
            System.out.println(threadLocal.get());
        });
        Thread thread2 = new Thread(() -> {
            Integer val = threadLocal.get();
            val++;
            threadLocal.set(val);
            System.out.println(threadLocal.get());
        });
        thread2.start();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println( threadLocal.get());

    }

    class Task implements Runnable {
        @Override
        public void run() {
            Integer val = threadLocal.get();
            val++;
            threadLocal.set(val);
        }
    }
}
