package com.company.dem;

public abstract class PrionityDemo {
    public static class HighTread extends Thread {
        static int i = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (HighTread.class) {
                    i++;
                    if (i >= 10000000) {
                        System.out.println("HighTread finshed");
                        break;
                    }

                }
            }
        }
    }

    public static class LowThread extends Thread {
        static int i = 1;

        @Override
        public void run() {
            while (true) {
                synchronized (LowThread.class) {

                    i++;
                    if (i >= 19999) {
                        System.out.println("LowThread finshed");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HighTread h = new HighTread();
        LowThread l = new LowThread();
        h.setPriority(Thread.MAX_PRIORITY);
        l.setPriority(Thread.MIN_PRIORITY);
        h.start();
        l.start();

    }

}
