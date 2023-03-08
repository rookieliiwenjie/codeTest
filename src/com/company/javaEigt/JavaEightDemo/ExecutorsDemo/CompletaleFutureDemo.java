package com.company.javaEigt.JavaEightDemo.ExecutorsDemo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/10 3:50 下午
 * @Description:
 */
public class CompletaleFutureDemo {
    public static void main(String[] args) {
        List<CompletableFuture<String>> futureResult = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 60; i++) {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "demo" + Thread.currentThread().getName();
            });
            futureResult.add(completableFuture);
        }

        System.out.println("sleep before  futureResult.size()= " + futureResult.size());
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("sleep after = " +  futureResult.size());
        CompletableFuture.allOf(futureResult.toArray(new CompletableFuture[0])).join();
        System.out.println("(System.currentTimeMillis() - startTime)/1000 = " + (System.currentTimeMillis() - startTime) / 1000);
        futureResult.forEach(futureResults-> {
            try {
                String s = futureResults.get();
                System.out.println("s = " + s);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("(System.currentTimeMillis() - startTime)/1000 = " + (System.currentTimeMillis() - startTime) / 1000);
    }


}
