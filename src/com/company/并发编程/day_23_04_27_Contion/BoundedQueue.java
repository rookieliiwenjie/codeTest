package com.company.并发编程.day_23_04_27_Contion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author rookie.li
 * @create 2021/4/28
 */
public class BoundedQueue<T> {
    ReentrantLock lock = new ReentrantLock();
    Condition noEmpty = lock.newCondition();
    Condition noFull = lock.newCondition();
    private Object[] items;
    // 添加的下标，删除的下标和数组当前数量
    private int addIndex, removeIndex, count;

    public static void main(String[] args) {

    }

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) {
        lock.lock();
        try {
            while (count == items.length) {
                noFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
                ++count;
            }
            noEmpty.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public T remove(T t) {
        lock.lock();
        try {

            while (count == 0) {
                noEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
                --count;

            }
            noFull.signal();
            return (T) x;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return null;
    }
}
