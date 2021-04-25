package com.company.并发编程.day11_2021_02_24_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/24
 * @des 线程优先级
 */
public class ThreadPriorityDemo {
    static volatile boolean noStart = true;
    static volatile boolean noEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Jod> jodList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Jod jod = new Jod(priority);
            jodList.add(jod);
            Thread thread = new Thread(jod, "Thread" + i);
            thread.setPriority(priority);
            thread.start();

        }
        noStart = false;
        TimeUnit.MILLISECONDS.sleep(100);
        noEnd = false;
        for (Jod jod :
                jodList) {
            System.out.println("Job Priority:" + jod.priority + "Job Count:" + jod.jobCount);
        }
    }

    static class Jod implements Runnable {
        private long jobCount;
        private int priority;

        Jod(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (noStart) {
                Thread.yield();
            }
            while (noEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
