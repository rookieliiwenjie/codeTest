package com.company.Java.daili.staticProxy;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:06 下午
 * @Description: 代理类
 */
public class StaticProxyCl implements StaticProxy{
    private StaticProxy targetCl;

    public StaticProxyCl(StaticProxy targetCl) {
        this.targetCl = targetCl;
    }

    @Override
    public void staticProxy() {
        System.out.println(" 代理开始" );
        targetCl.staticProxy();
        System.out.println(" 代理结束" );
    }
}
