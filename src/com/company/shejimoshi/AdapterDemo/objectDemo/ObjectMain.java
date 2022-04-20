package com.company.shejimoshi.AdapterDemo.objectDemo;

import com.company.shejimoshi.AdapterDemo.classDemo.Adaptee;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/20 11:47 下午
 * @Description:
 */
public class ObjectMain {
    public static void main(String[] args) {
        ObjectAdapter objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.request();
    }
}
