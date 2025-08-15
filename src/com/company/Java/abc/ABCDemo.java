package com.company.Java.abc;


import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ABCDemo {
    private static int state = 0;
    static ReentrantLock lock = new ReentrantLock();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static Integer a=1;
    public static void main(String[] args) {
//        Object lock = new Object();
//        Thread a = new Thread(() -> {
//            print(lock, "A", 0);
//        });
//        Thread b = new Thread(() -> {
//            print(lock, "B", 1);
//        });
//        Thread c = new Thread(() -> {
//            print(lock, "C", 2);
//        });
//        a.start();
//        b.start();
//        c.start();
//        Thread thread1 = new Thread(new Task(), "Thread1");
//        Thread thread2 = new Thread(new Task(), "Thread2");
//        thread1.start();
//        thread2.start();
//        try {
//            Thread.sleep(1000L);
//            System.out.println(thread1.getName() + "----" + thread1.getState());
//            System.out.println(thread2.getName() + "----" + thread2.getState());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        thread1.interrupt();

//        Thread thread1 = new Thread(new Task2(), "Thread1");
//        Thread thread2 = new Thread(new Task2(), "Thread2");
//        Thread thread3 = new Thread(new Task2(), "Thread2");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        try {
//            Thread.sleep(1000L);
//            System.out.println(thread1.getName() + "----" + thread1.getState());
//            System.out.println(thread2.getName() + "----" + thread2.getState());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Thread thread1 = new Thread(new Task3(), "Thread1");
        Thread thread2 = new Thread(new ReadTask2(), "Thread2");
        Thread thread3 = new Thread(new ReadTask2(), "Thread3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(1000L);
//            System.out.println(thread1.getName() + "----" + thread1.getState());
//            System.out.println(thread2.getName() + "----" + thread2.getState());
//            System.out.println(thread3.getName() + "----" + thread2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "before");
                lock.lockInterruptibly();
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "get lock");
                    Thread.sleep(2000L);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "unlock");
                    lock.unlock();
                }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "unlock");
                e.printStackTrace();
            }

        }

    }

    static class ReadTask2 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "read before");
                reentrantReadWriteLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"---" + "read get lock");
                    System.out.println(Thread.currentThread().getName()+"a="+a);
                    Thread.sleep(3000L);
                } finally {
                    System.out.println(Thread.currentThread().getName()+"---" + "unlock");
                    reentrantReadWriteLock.readLock().unlock();
                }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+"--catch" + "unlock");
                e.printStackTrace();
            }

        }

    }

    static class Task3 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "write before");
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a= 10;
                    System.out.println(Thread.currentThread().getName() + "write get lock");
                    Thread.sleep(5000L);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "unlock");
                    reentrantReadWriteLock.writeLock().unlock();
                }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "unlock");
                e.printStackTrace();
            }

        }

    }

    public static void print(Object lock, String name, Integer tarGetstate) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (state % 3 != tarGetstate) {
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
