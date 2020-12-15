package com.company.CollectionS;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lwj32 on 2020/8/28.
 */
public class MapDemo {
    public static void main(String[] args) {
        Integer integer = 1;
        Double a = Double.valueOf(1);
        Long lOng = Long.valueOf(1);
        HashMap<Object,Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("1",1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        ArrayList<String> list = new ArrayList<>();
        int [] arr = new int[10];
        ReentrantLock reentrantLock  = new ReentrantLock();
        ConcurrentHashMap<Integer,Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1,2);
        Arrays.asList(arr);
        TreeMap<String,String> map = new TreeMap<>();
        map.put("1","1");
        objectObjectMap.put(1,2);
        System.out.println("objectObjectMap = " +  objectObjectMap.get(1));
    }
}
