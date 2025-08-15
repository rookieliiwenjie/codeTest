package com.company.Java.abc;


public class ABCDemo {
    private static int state = 0;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(()->{
            print(lock,"A",0);
        });
        Thread b = new Thread(()->{
            print(lock,"B",1);
        });
        Thread c = new Thread(()->{
            print(lock,"C",2);
        });
        a.start();
        b.start();
        c.start();


    }
    public static void print(Object lock,String name,Integer tarGetstate){
        for (int i = 0; i < 10; i++) {
            synchronized (lock){
                while (state%3!=tarGetstate ){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(name);
                state++;
                lock.notifyAll();
            }
        }
    }
}
