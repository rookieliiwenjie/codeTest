package com.company.并发编程.day16_2021_03_03;

import com.company.并发编程.day09_2021_2_18_3_5LOCK.ReecenrLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author rookie.li
 * @create 2021/3/3
 */
public class Demo {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.writeLock().lock();
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();

        } catch (Exception e) {

        }

    }
}
