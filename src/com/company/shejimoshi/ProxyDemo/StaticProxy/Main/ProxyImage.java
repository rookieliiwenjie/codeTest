package com.company.shejimoshi.ProxyDemo.StaticProxy.Main;

import com.company.shejimoshi.ProxyDemo.StaticProxy.Interface.Image;

/**
 * @Author rookie.li
 * @create 2020/12/16
 */
public class ProxyImage implements Image {
    private MyImage myImage = new MyImage();

    @Override
    public void display() {
        myImage.display();
    }
}
