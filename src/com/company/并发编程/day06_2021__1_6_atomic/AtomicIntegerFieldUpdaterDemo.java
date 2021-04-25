package com.company.并发编程.day06_2021__1_6_atomic;

import com.company.SingleonDemo.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author rookie.li
 * @create 2021/1/6
 */
public class AtomicIntegerFieldUpdaterDemo {
    int count = 100;
    static AtomicIntegerFieldUpdaterDemo atomicIntegerFieldUpdaterDemo = new AtomicIntegerFieldUpdaterDemo();

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> atomic =
                AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "count");
        atomic.compareAndSet(atomicIntegerFieldUpdaterDemo, 100, 200);
        System.out.println("atomic = " + atomicIntegerFieldUpdaterDemo.count);
        atomic.compareAndSet(atomicIntegerFieldUpdaterDemo, 100, 300);
        System.out.println("atomic = " + atomicIntegerFieldUpdaterDemo.count);
    }
}
