package com.company.并发编程.day19_2021_03_17;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/17
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(" start");
        Thread thread = new Thread(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" ----");
                }
        );
        thread.start();


        System.out.println("end ");

    }
}
