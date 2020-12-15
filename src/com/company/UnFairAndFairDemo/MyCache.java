package com.company.UnFairAndFairDemo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lwj32 on 2020/5/24.
 */
public class MyCache {
    private volatile HashMap<String, Object> hashMap = new HashMap<>();
    ReentrantReadWriteLock rwLocke = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rwLocke.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入");
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hashMap.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } finally {
            rwLocke.writeLock().unlock();
        }

    }

    public void get(String key) {
        rwLocke.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读");
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = hashMap.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读完毕" + result);
        } finally {
            rwLocke.readLock().unlock();

        }

    }
}
