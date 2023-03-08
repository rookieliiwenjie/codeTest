package com.company.rocketMqDemo;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * JVM钩子函数
 *
 * @author rookie.li
 * @date 2021-09-16 18:45
 */
public class RuntimeHookThreadDemo {

    public static void main(String[] args) {
//        Thread thread1 = new Thread(()->{
//            System.out.println(" Thread 1 " );
//        });
//        thread1.start();
//
//        Thread thread2 = new Thread(()->{
//            System.out.println(" Thread 2 " );
//        });
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        scheduledExecutorService.schedule(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                System.out.println("scheduledExecutorService = " + scheduledExecutorService);
//                return 1;
//            }
//        }, 3, TimeUnit.SECONDS);
        /**
         *  方法执行定时任务，执行多次定时任务，
         *  它是在定时任务执行完之后，再隔 N 秒开始执行下一次定时任务，它的执行时间受定时任务执行时长影响
         */
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("---scheduleWithFixedDelay.run"+new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, 3,TimeUnit.SECONDS);
        /**
         * 任务无论是否执行完成，隔多久就执行一次（定时任务执行时间<）
         */
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("scheduleAtFixedRate.run" + new Date());
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 3, TimeUnit.SECONDS);


//        thread2.start();
//        //如果异常异常退出的话钩子方法不起效
//        System.exit(-1);
//        Runtime.getRuntime().addShutdownHook(new Thread(()->{
//            System.out.println(System.currentTimeMillis());
//            System.out.println(" Hook1");
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(" Hook1");
//        }));
//        Runtime.getRuntime().addShutdownHook(new Thread(()->{
//            System.out.println(" Hook 2" );
//            System.out.println(System.currentTimeMillis());
//            System.out.println(" Hook 2" );
//            System.out.println(System.currentTimeMillis());
//            System.out.println(" Hook 2" );
//        }));
    }

}
