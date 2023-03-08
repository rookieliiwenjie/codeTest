package com.company.ThreadPoolDemo;

import java.util.concurrent.Semaphore;

/**
 * @Author: wenjie.li
 * @Date: 2022/10/18 9:57 上午
 * @Description:
 */
public class ABCDEMO {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        PrintA a = new PrintA();
        PrintB b = new PrintB();
        PrintC c = new PrintC();

        for (int i = 0; i < 30; i++) {
//            synchronized (this){
//
//            }
            if(i%3==1){

            }
        }
//        for (int i = 1; i <= 100; i++) {
//            if (i % 3 == 1) {
//                a.start();
//                try {
//                    semaphoreA.acquire();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                semaphoreB.release();
//            }
//
//            if (i % 3 == 2) {
//                b.start();
//                try {
//                    semaphoreB.acquire();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                semaphoreC.release();
//            }
//
//            if (i % 3 == 0) {
//                c.start();
////                try {
////                    //semaphore.acquire();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        }

    }


}

class PrintA extends Thread {
    @Override
    public void run() {
        System.out.println(" A");

    }
}

class PrintB extends Thread {
    @Override
    public void run() {
        System.out.println("B");

    }
}

class PrintC extends Thread {
    @Override
    public void run() {
        System.out.println("C");
    }
}
