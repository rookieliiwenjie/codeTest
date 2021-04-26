package com.company.并发编程.day21_2021_04_20;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author rookie.li
 * @create 2021/4/20
 * 验证读写锁
 */
public class ReadAndWriteLockDemo {
    static Map<String, String> hashMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    public void set(String key, String value) {
        w.lock();
        try {
            //System.out.println("set name = " + Thread.currentThread().getName());
            hashMap.put(key, value);

        } catch (Exception e) {

        } finally {
            w.unlock();
        }
    }

    public Object get(String key) {
        r.lock();
        try {
            System.out.println(" name = " + Thread.currentThread().getName());
            System.out.println(" 睡眠 = "
                    + System.currentTimeMillis()
                    + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(" 睡眠后 = "
                    + System.currentTimeMillis()
                    + Thread.currentThread().getName());
            return hashMap.get(key);
        } catch (Exception e) {

        } finally {
            r.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReadAndWriteLockDemo readAndWriteLockDemo = new ReadAndWriteLockDemo();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                readAndWriteLockDemo.set(String.valueOf(finalI), String.valueOf(finalI));
                System.out.println("set = " + finalI);
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("get = " + readAndWriteLockDemo.get(String.valueOf(finalI)));

            }).start();

        }
    }
}
