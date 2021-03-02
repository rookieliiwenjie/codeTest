package com.company.并发编程.day15_2021_03_02;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/2
 */
public class Join {
    public static void main(String[] args) {
       // Thread thread = new Thread(new Threaddmoe(),"A");
        Thread threadB = new Thread(new Threaddmoe(),"B");

        threadB.start();
        try {
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end" );

    }
    static class Threaddmoe implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        }
    }
}
