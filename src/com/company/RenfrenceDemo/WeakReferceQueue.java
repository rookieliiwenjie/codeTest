package com.company.RenfrenceDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by lwj32 on 2020/6/16.
 */
public class WeakReferceQueue {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object,referenceQueue);
        System.out.println("phantomReference = " + phantomReference.get());
        System.out.println("referenceQueue = " + referenceQueue.poll());
        System.out.println("object = " + object);
        object=null;
        System.gc();
        Thread.sleep(200);
        System.out.println("phantomReference = " + phantomReference.get());
        System.out.println("referenceQueue = " + referenceQueue.poll());
        System.out.println("object = " + object);
    }
}
