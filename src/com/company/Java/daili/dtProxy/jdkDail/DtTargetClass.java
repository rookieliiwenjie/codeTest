package com.company.Java.daili.dtProxy.jdkDail;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:21 下午
 * @Description:
 */
public class DtTargetClass implements DtProxyInterface{
    @Override
    public void sayName(String name) {
        System.out.println("name = " + name);
    }

    @Override
    public void sayByebye(String name) {
        System.out.println("DtTargetClassbybye = " + name);
    }
}
