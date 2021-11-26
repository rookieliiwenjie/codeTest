package com.company.并发编程.day20_2021_04_16;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author rookie.li
 * @create 2021/4/15
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
