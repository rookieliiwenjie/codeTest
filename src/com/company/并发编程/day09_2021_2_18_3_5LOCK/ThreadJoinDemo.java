package com.company.并发编程.day09_2021_2_18_3_5LOCK;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/19
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
        synchronized (ThreadJoinDemo.class){
            try {
                System.out.println("开始A");
                ThreadJoinDemo.class.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            ThreadJoinDemo.class.notify();
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
