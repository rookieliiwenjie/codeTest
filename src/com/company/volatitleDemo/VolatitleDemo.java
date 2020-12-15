package com.company.volatitleDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger(1);

    //添加synchronized实现原子性
    public void addNumber() {
        this.number = 60;
    }

    public void addNumberPul() {
        number++;
    }

    public void myAtomicAdd() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.1未加volatile时可见性没有实现，无法跳出循环
 * {
 * AAA	 come in
 * * AAA	 update number value is60
 * }
 * 1.2添加volatile时可见性实现，跳出循环
 * 打印结果{
 * AAA	 come in
 * AAA	 update number value is60
 * update number is ok60
 * }
 * 2.1volatitle 不保证原子性，不可分割完整性，
 * 也就是某个线程在处理问题时其他无法加塞和被分割，也就是要保证完整性和也就是成功或者失败
 * 如何解决:
 * 使用juc下的AtomicInteger
 */
public class VolatitleDemo {

    public static void main(String args[]) {
        seeOkByVolatitle();


        /*MyData myData = new MyData();
       for(int i = 0;i<20;i++){
           new Thread(()->{
            for(int j = 0;j<1000;j++){
                myData.addNumberPul();
                myData.myAtomicAdd();
            }
           },String.valueOf(i)).start();


       }*/
        //等待20个线程执行完毕，再通过main线程取得最终的结果值
        /**
         * Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
         *
         * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行
         * 。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
         *
         * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
         * 暂停当前正在执行的线程对象，并执行其他线程。
         *
         * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，
         * 使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
         *
         * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
         */
       /*while (Thread.activeCount()>2){
           Thread.yield();

       }
       System.out.println(Thread.currentThread().getName()+"\t fianl number is"+myData.number);
        System.out.println(Thread.currentThread().getName()+"atomic  number is ok" + myData.atomicInteger);*/


    }

    //volatitle保证可见性，及时通知主内存的值发生了改变
    public static void seeOkByVolatitle() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNumber();

            System.out.println(Thread.currentThread().getName() + "\t update number value is" + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            //测试是否成功修改了值如果没有则一直在循环
        }
        System.out.println("int number is ok" + myData.number);
    }
}
