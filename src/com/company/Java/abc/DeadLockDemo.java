package com.company.Java.abc;

public class DeadLockDemo {
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (o1) {
                System.out.println("Thread1 get String.class lock");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                synchronized (o2) {
                    System.out.println("Thread2 get Integer.class lock");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (o2) {
                System.out.println("Threa2 get String.class lock");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                synchronized (o1) {
                    System.out.println("Thread1 get Integer.class lock");
                }
            }
        });
        thread.start();
        thread2.start();
        try {
            Thread.sleep(5000L);
            System.out.println(thread.getState());
            System.out.println(thread2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
