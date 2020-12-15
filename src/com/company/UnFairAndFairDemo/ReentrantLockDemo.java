package com.company.UnFairAndFairDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2020/5/21.
 * 可重入锁（递归锁）:指同一个线程外层函数获得锁以后，内层递归函数任然能够获取该锁代码
 * 在同一个线程外层方法获取锁的时候，在进入内层方法会自动获得该锁（通俗的讲就是外层方法获取锁以后，递归
 * 给内层函数也同时拥有锁）
 * 线程：线程可以进入任何一个已经拥有的锁所同步着的代码块
 * Synchronized 和ReentrantLock就是典型的可重入锁
 * 有点：最大的作用就是可以避免死锁
 */
class Person implements Runnable {
    public void SendSms() {
        System.out.println(Thread.currentThread().getName() + "\t SendSMS()");
        SendEmail();
    }

    public void SendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t #####SendEmail()\n");
        //SendSms();

    }

    @Override
    public void run() {
        get();

    }

    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get function\n");
            set();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t set function\n");
        } catch (Exception e) {

        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {


    public static void main(String[] args) {
        Person person = new Person();
        Thread t1 = new Thread(person, "T1");
        Thread t2 = new Thread(person, "T2");
        t1.start();
        t2.start();
        //不使用ReentrantLock
        // T2	 get function
        //
        //T1	 get function
        //
        //T1	 set function
        //
        //T2	 set function
        /*
        new Thread(()->{
            person.SendSms();
        },"A").start();*/

        /* ReentrantLock lock = new ReentrantLock(true);
        for(int i = 0;i<1000;i++){
            lock.lock();
            try{
                ReentrantLockDemo thread = new ReentrantLockDemo();
                thread.setName("A");
                thread.setPriority(9);
                thread.start();
                ReentrantLockDemo threadB = new ReentrantLockDemo();
                threadB.setName("B");
                threadB.setPriority(8);
                threadB.start();

                ReentrantLockDemo threadC = new ReentrantLockDemo();
                threadC.setName("C");
                threadB.setPriority(7);
                threadC.start();
            }finally {
                lock.unlock();
            }


        }*/

        /*当不加synchronized时候
         * System.out.println(Thread.currentThread().getName()+"\t SendEmail()");SendSms();
         *    0	 SendEmail()
         *    4	 SendEmail()
         *    2	 SendEmail()
         *    1	 SendEmail()
         *    5	 SendEmail()
         *    0	 SendSMS()
         *    5	 SendSMS()
         *    1	 SendSMS()
         *    2	 SendSMS()
         *    4	 SendSMS()
         *
         *
         * */

        /*for(int i = 0;i<1000;i++){
            new Thread(()->{
                person2.SendEmail();
            },String.valueOf(i)).start();

        }*/
        //加入重入锁的方式
       /* ReentrantLock lock = new ReentrantLock(true);
        for(int i = 0;i<10000;i++){
            new Thread(()->{
                lock.lock();
                try {
                    person2.SendSms();
                }finally {
                    lock.unlock();
                }
            },String.valueOf(i)).start();

        */
        //打印ABC


        /*
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        try {
            for(int i = 0;i<10000;i++){

                thread.start();
                System.out.println(thread.currentThread().getName());
                threadB.start();
                System.out.println(threadB.currentThread().getName());
                threadC.start();
                System.out.println(threadC.currentThread().getName());
            }
        }finally {
            lock.unlock();
        }*/


    }
}
