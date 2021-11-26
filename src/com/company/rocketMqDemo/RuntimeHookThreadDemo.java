package com.company.rocketMqDemo;

import java.util.concurrent.TimeUnit;

/**
 * JVM钩子函数
 *
 * @author rookie.li
 * @date 2021-09-16 18:45
 */
public class RuntimeHookThreadDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            System.out.println(" Thread 1 " );
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            System.out.println(" Thread 2 " );
        });
        thread2.start();
        //如果异常异常退出的话钩子方法不起效
        System.exit(-1);
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println(System.currentTimeMillis());
            System.out.println(" Hook1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" Hook1");
        }));
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println(" Hook 2" );
            System.out.println(System.currentTimeMillis());
            System.out.println(" Hook 2" );
            System.out.println(System.currentTimeMillis());
            System.out.println(" Hook 2" );
        }));
    }

}
