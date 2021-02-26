package com.company.并发编程.day012_2021_02_25_THREAD;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class DeamonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeamonThread(), "de");
        //thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("main线程执行完成");

    }

    static class DeamonThread implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (true) {
                System.out.println("i = " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}
