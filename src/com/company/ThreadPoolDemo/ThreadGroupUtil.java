package com.company.ThreadPoolDemo;

import java.util.ArrayList;
import java.util.List;

public class ThreadGroupUtil {
    private ThreadGroup threadGroup;

    public ThreadGroupUtil(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
    }

    public List<Thread> getThreads() {
        int activeCount = threadGroup.activeCount();
        Thread[] threads = new Thread[activeCount];
        threadGroup.enumerate(threads);
        List<Thread> result = new ArrayList<>();
        for (Thread t : threads) {
            if (t != null) {
                System.out.println("Name: " + t.getName() + ", State: " + t.getState());
                result.add(t);
            }
        }
        return result;
    }

    public void printThreadsInfo() {
        List<Thread> threads = getThreads();
        System.out.println("Active Threads: " + threads.size());
        for (Thread t : threads) {
            System.out.println("Name: " + t.getName() + ", State: " + t.getState());
        }
    }
}
