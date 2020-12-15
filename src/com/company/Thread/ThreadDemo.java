package com.company.Thread;

public class ThreadDemo extends Thread {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running！");
    }

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ThreadDemo A = new ThreadDemo();
            A.setName("A");
            A.start();
            A.join();
            ThreadDemo B = new ThreadDemo();
            B.setName("B");
            B.start();
            B.join();
            ThreadDemo C = new ThreadDemo();
            C.setName("C");
            C.start();
            C.join();

        }

    }
}
