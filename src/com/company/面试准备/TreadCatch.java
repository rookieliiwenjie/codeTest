package com.company.面试准备;

import java.util.concurrent.*;

/**
 * Created by lwj32 on 2021/5/18.
 */
public class TreadCatch {
    static ThreadPoolExecutor threadPoolExecutor =new ThreadPoolExecutor(1,20,100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.run();
       /*  threadPoolExecutor.execute(threadDemo);

         threadPoolExecutor.shutdown();*/

    }



}

class YourUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName());
        System.out.println("*****************");
    }
}