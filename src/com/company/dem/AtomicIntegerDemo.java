package com.company.dem;

import java.util.concurrent.atomic.AtomicInteger;

//�ж��ǲ����̰߳�ȫ
public class AtomicIntegerDemo {
    static AtomicInteger a = new AtomicInteger();

    public static class Add implements Runnable {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                a.incrementAndGet();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread[] s = new Thread[10];
        for (int k = 0; k < 10; k++) {
            s[k] = new Thread(new Add());
        }
        for (int k = 0; k < 10; k++) {
            s[k].start();
        }
        for (int k = 0; k < 10; k++) {
            s[k].join();
        }
        System.out.println(a);

    }
}
