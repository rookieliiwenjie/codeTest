package com.company.ColleciontUnSafeDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lwj32 on 2020/5/19.
 */
public class ArrayListTimeDemo {
    public static void main(String args[]) {
        functionA();
        functionB();
    }

    public static void functionA() {
        long startTime = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.size() + "\t" + arrayList);
        System.out.println("添加耗时:" + (System.currentTimeMillis() - startTime) + "");
    }

    public static void functionB() {
        long startTime = System.currentTimeMillis();
        List<Integer> arrayList = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            executor.submit(() -> {
                arrayList.add(atomicInteger.getAndAdd(1));
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size() + "\t" + arrayList);
        System.out.println("添加耗时:" + (System.currentTimeMillis() - startTime) + "");
    }
}
