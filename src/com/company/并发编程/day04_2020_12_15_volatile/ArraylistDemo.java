package com.company.并发编程.day04_2020_12_15_volatile;

import java.util.ArrayList;

/**
 * @Author rookie.li
 * @create 2021/2/4
 */
public class ArraylistDemo {
    public static void main(String[] args) {
        Integer x = 1;
        if(x instanceof Object){
            System.out.println("x = " + x);
        }
        if(x instanceof Integer){
            System.out.println("x = " + x);
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("10000");
        if(arrayList.contains("10000")){
            System.out.println("ok = ");
        }
    }
}
