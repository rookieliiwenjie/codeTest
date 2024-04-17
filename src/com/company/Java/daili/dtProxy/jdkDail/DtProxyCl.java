package com.company.Java.daili.dtProxy.jdkDail;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 5:22 下午
 * @Description:
 */
public class DtProxyCl implements InvocationHandler {
    /**
     * 中间类持有委托类对象的引用,这里会构成一种静态代理关系
     */
    private Object obj;

    /**
     * 有参构造器,传入委托类的对象
     *
     * @param obj 委托类的对象
     */
    public DtProxyCl(Object obj) {
        this.obj = obj;
    }

    public DtProxyCl() {
    }

    /**
     * 动态生成代理类对象,Proxy.newProxyInstance
     *
     * @return 返回代理类的实例
     */

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(
                //指定代理对象的类加载器
                obj.getClass().getClassLoader(),
                //代理对象需要实现的接口，可以同时指定多个接口
                obj.getClass().getInterfaces(),
                //方法调用的实际处理者，代理对象的方法调用都会转发到这里
                this);
    }

    public Object newProxyIntance(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    public Object getProxy(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        System.out.println("method = " + method);
        Object result = method.invoke(obj, args);
        System.out.println("invoke after");
        return result;

    }
}
