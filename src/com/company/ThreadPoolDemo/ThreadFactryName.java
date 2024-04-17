package com.company.ThreadPoolDemo;

import com.company.SingleonDemo.A;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactryName implements ThreadFactory {

    private String name;
    private boolean deamon;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public ThreadFactryName(String name, boolean deamon) {
        this.name = name;
        this.deamon = deamon;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = this.name + "-" + atomicInteger.getAndIncrement();
        Thread thread = new Thread(r, name);
        thread.setDaemon(deamon);
        return thread;
    }
}
