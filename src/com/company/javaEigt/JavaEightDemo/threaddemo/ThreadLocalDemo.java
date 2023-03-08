package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/13 2:58 下午
 * @Description:
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
    private static ThreadLocal<SimpleDateFormat> threadLocalA = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    // ...
    private static ThreadLocal<Object> threadLocald = ThreadLocal.withInitial(Object::new);
    // ...
    // 反例，这实际上是不同线程共享同一个变量
//    private static ThreadLocal<Obj> threadLocalcc = ThreadLocal.withInitial(() -> obj);

    // ...
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10000000; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        threadPoolExecutor.submit(() -> {
//            ThreadLocalDemo.threadLocal.set(Thread.currentThread().getName());
//            System.out.println("------------" + Thread.currentThread().getName() + "--------------");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("ThreadLocalDemo.threadLocal.get() = " + ThreadLocalDemo.threadLocal.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                ThreadLocalDemo.threadLocal.remove();
//            }
//        });
//
//        threadPoolExecutor.submit(() -> {
//            ThreadLocalDemo.threadLocal.set(Thread.currentThread().getName());
//            System.out.println("------------" + Thread.currentThread().getName() + "--------------");
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("ThreadLocalDemo.threadLocal.get() = " + ThreadLocalDemo.threadLocal.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                ThreadLocalDemo.threadLocal.remove();
//            }
//        });
//
//        threadPoolExecutor.submit(() -> {
//            ThreadLocalDemo.threadLocal.set(Thread.currentThread().getName());
//            System.out.println("------------" + Thread.currentThread().getName() + "--------------");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//                System.out.println("ThreadLocalDemo.threadLocal.get() = " + ThreadLocalDemo.threadLocal.get());
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                ThreadLocalDemo.threadLocal.remove();
//            }
//        });
//        threadPoolExecutor.shutdown();
    }
}
