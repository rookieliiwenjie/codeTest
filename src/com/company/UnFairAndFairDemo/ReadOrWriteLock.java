package com.company.UnFairAndFairDemo;

/**
 * Created by lwj32 on 2020/5/24.
 * 独占锁：指该锁只能被一个线程所持有，
 * 共享锁：指该锁被多个线程所拥有,
 * 如果有一个线程想去写共享资源，就不应该再有其他
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 */
public class ReadOrWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int temint = i;
            new Thread(() -> {
                myCache.put(String.valueOf(temint), temint);
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tmeint = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tmeint));
            }, String.valueOf(i)).start();
        }

    }
}
