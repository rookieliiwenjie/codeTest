package com.company.shejimoshi.BuilderDemo.InterfeceImpl.PackImpl;

import com.company.shejimoshi.BuilderDemo.Interfece.Packing;

/**
 * @Author rookie.li
 * @create 2020/11/17
 * 纸包装
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "warpper";
    }
}
