package com.company.BlockingQueueDemo;

/**
 * Created by lwj32 on 2020/5/27.
 */
public class ProductAndCuDemo {
    private static volatile int flag = 1;

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            new Thread(new ProductThread()).start();
            new Thread(new CouThread()).start();
        }
    }

    static class ProductThread implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                if (flag == 1) {
                    System.out.println("生产");
                    flag = 2;
                   /* try {
                        this.wait();

                        System.out.println("生产");
                        flag = 2;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        CouThread.class.notify();

                    }*/


                }
            }

        }
    }

    static class CouThread implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                if (flag == 2) {
                    System.out.println("消费");
                    flag = 1;
                /*    try {
                        this.wait();
                        System.out.println("消费");
                        flag=1;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        ProductThread.class.notify();
                    }*/

                }
            }

        }
    }
}
