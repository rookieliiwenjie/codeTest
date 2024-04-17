package com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Main;

import com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Interface.Image;

/**
 * @Author rookie.li
 * @create 2020/12/16
 */
public class MyImage extends Image {
    @Override
    public void display() {
        System.out.println(this.getClass().getName());
    }
}
