package com.company.Java.daili.staticProxy;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:09 下午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        StaticProxyCl staticProxyCl = new StaticProxyCl(new TargetCl());
        staticProxyCl.staticProxy();
        StaticProxyCl staticProxyCl2 = new StaticProxyCl(new Target2Cl());
        staticProxyCl2.staticProxy();
    }
}
