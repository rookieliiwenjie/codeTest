package com.company.javaEigt.JavaEightDemo.ExecutorsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/10 2:36 下午
 * @Description:
 */
public class ExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<CompletableFuture<String>> reqResult = new ArrayList<>();
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
////            System.out.println("completableFuture = " + completableFuture);
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return Thread.currentThread().getName();
//            });
//            reqResult.add(completableFuture);
//        }
//        System.out.println("(System.currentTimeMillis()-before)/1000 = " + (System.currentTimeMillis() - startTime) / 1000);
//        CompletableFuture.allOf(reqResult.toArray(new CompletableFuture[reqResult.size()])).join();
//        for (int i = 0; i < reqResult.size(); i++) {
//            System.out.println("reqResult = " + reqResult.get(i).get());
//        }
//        System.out.println("(System.currentTimeMillis()-end)/1000 = " + (System.currentTimeMillis() - startTime) / 1000);
//
//        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);

        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
//        executors
    }
}
