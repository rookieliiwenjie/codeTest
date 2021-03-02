package com.company.并发编程.day12_2021_02_25_THREAD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/2/25
 */
public class CdDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CdThread());
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        //暂停2秒
        thread.suspend();
        TimeUnit.SECONDS.sleep(5);
        //恢复
        thread.resume();
    }

    static class CdThread implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (true) {
                Date date = new Date();
                simpleDateFormat.format(date);
                System.out.println(simpleDateFormat.format(date));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
