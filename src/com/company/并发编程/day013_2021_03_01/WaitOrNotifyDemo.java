package com.company.并发编程.day013_2021_03_01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/1
 */
public class WaitOrNotifyDemo {
    private static Object lock = new Object();
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread thread = new Thread(new waitDemo(), "wiatDemo");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(new notifyDemo(), "notifyDemo");
        thread1.start();
    }

    static class waitDemo implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {

                while (flag) {
                    System.out.println(Thread.currentThread() + "  flag"
                            + flag + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
                /*System.out.println(flag+"flag");
                while (flag) {
                    System.out.println( "flag"
                            + flag );
                }*/
            System.out.println("end  " + Thread.currentThread() + "   flag"
                    + flag + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }

    static class notifyDemo implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("start  " + Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //lock.notifyAll();

            }
            //再次加锁
            synchronized (lock) {

                System.out.println("end   " + Thread.currentThread() + " hold lock again. sleep @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
