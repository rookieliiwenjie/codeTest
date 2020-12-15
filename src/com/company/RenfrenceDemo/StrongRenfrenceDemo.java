package com.company.RenfrenceDemo;

/**
 * Created by lwj32 on 2020/6/16.
 */
public class StrongRenfrenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
       /* Object obj2 = null;
        obj2=obj1;
        obj1=null;*/
        System.gc();
        System.out.println("obj2 = " + obj1);
    }
}
