package com.company.RenfrenceDemo;

import java.lang.ref.SoftReference;

/**
 * Created by lwj32 on 2020/6/16.
 */
public class SoftRenfrenceDemo {
    public static void MemoryEnough() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        object = null;
        System.gc();
        System.out.println("softReference = " + softReference.get());
        System.out.println("object = " + object);
    }

    public static void MemoryNoEnough() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        System.out.println("softReference = " + softReference.get());
        System.out.println("object = " + object);
        object=null;
        try {
            byte[] bytes = new byte[1024 * 30 * 1024];
        } catch (Exception e) {

        } finally {
            System.out.println("softReference = " + softReference.get());
            System.out.println("object = " + object);
        }

    }

    public static void main(String[] args) {
        MemoryEnough();
        //MemoryNoEnough();
    }
}

