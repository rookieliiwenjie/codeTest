package com.company.Java.objectpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool<T> {
    private BlockingQueue<T> poll;
    private ObjectFactory<T> factory;
    private int size;

    public ObjectPool(int size, ObjectFactory<T> factory) {
        this.size = size;
        this.factory = factory;
        this.poll = new LinkedBlockingQueue<>(size);
    }

    public static ObjectPool create(int size, ObjectFactory factory) {
        return new ObjectPool<>(size, factory);
    }


    public T borrowObject() throws InterruptedException {
        if (poll.isEmpty()) {
            synchronized (this) {
                if (poll.isEmpty()) {
                    for (int i = 0; i < size; i++) {
                        poll.offer(factory.createObject());
                    }
                }
            }
        }
        return poll.take();
    }

    public void returnObject(T object) {
        poll.offer(object);
    }

    public static ObjectPool createObjectPool(int size, ObjectFactory factory) {
        return new ObjectPool(size, factory);
    }

}
