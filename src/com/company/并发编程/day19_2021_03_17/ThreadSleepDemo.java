package com.company.并发编程.day19_2021_03_17;

/**
 * @Author rookie.li
 * @create 2021/3/17
 */
public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        do {
            System.out.println("i = " + i);
            i++;
            Thread.sleep(1000);
            System.out.println("ibefore = " + i);

        } while (true && i < 1);
    }

}
