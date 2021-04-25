package com.company.并发编程.day08;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/2
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SyconDemo syconDemo = new SyconDemo();



        Thread thread2 = new Thread(() -> {
            syconDemo.read();
            System.out.println("syconDemo.flag QIAN = " + syconDemo.flag);
            while (!syconDemo.flag) {

            }
            System.out.println("syconDemo.flag HOU = " + syconDemo.flag);

        });
        thread2.start();

        //TimeUnit.SECONDS.sleep(10);
        Thread thread = new Thread(() -> {
            System.out.println(" write============== ");
            syconDemo.write();
            System.out.println(" ============== write");

        });
        thread.start();

    }
}
