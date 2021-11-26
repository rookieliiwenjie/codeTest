package com.company.rocketMqDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-15 23:11
 */
public class ThreadDemoRocketMq {

    /**
     * 创建线程池的方式
     */
    static ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(8,
            new ThreadFactoryImpl("ThreadPoolName"));

    /**
     * initialDelay 初始化时间
     * period 延迟几秒执行一次
     *
     * @param args
     */
    public static void main(String[] args) {
        ScheduledFuture<?> scheduledFuture = threadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(" = " + Thread.currentThread().getName());
                System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
            }
        }, 4L, TimeUnit.SECONDS);
        try {
            System.out.println(" = " + Thread.currentThread().getName());
            System.out.println("scheduledFuture = " + scheduledFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

    }

   /* public static void getThreadName(ThreadPoolExecutor executorService) {
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            //获取线程工厂
            ThreadFactory oldThreadFactory = threadPoolExecutor.getThreadFactory();
            //在把线程工程设置到包装类 DelegatingThreadFactory ，再设置回线程池。
            threadPoolExecutor.setThreadFactory(new MyThreadFactory(oldThreadFactory, threadsContainer));
        }
    }*/

    private void CatcheThread() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService
    }

}
