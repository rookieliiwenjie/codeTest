package com.company.并发编程.day_23_04_27_Contion;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/4/27
 */
public class ObjeceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(" lock begin ");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" lock after");
            }

        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (lock){
                System.out.println(" main begin");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }

}
