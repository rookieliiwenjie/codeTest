package com.company.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/13 11:51 下午
 * @Description:
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    private final HashMap<Integer,HashMap<Integer,Integer>> hashMap = new HashMap();
    private Integer oldestValue = 1;
    private int capacitys;
    public LRUCache(int capacity) {
        capacitys = capacity;
    }

    public int get(int key) {
        if (hashMap.size() <= 0 || hashMap.get(key) == null) {
            return -1;
        }
        HashMap<Integer, Integer> hashMap = this.hashMap.get(key);
        Integer value = hashMap.keySet().stream().findFirst().get();
        int version =oldestValue+1;
        oldestValue = value;
        hashMap.put(value,version);
        return value;
    }

    public void put(int key, int value) {
        if (capacitys <= hashMap.size()) {
            int min = Integer.MAX_VALUE;
            int keyMax = 0;
            for (Integer ky : hashMap.keySet()) {
                HashMap<Integer, Integer> caHashMap = this.hashMap.get(ky);
                Integer caky = caHashMap.keySet().stream().findFirst().get();
                if (caHashMap.get(caky) < min) {
                    min = caHashMap.get(caky);
                    keyMax = ky;
                }
                caHashMap.put(caky,oldestValue);
            }
            hashMap.remove(keyMax);
        }
        HashMap<Integer,Integer> caHas = new HashMap<>();
        oldestValue = oldestValue + 1;
        caHas.put(value, oldestValue);
        hashMap.put(key,caHas);
    }

    public static void main(String[] args) {
//        ["LRUCache","put","put","get","put","put","get"]
//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
//        输出
// [null,null,null,2,null,null,2]
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.get(1);    // 返回 1
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println("lRUCache = " + lRUCache.hashMap);
        //它应该在写入新数据之前删除最久未使用的数据值，
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println("lRUCache = " + lRUCache.hashMap);
        lRUCache.get(3);    // 返回 3
        System.out.println("lRUCache = " +  lRUCache.get(3));
        lRUCache.get(4);    // 返回 4
    }



}
