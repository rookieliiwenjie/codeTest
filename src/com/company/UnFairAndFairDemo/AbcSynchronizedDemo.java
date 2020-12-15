package com.company.UnFairAndFairDemo;

/**
 * Created by lwj32 on 2020/5/24.
 */
public class AbcSynchronizedDemo {
    public static class ThreadPro implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        public ThreadPro(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (prev) {
                    synchronized (self) {
                        System.out.println(name);
                        count--;
                        self.notifyAll();
                    }
                    try {
                        if (count == 0) {
                            prev.notifyAll();
                        } else {
                            prev.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPro threadProA = new ThreadPro("A", c, a);
        ThreadPro threadProB = new ThreadPro("B", a, b);
        ThreadPro threadProC = new ThreadPro("C", b, c);
        new Thread(threadProA).start();
        Thread.sleep(10);
        new Thread(threadProB).start();
        Thread.sleep(10);
        new Thread(threadProC).start();
        Thread.sleep(10);
    }
}
