package com.company.shejimoshi.BuilderDemo.InterfeceImpl.PackImpl;

import com.company.shejimoshi.BuilderDemo.Interfece.Packing;

/**
 * @Author rookie.li
 * @create 2020/11/17
 * 瓶子包装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
