package com.company.Thread;

public class RunableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始运行");
    }

    public static void main(String args[]) {
        RunableDemo runableDemo = new RunableDemo();
        new Thread(runableDemo, "A").start();
        Thread thread = new Thread("A");
    }
}
