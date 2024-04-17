package com.company.javaEigt.CompletableFutureDemo;

import com.company.javaEigt.JavaEightDemo.ExecutorsDemo.SimpleDataFormatDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class CompletableFutrueDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> task = new FutureTask<>(() -> {
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println("hello" + simpleFormatter.format(new Date()));
//            TimeUnit.SECONDS.sleep(1);
//            return "hello";
//        });
//        new Thread(task).start();
//        String s1 = task.get();
//        System.out.println(s1);
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("message");
        completableFuture.thenApply(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).thenApply(s -> {
            System.out.println(s);
            return s.toLowerCase();
        }).thenAccept(System.out::println);
        String s = completableFuture.get();
        System.out.println(s);
//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello" + Thread.currentThread().getName());
//            return null;
//        });
//        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello" + Thread.currentThread().getName());
//            return null;
//        });
//        CompletableFuture<Void> completableFuture4 = CompletableFuture.runAsync(() -> {
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println("hello4" + simpleFormatter.format(new Date()));
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("hello completableFuture4" + Thread.currentThread().getName());
//        });
//        completableFuture4.thenRunAsync(new Runnable() {
//            @Override
//            public void run() {
//                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("hello----" + simpleFormatter.format(new Date()));
//            }
//        });
//
//        CompletableFuture<Void> voidCompletableFuture = completableFuture4.thenRun(() -> {
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println("hello5" + simpleFormatter.format(new Date()));
//        });
////        voidCompletableFuture.get();
//
//        //生成一个java正则表达式，今天是否是星期天
//
//        String s = completableFuture.get();
//        Thread.sleep(4000);
//        System.out.println(s);

    }
}
