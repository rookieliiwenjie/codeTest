package com.company.并发编程.day05_2020_12_22synzied;

/**
 * @Author rookie.li
 * @create 2020/12/22
 */
public class Main2Demo {
    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                add();
            }
        }, "B");
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                add();
            }
        }, "B");
        threadA.start();
        threadA.join();
        thread.start();
        thread.join();
        System.out.println("x = " + x);
    }

    public static void add() {
        x++;

        //System.out.println(Thread.currentThread().getName() + "x = " + x);
    }
}
