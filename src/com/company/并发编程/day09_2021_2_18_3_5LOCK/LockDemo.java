package com.company.并发编程.day09_2021_2_18_3_5LOCK;

import com.company.SingleonDemo.A;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author rookie.li
 * @create 2021/2/18
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        /*LockAbDemo lockAbDemo = new LockAbDemo();
        Thread threadRead = new Thread(() -> {
            lockAbDemo.reader();
            System.out.println("threadRead = " + lockAbDemo.a);
        });
        Thread threadWrite = new Thread(() -> {
            lockAbDemo.writed();
            System.out.println("threadWrite = " + lockAbDemo.a);
        });
        threadRead.start();
       // TimeUnit.MILLISECONDS.sleep(100);
        threadWrite.start();
*/
        /*AtomicInteger atomicInteger = new AtomicInteger(2);
        int andIncrement = atomicInteger.getAndIncrement();*/
        ReecenrLock reecenrLock = new ReecenrLock();
        reecenrLock.state = 1;
        boolean b = reecenrLock.compareAndSwapState(1, 2);
        System.out.println("bflag = " + b);
    }
}
