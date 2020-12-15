package com.company.dem;

public class Badshililock implements Runnable {
    static Badshililock sc = new Badshililock();
    static int i = 0;

    public synchronized void incre() {
        i++;

    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            incre();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(sc);
        Thread t2 = new Thread(sc);
        /*����ļ���ʵ������
         * Thread t1 = new Thread(new Badshililock()); Thread t2 = new Thread(new
         * Badshililock());
         */
        t1.start();
        t1.join();
        t2.start();

        t2.join();
        System.out.println(i);

    }

}
