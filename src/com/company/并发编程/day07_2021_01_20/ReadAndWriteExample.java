package com.company.并发编程.day07_2021_01_20;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/1/20
 */
public class ReadAndWriteExample {
    int a = 0;
    boolean flag = false;

    public void first() {
        a = 1;
        flag = true;
        System.out.println("first");
    }

    public void second() {
        System.out.println("second");
        while (!flag) {
            System.out.println("a+flag = " + a + flag + Thread.currentThread().getName());
            System.out.println("flag = " + flag);
            if (flag) {
                System.out.println("a+flag = " + a + flag + Thread.currentThread().getName());
                System.out.println("a*a = " + a * a);
            }
        }

    }

    public static void main(String[] args) {
        ReadAndWriteExample readAndWriteExample = new ReadAndWriteExample();
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readAndWriteExample.first();
        }, "first").run();

        System.out.println("readAndWriteExample = " + readAndWriteExample);
        new Thread(() -> {
            readAndWriteExample.second();

        }, "second").start();
        while (!readAndWriteExample.flag) {
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("readAndWriteExample.flag = " + readAndWriteExample.flag);
        }

    }


}
