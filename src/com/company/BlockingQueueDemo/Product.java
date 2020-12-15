package com.company.BlockingQueueDemo;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 * User: lwj
 * Date: 2020/6/5
 * Time: 11:27
 */
class ProdeuctAndCon {
     BlockingQueue<String> blockingQueue = null;
    AtomicInteger atomicInteger = new AtomicInteger(1);
    volatile static boolean flag = true;

    ProdeuctAndCon(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void product() throws InterruptedException {
        System.out.println("------------开始生产-----------");
        String data;
        boolean offeris;
        while (flag) {
             data = String.valueOf(atomicInteger.getAndIncrement());
             offeris = blockingQueue.offer(data);

            if (offeris) {

                System.out.println("生产" + data);
            } else {
                System.out.println("生产失败");
                flag = false;
            }


        }
    }

    public void con() throws InterruptedException {
        System.out.println("------------开始消费-----------");
        String tabke = null;
        while (flag) {
             tabke = blockingQueue.poll();
            if (tabke == null && tabke.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "消费失败");
                return;

            } else {
                System.out.println(Thread.currentThread().getName() + "消费" + tabke);

            }


        }
    }

    public void Stop() {
        flag = false;
        System.out.println("停止生产");

    }
}

public class Product {

    public static void main(String[] args) throws InterruptedException {
        ProdeuctAndCon prodeuctAndCon = new ProdeuctAndCon(new ArrayBlockingQueue(3));
        new Thread(() -> {
            try {
                prodeuctAndCon.product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                prodeuctAndCon.con();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}