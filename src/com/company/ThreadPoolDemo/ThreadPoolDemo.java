package com.company.ThreadPoolDemo;

import java.util.concurrent.*;

/**
 * Created by lwj32 on 2020/5/29.
 * 避免上下文切换
 * 1.线程池的优势
 * 概述：线程池做的工作主要是控制运行线程的数量，处理过程中将任务放到队列中，然后在线程创建启动后启动这些任务，如果线程数量
 * 超过最大数量超出的数量的线程排队等待，等其他线程完成后，再从队列中取出执行
 * 特点：1.线程复用，2.控制并发，3.管理线程
 * 优点：
 * 1.降低资源的损耗，通过重复利用自己创建线程降低线程创建和销毁消耗的资源
 * 2.提高响应速度，当任务到达时，任务不需要等待线程的创建。
 * 3.提高线程的 管理性：线程是稀缺资源，如果无限制的创建，不但会消耗系统资源，还会降低系统的稳定性，使用线程池统一分配，调优和分配
 * <p>
 * 线程的三个常用方式：
 */
//第四种获得使用java多线程的方式 线程池
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        /* ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();*/
        /* ScheduledThreadPoolExecutor 时间调度*/
        //需要自己学习Executors.newWorkStealingPool();
        //5种线程池使用一般三种
      /*  ExecutorService executorService = Executors.newFixedThreadPool(5);//指定处理线程
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService executorService3 = Executors.newCachedThreadPool();//一池n线程
        ExecutorService executorService4 = Executors.newScheduledThreadPool(2);
        ExecutorService executorService5 = Executors.newWorkStealingPool(2);//一池n线程*/
        ExecutorService executorService = new ThreadPoolExecutor(
                3, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3)
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        long startTime = System.currentTimeMillis();
        ExecutorService executorService4 = Executors.newScheduledThreadPool(2);
        try {
            for (int i = 0; i < 100; i++) {
                executorService.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "\t开始");
                });
            }
        } catch (Exception e) {

        } finally {
            executorService.shutdown();

        }



        Runtime.getRuntime().availableProcessors();
       /* if(executorService.isShutdown()){
            System.out.println(Thread.currentThread().getName()+"Executor time is"+(System.currentTimeMillis()-startTime));
            // 消耗时间73

        }*/
      /*  System.out.println(" 开始100线程");
        long strtTie = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t开始");
            },String.valueOf(i)).start();

        }
        System.out.println("1000 time is"+(System.currentTimeMillis()-strtTie));

        同样10000 这个时间是2003
        */
    }
}
