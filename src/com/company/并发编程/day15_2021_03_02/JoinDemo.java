package com.company.并发编程.day15_2021_03_02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/2
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread nowThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadJoinDemo(nowThread), i + "");
            thread.start();
            nowThread = thread;
        }
        //TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

    static class ThreadJoinDemo implements Runnable {
        Thread thread;

        public ThreadJoinDemo(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "     " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        }
    }
}
