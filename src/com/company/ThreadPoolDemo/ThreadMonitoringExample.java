package com.company.ThreadPoolDemo;

import com.company.dem.MyRunnable;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadMonitoringExample {
    public static void main(String[] args) throws InterruptedException { // 创建一个新的ThreadGroup对象
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        ThreadGroupUtil threadGroupUtil = new ThreadGroupUtil(group);
        // 创建并启动一些线程，并将它们添加到线程组中
        Thread thread1 = new Thread(group, new MyRunnable(10), "MyThread1");
        thread1.start();
        threadGroupUtil.getThreads();
        threadGroupUtil.printThreadsInfo();
        Thread thread2 = new Thread(group, new MyRunnable(5), "MyThread2");
        thread2.start();

        threadGroupUtil.getThreads();
        threadGroupUtil.printThreadsInfo();
    }
}
