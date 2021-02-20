package com.company.并发编程.day09_2021_2_18_3_5LOCK;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/19
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        ThreadJoinDemo t = new ThreadJoinDemo();
        Thread threadA = new Thread(()->{
        synchronized (t){
            try {
                System.out.println("开始A");
                t.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            t.notify();
        }

        },"A");

        Thread threadB = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"B");
        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();


    }
}
