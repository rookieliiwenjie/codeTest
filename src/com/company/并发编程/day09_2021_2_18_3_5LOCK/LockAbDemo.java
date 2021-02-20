package com.company.并发编程.day09_2021_2_18_3_5LOCK;

/**
 * @Author rookie.li
 * @create 2021/2/18
 */
public class LockAbDemo {
    volatile int  a = 0;
    public synchronized void writed(){
        a++;
    }
    public synchronized void reader(){
        int i = a;
        //System.out.println("i = " + i);
    }

}
