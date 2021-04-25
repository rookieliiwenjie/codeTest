package com.company.shejimoshi.ProxyDemo.StaticProxy.Main;

import com.company.shejimoshi.ProxyDemo.StaticProxy.Interface.Image;

/**
 * @Author rookie.li
 * @create 2020/12/16
 */
public class MyImage implements Image {
    @Override
    public void display() {
        System.out.println("myImage" );
    }
}
