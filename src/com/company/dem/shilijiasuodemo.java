package com.company.dem;

public class shilijiasuodemo {
    static int i = 1;

    public static class DemoThread extends Thread {
        static DemoThread a = new DemoThread();

        @Override
        public synchronized void run() {
            for (int j = 1; j <= 10000; j++) {
                synchronized (a) {
                    i++;

                }

            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        DemoThread d1 = new DemoThread();
        DemoThread d2 = new DemoThread();
        d1.start();
        d2.start();
        d1.join();
        d2.join();
        System.out.println(i);

    }

}
