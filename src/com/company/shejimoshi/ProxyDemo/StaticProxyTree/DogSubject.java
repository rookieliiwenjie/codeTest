package com.company.shejimoshi.ProxyDemo.StaticProxyTree;/**
* @Author: wenjie.li
* @Date: 2023/5/31 10:55 上午
* @Description:
*/public class DogSubject implements TargetInter {
    @Override
    public void target() {
        System.out.println("DogSubject = " );
    }
}
