package com.company.ThreadDemo.day05_2020_12_22synzied;

/**
 * @Author rookie.li
 * @create 2020/12/22
 */
public class MainDemo {
    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        MainDemo mainDemo = new MainDemo();

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                mainDemo.add();

            }
        }, "A");
        threadA.start();

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                mainDemo.add();
            }
        }, "B");

        thread.start();
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        while (Thread.activeCount() > 2) {
            Thread.yield();
            //;
            //System.out.println("Thread.activeCount() = " + Thread.currentThread().getName());
        }
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        //"ss".intern();
        thread.join();
        //threadA.join();
        System.out.println("x = " + x);

    }

    public void add() {
        synchronized (this) {
            x++;
        }
        //System.out.println(Thread.currentThread().getName() + "x = " + x);
    }
}
