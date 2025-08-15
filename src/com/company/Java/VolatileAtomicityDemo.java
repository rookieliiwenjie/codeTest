package com.company.Java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class VolatileAtomicityDemo {
    //    private static  int count = 0;
    static AtomicInteger count = new AtomicInteger(0);
    static LongAdder longAdder = new LongAdder();
    public synchronized void add() {
        count.compareAndSet(count.get(), count.get() + 1);
    }
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.add();
                }
            });
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("count = " + count);
        threadPool.shutdown();
    }
}
