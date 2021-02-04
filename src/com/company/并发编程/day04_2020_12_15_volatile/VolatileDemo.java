package com.company.并发编程.day04_2020_12_15_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author rookie.li
 * @create 2020/12/15
 */
public class VolatileDemo {
    VolatileDemo volatileDemo = new VolatileDemo();
    volatile static int x = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        String s = "";
        s.equals(2);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    //System.out.println("x = " + x);
                    x=x+1;
                    atomicInteger.getAndIncrement();
                }
            }, "a").start();
        }
        while (Thread.activeCount() > 2) {

        }
        System.out.println("=======i======= = " + x);
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }
}
