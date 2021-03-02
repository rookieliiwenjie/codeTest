package com.company.并发编程.day15_2021_03_02;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/2
 */
public class TimeUtils {
    private static final ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> System.currentTimeMillis());

    public static void begin() {
        threadLocal.set(System.currentTimeMillis());
    }

    public static long end() {

        return System.currentTimeMillis() - threadLocal.get();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(), "A");
        Thread threadB = new Thread(new ThreadDemo(), "B");
        thread.start();
        threadB.start();

    }

    static class ThreadDemo implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "start");
            TimeUtils.begin();
            try {
                TimeUnit.SECONDS.sleep(Thread.currentThread().getName().equals("B") ? 10 : 11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "    TimeUtils.end() = " + TimeUtils.end() + "---" +
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }
}
