package com.company.shejimoshi.AdapterDemo.example;

import com.company.shejimoshi.AdapterDemo.example.adapterclass.ElectricAadpater;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 12:13 上午
 * @Description:
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clz = Class.forName("com.company.shejimoshi.AdapterDemo.example.adapterclass.ElectricAadpater");
        System.out.println("clz = " + clz);
        Target target = (Target) clz.newInstance();
        String name = target.getClass().getName();
        System.out.println("name = " + name);
        target.diver();
    }
}
