package com.company.ThreadPoolDemo;

import com.company.dem.MyRunnable;

import java.util.concurrent.TimeUnit;

public class CommonUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程" + t.getName() + "发生异常：" + e);
    }
}

