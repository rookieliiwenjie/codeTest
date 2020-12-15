package com.company.ColleciontUnSafeDemo;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lwj32 on 2020/5/18.
 */
//1.ArrayList线程不安全复现
//java.util.ConcurrentModificationException

/**
 * 2.ArrayList线程不安全原因 add 方法线程不安全
 * public boolean add(E e) {
 * ensureCapacityInternal(size + 1);  // Increments modCount!!
 * elementData[size++] = e;
 * return true;
 * }
 * <p>
 * <p>
 * 解决方案1， Vector add
 * public synchronized boolean add(E e) {
 * modCount++;
 * ensureCapacityHelper(elementCount + 1);
 * elementData[elementCount++] = e;
 * return true;
 * }
 * <p>
 * 2.Collections.synchronizedList(new ArrayList)
 * 3.copyOnWriteArrayList 写时复制
 * public boolean add(E e) {
 * final ReentrantLock lock = this.lock;
 * lock.lock();
 * try {
 * Object[] elements = getArray();
 * int len = elements.length;
 * Object[] newElements = Arrays.copyOf(elements, len + 1);
 * newElements[len] = e;
 * setArray(newElements);
 * return true;
 * } finally {
 * lock.unlock();
 * }
 * }
 * 4.使用ReentrantLock 加锁根据CopyOnWriteArrayList源码实现
 * List<String> arrayList = new ArrayList<>();
 * ReentrantLock lock = new ReentrantLock();
 * for (int i = 0; i < 3000; i++) {
 * <p>
 * new Thread(() -> {
 * lock.lock();
 * try{
 * arrayList.add(UUID.randomUUID().toString().substring(0,8));
 * System.out.println(Thread.currentThread().getName() + arrayList);
 * }catch (Exception e){
 * <p>
 * }finally {
 * lock.unlock();
 * }
 * <p>
 * <p>
 * }, String.valueOf(i)).start();
 * <p>
 * }
 * <p>
 * 写时复制
 * CopyOnWrite容器即写时复制的容器，往一个容器添加元数的时候，不直接向Object[]添加
 * ，而是先向Object[]进行copy，Arrays.copyof(oldElements,oldElement.len+1)复刻出一个新的容器Object[] new Elements
 * 然后向新的容器里添加一个元素，再将原容器的引用指向新的容器setArray(new Elements)，这样的好处是可以对CopyOnWrite容器进行并发读
 * 而不需要加锁，因为当前容器不会添加任何元素，因为加锁的缘故，只能有一个进行写操作，所以copyOnWrite容器也是一种分离的思想，读和写不同的容器
 * 读写分离的思想
 */
public class ArrayListUnsfeDemo {

    public static void main(String args[]) {
        //List<String> arrayList =  Collections.synchronizedList(new ArrayList<>()) ;
        //List<String> arrayList = new ArrayList<>();
        /**
         *
         */
        VeterDemo();
        CollectionsSysDemo();
        CopyOnWriteArrayListDemo();
        ReentrantLockDemo();
        /**数据3000
         * Vector use Time is 284
         * Collections use Time is 265
         * Collections use Time is 667
         * Collections use Time is 326
         * 数据30000
         * Vector use Time is 4659
         * Collections use Time is 43458
         * Collections use Time is 4215
         * Collections use Time is 4144
         * 数据300000
         * Vector use Time is 45930
         * Collections use Time is 43190
         * Collections use Time is 56092
         * Collections use Time is 42511
         */

    }

    public static void VeterDemo() {
        List<String> arrayList = new Vector<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));

            }).start();
        }
        System.out.println("Vector use Time is " + (System.currentTimeMillis() - startTime) + "\t");
    }

    public static void CollectionsSysDemo() {
        List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));

            }).start();
        }
        System.out.println("Collections use Time is " + (System.currentTimeMillis() - startTime) + "\t");
    }

    public static void CopyOnWriteArrayListDemo() {
        List<String> arrayList = new CopyOnWriteArrayList();
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
