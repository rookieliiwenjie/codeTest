package com.company.BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lwj32 on 2020/5/28.
 */
class MyABC {
    public volatile boolean FLAG = true;//默认开启进行消费和生产
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

    public void printA() throws InterruptedException {
        String x = blockingQueue.poll(2L, TimeUnit.SECONDS);
        if (x != null && !x.equalsIgnoreCase("")) {

            blockingQueue.offer("B", 2L, TimeUnit.SECONDS);
            System.out.println("x = " + x);
        }


    }

    public void printB() throws InterruptedException {
        String x = blockingQueue.poll(2L, TimeUnit.SECONDS);
        if (x != null && !x.equalsIgnoreCase("")) {

            blockingQueue.offer("c", 2L, TimeUnit.SECONDS);
            System.out.println("x = " + x);

        }
        atomicInteger.incrementAndGet();

    }

    public void printC() throws InterruptedException {
        while (atomicInteger.get() % 3 == 0) {
            if (atomicInteger.get() != 3) {
                String x = blockingQueue.poll(2L, TimeUnit.SECONDS);
                System.out.println("x = " + x);

            }
            atomicInteger.incrementAndGet();


            blockingQueue.offer("A", 2L, TimeUnit.SECONDS);


        }
    }
}

public class ABCBlock {
    public static void main(String[] args) {
        MyABC myABC = new MyABC();
        new Thread(() -> {
            try {
                myABC.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "S").start();
        new Thread(() -> {
            try {
                myABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();
        new Thread(() -> {
            try {
                myABC.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();

    }
}
