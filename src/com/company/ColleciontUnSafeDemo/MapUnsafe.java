package com.company.ColleciontUnSafeDemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lwj32 on 2020/5/21.
 */
public class MapUnsafe {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<String, String> map = new Hashtable<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
            }, String.valueOf(i)).start();
        }
        System.out.println("HashTable 消耗时间 \t" + (System.currentTimeMillis() - start));
        long startCo = System.currentTimeMillis();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                concurrentHashMap.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
            }, String.valueOf(i)).start();
        }
        System.out.println("ConcurrentHashMap 消耗时间" + (System.currentTimeMillis() - startCo));
        /**
         * HashTable 消耗时间 	2305
         * ConcurrentHashMap 消耗时间1960
         */
    }
}
