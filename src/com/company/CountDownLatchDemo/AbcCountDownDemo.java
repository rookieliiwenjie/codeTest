package com.company.CountDownLatchDemo;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lwj32 on 2020/5/25.
 */

public class AbcCountDownDemo {
    Object a = new Object();
    Object b = new Object();
    Object c = new Object();

    static class ThreadDemo implements Runnable {
        private String name;
        private Object fontLock;
        private Object thisLock;

        public ThreadDemo(String name, Object fontLock, Object thisLock) {
            this.fontLock = fontLock;
            this.name = name;
            this.thisLock = thisLock;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (fontLock) {
                    synchronized (thisLock) {
                        System.out.println(name);
                        count--;
                        thisLock.notifyAll();
                    }
                    try {
                        if (count == 0) {
                            fontLock.notifyAll();
                        } else {
                            fontLock.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }


  /*  //1.join实现
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }*/
    //2.sychon


    public static void main(String[] args) throws InterruptedException {

      /* //1.join实现
        for(int i = 0;i<10;i++){
            AbcCountDownDemo A = new AbcCountDownDemo();
            A.setName("A");
            A.start();
            A.join();
            AbcCountDownDemo B = new AbcCountDownDemo();
            B.setName("B");
            B.start();
            B.join();
            AbcCountDownDemo C = new AbcCountDownDemo();
            C.setName("C");
            C.start();
            C.join();
        }*/
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        ThreadDemo threadProA = new ThreadDemo("A", c, a);
//        ThreadDemo threadProB = new ThreadDemo("B", a, b);
//        ThreadDemo threadProC = new ThreadDemo("C", b, c);
//        new Thread(threadProA).start();
//        Thread.sleep(10);
//        new Thread(threadProB).start();
//        Thread.sleep(10);
//        new Thread(threadProC).start();
//        Thread.sleep(10);
        System.out.println("28%3 = " + 30%3);
        System.out.println("28%3 = " + 29%3);
        System.out.println("28%3 = " + 28%3);
        System.out.println("28%3 = " + 27%3);

    }
}
