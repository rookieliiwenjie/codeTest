package com.company.RenfrenceDemo;

import sun.font.AttributeMap;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by lwj32 on 2020/6/16.
 */
public class WeakReferceDemo {
    public static void main(String[] args) {
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        System.out.println("weakReference.get() = " + weakReference.get());
        System.out.println("object = " + object);
        object = null;
        System.gc();
        System.out.println("weakReference.get() = " + weakReference.get());
        System.out.println("object = " + object);
        Map<String, SoftReference<AttributeMap>> imageCatche = new HashMap<>();
        WeakHashMap<String,String> weakHashMap = new WeakHashMap<>();

    }
}
