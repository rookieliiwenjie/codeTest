package com.company.并发编程.day12_2021_02_25_THREAD;

import com.company.dem.WaitDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class ThreadStateDemo {
    public static void main(String[] args) {
        new Thread(new TimeWaitDemo(), "TimeWaitingThread").start();
        new Thread(new waitDemo(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

    }
    static class  waitDemo implements Runnable{

        @Override
        public void run() {
            synchronized (WaitDemo.class){

                try {
                    WaitDemo.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static  class  TimeWaitDemo implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class  Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

