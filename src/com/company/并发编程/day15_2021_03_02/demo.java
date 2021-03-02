package com.company.并发编程.day15_2021_03_02;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 写线程
 */
public class demo {

    public static class Producer extends Thread {
        //输出流
        private PipedWriter writer = new PipedWriter();

        public Producer(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Hello World!");
                writer.write(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取线程
     */
    public static class Consumer extends Thread {
        //输入流
        private PipedReader reader = new PipedReader();

        public Consumer(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            try {
                char[] cbuf = new char[20];
                reader.read(cbuf, 0, cbuf.length);
                System.out.println("管道流中的数据为: " + new String(cbuf));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        /**
         * 管道流通信核心是,Writer和Reader公用一块缓冲区,缓冲区在Reader中申请,
         * 由Writer调用和它绑定的Reader的Receive方法进行写.
         *
         * 线程间通过管道流通信的步骤为
         * 1 建立输入输出流
         * 2 绑定输入输出流
         * 3 Writer写
         * 4 Reader读
         */
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        Producer producer = new Producer(writer);
        Consumer consumer = new Consumer(reader);

        try {
            writer.connect(reader);
            producer.start();
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
