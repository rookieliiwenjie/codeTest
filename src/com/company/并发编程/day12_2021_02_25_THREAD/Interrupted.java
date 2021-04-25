package com.company.并发编程.day12_2021_02_25_THREAD;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class Interrupted {
    public static void main(String[] args) {
// sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
// busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        sleepThread.interrupt();
        busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleepThread 开始");


        System.out.println("sleepThread end");

        busyThread.interrupt();
        //System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        //打印错误信息
        try {
            System.out.println("Thread.activeCount() = " + Thread.activeCount());
            Thread.currentThread().getThreadGroup().list();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class SleepRunner extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().isInterrupted()+"start" );
            while (Thread.currentThread().isInterrupted()) {
                //强制当前线程复位
                Thread.interrupted();
                System.out.println("Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
            }
            System.out.println(Thread.currentThread().isInterrupted()+"end" );
            while (true) {
                try {

                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(" -----" );
                }
            }
        }
    }

    static class BusyRunner extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("InterruptedBusyRunner ----------- ");
                    break;
                }
            }

        }
    }
}
