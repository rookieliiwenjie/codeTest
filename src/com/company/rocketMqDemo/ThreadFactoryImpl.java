package com.company.rocketMqDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-15 23:24
 */
public class ThreadFactoryImpl implements ThreadFactory {

    private final String prefixName;
    private final boolean demoe;
    private final AtomicInteger index = new AtomicInteger(0);

    public ThreadFactoryImpl(String prefixName) {
        this(prefixName, false);
    }

    public ThreadFactoryImpl(String prefixName, boolean demoe) {
        this.prefixName = prefixName;
        this.demoe = demoe;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, this.prefixName + this.index.incrementAndGet());
        thread.setDaemon(demoe);
        return thread;
    }
}
