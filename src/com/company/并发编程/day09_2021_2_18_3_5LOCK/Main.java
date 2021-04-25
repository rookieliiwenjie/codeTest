package com.company.并发编程.day09_2021_2_18_3_5LOCK;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/19
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FinalExample finalExample = new FinalExample();
        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                finalExample.writer();

            }).start();
            TimeUnit.MILLISECONDS.sleep(10);
            new Thread(() -> {
                finalExample.reader();

            }).start();
        }

    }
}
