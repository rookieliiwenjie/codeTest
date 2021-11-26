package com.company.ExamCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 11:37
 */
public class ProduceAndConsumerDemo {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Consumer consumer = new Consumer();
        consumer.start();
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        public void produce() {
            while (true) {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 生产者长度" + queue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        public void consumer() {
            while (true) {
                try {
                    Integer take = queue.take();
                    Thread.sleep(2000);
                    System.out.println("true = " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
