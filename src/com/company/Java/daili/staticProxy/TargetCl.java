package com.company.Java.daili.staticProxy;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:04 下午
 * @Description:
 */
public class TargetCl implements StaticProxy{
    @Override
    public void staticProxy() {
        System.out.println(" tagetCl ");
    }
}
