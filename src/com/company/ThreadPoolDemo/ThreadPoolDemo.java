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


    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     *        核心线程数，线程池中一直存在的线程数量，即使他们是空闲的，除非设置了allowCoreThreadTimeOut
     * @param maximumPoolSize the maximum number of threads to allow in the
     *        pool
     *        最大线程数，线程池中最大的线程数量，当队列满了以后，启用最大线程数
     * @param keepAliveTime when the number of threads is greater than
     *        the core, this is the maximum time that excess idle threads
     *        will wait for new tasks before terminating.
     *        当线程数大于核心线程数时，这是多余的空闲线程在终止之前等待新任务的最长时间。
     * @param unit the time unit for the {@code keepAliveTime} argument
     *             keepAliveTime参数的时间单位
     * @param workQueue the queue to use for holding tasks before they are
     *        executed.  This queue will hold only the {@code Runnable}
     *        tasks submitted by the {@code execute} method.
     *         工作队列  在执行之前在任务执行之前，他排队用于保存任务。此队列将仅容纳由{@code execute}方法提交的{@code Runnable}任务 （这里不太准确，我使用submit 提交callback 也是可以放到队列的）。后面看到是因为  if (task == null) throw new NullPointerException();
     *         RunnableFuture<T> ftask = newTaskFor(task);
     *         execute(ftask);
     *         return ftask;这个
     * @param threadFactory the factory to use when the executor
     *        creates a new thread
     *        当执行程序创建新线程时要使用的工厂
     * @param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     *        当执行由于达到线程边界和队列容量而被阻塞时要使用的处理程序
     */

    static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactryName("CompleteFutureDemo", false), new ThreadPoolExecutor.DiscardOldestPolicy());
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println(finalI +"--before" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(finalI +"--after" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(finalI +"----------after.after" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 1;
            });
        }
        System.out.println("beforeexecutorService.getQueue().size()"+executorService.getQueue().size());
        System.out.println("before sleep"+ executorService.getActiveCount());
        TimeUnit.SECONDS.sleep(10);
        System.out.println("after executorService.getQueue().size()"+executorService.getQueue().size());
        System.out.println("after sleep"+ executorService.getActiveCount());
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println("sencode"+finalI +"--before" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("sencode"+finalI +"--after" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("sencode"+finalI +"----------after.after" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return finalI;
            });
        }




//        for (int i = 0; i < 20; i++) {
//            int finalI = i;
//            executorService.execute(() -> {
//                try {
//                    System.out.println(finalI +"--before" + Thread.currentThread().getName());
//                    TimeUnit.SECONDS.sleep(5);
//                    System.out.println(finalI +"--after" + Thread.currentThread().getName());
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println(finalI +"----------after.after" + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//        System.out.println("beforeexecutorService.getQueue().size()"+executorService.getQueue().size());
//        System.out.println("before sleep"+ executorService.getActiveCount());
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println("after executorService.getQueue().size()"+executorService.getQueue().size());
//        System.out.println("after sleep"+ executorService.getActiveCount());
//        for (int i = 0; i < 20; i++) {
//            int finalI = i;
//            executorService.submit(() -> {
//                try {
//                    System.out.println("sencode"+finalI +"--before" + Thread.currentThread().getName());
//                    TimeUnit.SECONDS.sleep(5);
//                    System.out.println("sencode"+finalI +"--after" + Thread.currentThread().getName());
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println("sencode"+finalI +"----------after.after" + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }





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
//        ExecutorService executorService = new ThreadPoolExecutor(
//                3, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3)
//                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
//        long startTime = System.currentTimeMillis();
//        ExecutorService executorService4 = Executors.newScheduledThreadPool(2);
//        try {
//            for (int i = 0; i < 100; i++) {
//                executorService.execute(() -> {
//
//                    System.out.println(Thread.currentThread().getName() + "\t开始");
//                });
//            }
//        } catch (Exception e) {
//
//        } finally {
//            executorService.shutdown();
//
//        }
//
//
//
//        Runtime.getRuntime().availableProcessors();
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
