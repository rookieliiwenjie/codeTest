package com.company.shejimoshi.AdapterDemo.classDemo;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/20 5:04 下午
 * @Description:
 */
public class AdapterClz extends Adaptee implements Target {
    @Override
    public void request() {
        specital();
    }
}
