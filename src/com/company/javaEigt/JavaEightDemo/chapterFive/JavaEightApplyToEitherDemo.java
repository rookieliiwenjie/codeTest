package com.company.javaEigt.JavaEightDemo.chapterFive;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/13 4:04 下午
 * @Description:
 */
public class JavaEightApplyToEitherDemo {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        acceptEitherDemo();
        applyToEitherDemo();
    }

    /**
     *  applyToEither 、acceptEither 快者优先
     *  区别 applyToEither 又返回值
     *  acceptEither 无返回值
     */
    public static void applyToEitherDemo() {
        CompletableFuture<String> otherFuture = CompletableFuture
                .supplyAsync(() -> {
                    int result = new Random().nextInt(100);
                    System.out.println("执行者A：" + result);
                    try {
// 故意A慢了一些
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "执行者A【" + result + "】";
                }, executor);

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    int result = new Random().nextInt(100);
                    System.out.println("执行者B：" + result);
                    return "执行者B【" + result + "】";
                }, executor).applyToEither(otherFuture, (faster) -> "执行者A【\" + result + \"】");

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    public static void acceptEitherDemo() {
        CompletableFuture<String> otherFuture = CompletableFuture
                .supplyAsync(() -> {
                    int result = new Random().nextInt(100);
                    System.out.println("执行者A：" + result);
                    try {
// 故意A慢了一些
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "执行者A【" + result + "】";
                }, executor);

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    int result = new Random().nextInt(100);
                    System.out.println("执行者B：" + result);
                    return "执行者B【" + result + "】";
                }, executor).acceptEither(otherFuture, (faster) -> {
                    System.out.println("谁最快：" + faster);
                });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
