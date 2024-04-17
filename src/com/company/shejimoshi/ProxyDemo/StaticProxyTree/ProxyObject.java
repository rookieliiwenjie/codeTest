package com.company.shejimoshi.ProxyDemo.StaticProxyTree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 10:53 上午
 * @Description:
 */
public class ProxyObject implements TargetInter {
    private DogSubject dogSubject;

    public ProxyObject(DogSubject dogSubject) {
        synchronized (this) {
            if (dogSubject.getClass() == DogSubject.class) {
                this.dogSubject = dogSubject;
            }
        }
    }

    @Override
    public void target() {
        dogSubject.target();
    }
}
