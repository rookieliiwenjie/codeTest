package com.company.BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Created by lwj32 on 2020/5/28.
 */
class MyRease {

    public volatile boolean FLAG = true;//默认开启进行消费和生产
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    //依赖注入1.setget 2.构造注入
    MyRease(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myPro() throws InterruptedException {
        String data;
        boolean result;
        while (FLAG) {
            System.out.println("开始生产");
            data = String.valueOf(atomicInteger.getAndIncrement());
            result = blockingQueue.offer(data);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "插入队列成功" + data);
            } else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "插入队列失败");
            }

        }
        System.out.println("main线程叫停服务");
    }

    public void myConson() throws InterruptedException {
        String coRe = null;
        while (FLAG) {
            System.out.println("开始生产");
            coRe = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (coRe != null && !coRe.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() + "消费队列成功" + coRe);
            } else {
                //
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "消费队列失败");
                //生产停了
                return;
            }

        }
    }

    public void stop() {
        FLAG = false;
    }

}

public class ProductAndConsmerDemo3 {
    public static void main(String[] args) throws InterruptedException {
        MyRease myRease = new MyRease(new ArrayBlockingQueue<String>(10));

        new Thread(() -> {
            try {
                myRease.myPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产着").start();
        new Thread(() -> {
            try {
                myRease.myConson();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();
    }


}
