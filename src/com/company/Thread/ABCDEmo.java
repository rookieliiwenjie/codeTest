package com.company.Thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by lwj32 on 2020/6/28.
 */
class Caller implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}

public class ABCDEmo implements Callable<Integer> {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      /*  Semaphore semaphore = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        for(int i = 0;i<=10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"A").start();
            new Thread(()->{
                try {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            },"B").start();
            new Thread(()->{
                try {
                    semaphoreC.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"C").start();*/
        ArrayList<FutureTask<Integer>> arrayList = new ArrayList<FutureTask<Integer>>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(), 100, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        Thread thread = new Thread();
        thread.start();
        thread.run();
        for (int i = 0; i < 5; i++) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(new Caller());
            //System.out.println("futureTask = " + futureTask.get());
            arrayList.add(futureTask);
            threadPoolExecutor.execute(futureTask);
            //threadPoolExecutor.execute(futureTask);
            Future<Integer> integerFutureTask = (Future<Integer>) threadPoolExecutor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 1;
                }
            });
            System.out.println("integerFutureTask = " + integerFutureTask.get());


        }

        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {

        }

        System.out.println("main running after all task down ------");
        int result = 0;
        for (FutureTask<Integer> futureTask : arrayList) {
            result += futureTask.get();
        }
        System.out.println("result:" + result);

       /* ReentrantLock reentrantLock = new ReentrantLock(true);
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();
        new Thread(() -> {

        }, "D").start();

        for (int i = 0; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {

                reentrantLock.lock();
                try {

                    while (finalI % 3 != 0) {
                        conditionA.await();

                    }
                    System.out.println(Thread.currentThread().getName());
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }, "A").start();
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    while (finalI % 3 != 1) {
                        conditionB.await();

                    }
                    System.out.println(Thread.currentThread().getName());
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }, "B").start();
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    while (finalI % 3 != 1) {
                        conditionC.await();

                    }
                    System.out.println(Thread.currentThread().getName());
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }, "C").start();
        }
*/
        CallBySumbit();
    }
    public static void CallBySumbit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
       /* FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
      *//*  Future<Integer> future =  executorService.submit()*//*

        FutureTask<Integer> futureTask1 = (FutureTask<Integer>) executorService.submit(futureTask);

        futureTask1.run();
        System.out.println(futureTask1.get());
        executorService.shutdown();*/
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        try {
            System.out.println("submit = " + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();

        }
    }
    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
