package com.company.CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2020/5/29.
 * Callable可以返回值在高并发和异步
 */
class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        //System.out.println(Thread.currentThread().getName()+ "go");
        TimeUnit.SECONDS.sleep(1);
        return "A";
    }
}

class MyThreadB implements Callable<String> {

    @Override
    public String call() throws Exception {
        //  System.out.println(Thread.currentThread().getName()+ "go");
        TimeUnit.SECONDS.sleep(1);
        return "B";
    }
}

class MyThreadC implements Callable<String> {

    @Override
    public String call() throws Exception {
        //System.out.println(Thread.currentThread().getName()+ "go");
        TimeUnit.SECONDS.sleep(1);
        return "C";
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = new FutureTask<>(new MyThread());
            FutureTask<String> futureTask2 = new FutureTask<>(new MyThreadB());
            FutureTask<String> futureTaskC = new FutureTask<>(new MyThreadC());
            Thread threadA = new Thread(futureTask);
            threadA.setName("AA");
            threadA.start();
            Thread threadB = new Thread(futureTask2);
            Thread threadC = new Thread(futureTaskC);
            System.out.println(futureTask.get());
            //int rusult = 2;
            if (futureTask.isDone()) {
                threadB.start();
                System.out.println(futureTask2.get());
            }
            if (futureTask2.isDone()) {
                threadC.start();
                System.out.println(futureTaskC.get());
            }
        }

        /*while (futureTask.isDone()){
            threadC.start();
            System.out.println(futureTask2.get());
        }*/


        //System.out.println(Thread.currentThread().getName() + "main");
        //int futureResult = futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要去获取，会导致阻塞现象
       /* StringBuilder stringBuilder = new StringBuilder();
        while (!futureTask.isDone()){
            stringBuilder.append("-");
            System.out.println(stringBuilder);
            System.out.print("\b\b\b\b\b");
        }*/
        /*System.out.println("完成！！！！！！！！！！！！！！！！！");
        int futureResult = futureTask.get();
        System.out.println("futureResult+rusult = " + (futureResult + rusult));*/


    }

}
