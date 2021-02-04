package com.company.并发编程.day08;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author rookie.li
 * @create 2021/2/2
 */
public class SyconDemo {
    volatile boolean flag = true;
    int a = 0;
    public synchronized void write() {
        a = 1;
        flag = false;
    }

    public synchronized void read() {
        if (!flag) {
            int i = a;
            System.out.println("a = " + a);
        }
    }

}
