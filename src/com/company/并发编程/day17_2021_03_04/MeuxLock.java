package com.company.并发编程.day17_2021_03_04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author rookie.li
 * @create 2021/3/4
 * 自己实现锁
 */
public class MeuxLock {
    static AtomicInteger state = new AtomicInteger(0);
    Thread nowTherea;

    public void lock() {
        trylock();
    }

    public void setNowTherea(Thread nowTherea) {
        this.nowTherea = nowTherea;
    }

    public Thread getNowTherea() {
        return nowTherea;
    }

    public void trylock() {
        Thread thread = Thread.currentThread();
        System.out.println(" " + thread.getName());
        while (!state.compareAndSet(0, 1)) {
            //System.out.println(Thread.currentThread().getName() + "等待jisu ");

        }
        this.nowTherea = thread;
        System.out.println(Thread.currentThread().getName() + "加锁成功 ");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行完毕 ");
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        while (this.nowTherea == thread && state.compareAndSet(1, 0)) {
            this.nowTherea = null;
            System.out.println(Thread.currentThread().getName() + " 解锁成功 ");
        }
    }
}
