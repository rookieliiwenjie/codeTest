package com.company.并发编程.day12_2021_02_25_THREAD;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class CountThread {
    public static void main(String[] args) throws InterruptedException {
       /* Runner runner = new Runner();
        Thread createThread = new Thread(runner, "runner1");
        createThread.start();
        TimeUnit.SECONDS.sleep(1);
        createThread.interrupt();
        Runner runner2 = new Runner();
        createThread = new Thread(runner2, "runner2");
        TimeUnit.SECONDS.sleep(1);
        createThread.start();
        TimeUnit.SECONDS.sleep(1);
        runner2.cancel();*/


    }

    static class Runner implements Runnable {
        private long i = 0;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
