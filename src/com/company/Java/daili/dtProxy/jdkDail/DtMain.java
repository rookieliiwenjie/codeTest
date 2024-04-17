package com.company.Java.daili.dtProxy.jdkDail;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:30 下午
 * @Description:
 */
public class DtMain {
    public static void main(String[] args) {
        DtProxyCl proxyCl = new DtProxyCl(new DtTargetClass());
        DtProxyInterface dtTargetClass = (DtProxyInterface) proxyCl.newProxyInstance();
        dtTargetClass.sayByebye("liwe");
//        proxyCl.invoke(new DtTargetClass(),"sayName","nn");
        DtProxyCl dtProxyCl = new DtProxyCl();
        DtProxyInterface proxy = (DtProxyInterface) dtProxyCl.getProxy(new DtTargetClass());
    }
}
