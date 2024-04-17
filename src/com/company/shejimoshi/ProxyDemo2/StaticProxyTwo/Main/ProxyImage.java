package com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Main;


import com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Interface.Image;

/**
 * @Author rookie.li
 * @create 2020/12/16
 */
public class ProxyImage extends Image {
    private Image myImage = new Image();

    public ProxyImage(Image myImage) {
        this.myImage = myImage;
    }

    @Override
    public void display() {
        myImage.display();
    }
}
