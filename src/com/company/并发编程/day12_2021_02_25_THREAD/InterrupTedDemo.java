package com.company.并发编程.day12_2021_02_25_THREAD;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2021/5/25.
 */
public class InterrupTedDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new ThreadOne());
        System.out.println("  start" );

        threadOne.start();
        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();
        System.out.println("  sleep" );
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadOne.interrupt();
        threadTwo.interrupt();
        System.out.println("threadTwo.isInterrupted() = " + threadTwo.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadTwo.isInterrupted() = " + threadTwo.isInterrupted());
        System.out.println("threadOne.isInterrupted() = " + threadOne.isInterrupted());
    }
}
class ThreadOne implements Runnable {

    @Override
    public void run() {
        while (true){

        }
    }
}
class ThreadTwo implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(" ====== " );
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
