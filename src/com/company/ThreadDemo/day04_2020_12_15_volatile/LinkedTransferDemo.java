package com.company.ThreadDemo.day04_2020_12_15_volatile;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author rookie.li
 * @create 2020/12/21
 */
public class LinkedTransferDemo {
    private static final int FRONT_SPINS = 1 << 7;

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("FRONT_SPINS = " + FRONT_SPINS);
        //int i1 = Runtime.getRuntime().availableProcessors();
        //System.out.println("i1 = " + i1);


        //linkedTranferDemo();
        LinkedTransferDemo linkedTransferDemo = new LinkedTransferDemo();
        linkedTransferDemo.blockQueue();
    }

    private static void linkedTranferDemo() throws InterruptedException {
        LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue();
        linkedTransferQueue.add(1);
        linkedTransferQueue.offer(2);
        linkedTransferQueue.put(3);
        linkedTransferQueue.tryTransfer(4);
        linkedTransferQueue.transfer(5);
        int size = linkedTransferQueue.size();
        for (int i = 0; i < size; i++) {
            Integer poll = linkedTransferQueue.poll();
            System.out.println("poll = " + poll);
            //Integer peek = linkedTransferQueue.peek();
            //System.out.println("peek = " + linkedTransferQueue.size());
            //System.out.println("peek = " + peek);
        }
    }

    public void blockQueue() {
        AtomicBoolean offer = new AtomicBoolean(true);
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        linkedBlockingQueue.add(1);
        linkedBlockingQueue.add(2);
        linkedBlockingQueue.add(3);
        System.out.println("linkedBlockingQueue = " + linkedBlockingQueue);


        new Thread(() -> {

            try {
                Thread.sleep(10000);
                offer.set(linkedBlockingQueue.offer(3, 5, TimeUnit.SECONDS));
                System.out.println("offer = " + offer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
        while (     offer.get()) {
            new Thread(() -> {
                System.out.println(" ------------------ ");
                Integer poll = linkedBlockingQueue.poll();
                System.out.println("poll = " + poll);
            }).run();
        }
        System.out.println("linkedBlockingQueue = " + linkedBlockingQueue);

    }
}
