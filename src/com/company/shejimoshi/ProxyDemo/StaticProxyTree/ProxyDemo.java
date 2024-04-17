package com.company.shejimoshi.ProxyDemo.StaticProxyTree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 11:02 上午
 * @Description: 代理类和实现类都实现同一个接口
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new DogSubject());
        proxyObject.target();
    }
}
