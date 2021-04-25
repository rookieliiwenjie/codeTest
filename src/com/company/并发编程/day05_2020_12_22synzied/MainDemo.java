package com.company.并发编程.day05_2020_12_22synzied;

import com.company.SingleonDemo.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author rookie.li
 * @create 2020/12/22
 */
public class MainDemo {
    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        MainDemo mainDemo = new MainDemo();

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                mainDemo.add();

            }
        }, "A");
        threadA.start();

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                mainDemo.add();
            }
        }, "B");
        Thread threadC = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                mainDemo.add();
            }
        }, "C");
        threadC.start();
        thread.start();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.set(1);
        AtomicIntegerFieldUpdater<Integer> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Integer.class,"vo");
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
       /* while (Thread.activeCount() > 2) {
            Thread.yield();
            //;
            //System.out.println("Thread.activeCount() = " + Thread.currentThread().getName());
        }*/
        // System.out.println("Thread.activeCount() = " + Thread.activeCount());
        //"ss".intern();
        thread.join();
        threadA.join();
        System.out.println("x = " + x);

    }

    public synchronized void add() {
        x++;
        //System.out.println(Thread.currentThread().getName() + "x = " + x);
    }
}
