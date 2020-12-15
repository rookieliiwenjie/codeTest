package com.company.ColleciontUnSafeDemo;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * hashset底层是由hashmap实现
 * 而add方法就是hashmap的put方法
 * public boolean add(E e) {
 * return map.put(e, PRESENT)==null;
 * }
 * 因此解释了为啥set的值不能重复
 */
public class SetUnsfeDemo {

    public static void main(String args[]) {
        //List<String> arrayList =  Collections.synchronizedList(new ArrayList<>()) ;
        //List<String> arrayList = new ArrayList<>();
        /**
         *
         */
/*        CollectionsSysDemo();
        CopyOnWriteArrayListDemo();
        ReentrantLockDemo();*/
        /*HashSet set = new HashSet();
        set.add("1");*/
        Set<String> arrayList = new TreeSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(arrayList);

            }).start();
        }
        System.out.println("Collections use Time is " + (System.currentTimeMillis() - startTime) + "\t");

    }

    public static void CollectionsSysDemo() {
        Set<String> arrayList = Collections.synchronizedSet(new HashSet<>());
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));

            }).start();
        }
        System.out.println("Collections use Time is " + (System.currentTimeMillis() - startTime) + "\t");
    }

    public static void CopyOnWriteArrayListDemo() {
        Set<String> arrayList = new CopyOnWriteArraySet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));

            }).start();
        }
        System.out.println("Collections use Time is " + (System.currentTimeMillis() - startTime) + "\t");
    }

    public static void ReentrantLockDemo() {
        List<String> arrayList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 30000; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    arrayList.add(UUID.randomUUID().toString().substring(0, 8));

                } catch (Exception e) {

                } finally {
                    reentrantLock.unlock();
                }

            }).start();
        }
        System.out.println("Collections use Time is " + (System.currentTimeMillis() - startTime) + "\t");
    }
}
