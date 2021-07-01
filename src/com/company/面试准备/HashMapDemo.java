package com.company.面试准备;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by lwj32 on 2021/6/8.
 */
public class HashMapDemo {
    static Random random = new Random(10);
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i =0;i<10;i++){
            hashMap.put(i,i);
        }
        new Thread(()->{
            int i = 10;
            for (int j = 1; j < 100000; j++) {
                hashMap.put(j,j);

            }
        }).start();
        new Thread(()->{
            Iterator iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                System.out.println("iterator.next() = " + entry.getKey()+entry.getValue());
            }
        }).start();


    }
}
