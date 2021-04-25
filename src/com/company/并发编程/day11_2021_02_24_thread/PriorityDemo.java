package com.company.并发编程.day11_2021_02_24_thread;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread threada = new ThreadA();
        Thread threadb = new ThreadB();
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threada.setPriority(Thread.MIN_PRIORITY);
        threadb.setPriority(Thread.MAX_PRIORITY);

        threada.start();
        threadb.start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadA--" + i);
            Thread.yield();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadB--" + i);
            Thread.yield();
        }
    }
}

