package com.company.shejimoshi.AdapterDemo.objectDemo;

import com.company.shejimoshi.AdapterDemo.classDemo.Adaptee;
import com.company.shejimoshi.AdapterDemo.classDemo.Target;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/20 11:45 下午
 * @Description:
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specital();
    }
}
