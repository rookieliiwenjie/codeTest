package com.company.并发编程.day08;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author rookie.li
 * @create 2021/2/2
 */
public class SyconDemo {
    volatile boolean flag = false;
    int a = 0;

    public  void write() {
        a = 1;
        flag = true;
    }

    public  void read() {
        if (flag) {
            int i = a;
            System.out.println("a = " + a);
        }
    }

}
