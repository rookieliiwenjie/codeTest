package com.company.并发编程.day020_2021_06_01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by lwj32 on 2021/6/1.
 */
public class SemphreDemo {
    static ExecutorService executorService = Executors.newFixedThreadPool(30);
   // static Semaphore semaphore1 = new Semaphore(0);

//    public static void main(String[] args) {
//        for (int i =0;i<30;i++){
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        if(semaphore.availablePermits()==0){
//                            System.out.println("  等待 "+ Thread.currentThread().getName() );
//                        }
//                        semaphore.acquire();
//                        int queueLength = semaphore.getQueueLength();
//                        System.out.println("queueLength = " + queueLength);
//                        System.out.println(Thread.currentThread().getName()+"   save data");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }finally {
//                        semaphore.release();
//                    }
//
//                }
//            });
//        }
//        executorService.shutdown();
//
//
//
//    }
    public static void main(String[] args) {
        try {
             Semaphore semaphore1 = new Semaphore(0);

            semaphore1.release();
            int avvilable = semaphore1.availablePermits();
            //semaphore1.acquire();
            int q= semaphore1.getQueueLength();
            Stack<Integer> stack = new Stack<>();
            Deque<Integer> stack2 = new ArrayDeque<Integer>();
            stack2.add(1);
            System.out.println("q = " + q);
            System.out.println("avvilable = " + avvilable);
            ConcurrentHashMap<Integer,Integer> hashMap = new ConcurrentHashMap<>();
            hashMap.put(1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
