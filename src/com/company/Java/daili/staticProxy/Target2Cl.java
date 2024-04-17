package com.company.Java.daili.staticProxy;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:04 下午
 * @Description:
 */
public class Target2Cl implements StaticProxy{
    @Override
    public void staticProxy() {
        System.out.println(" taget2Cl " + this.getClass().getName());
    }
}
