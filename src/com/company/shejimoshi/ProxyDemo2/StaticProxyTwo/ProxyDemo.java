package com.company.shejimoshi.ProxyDemo2.StaticProxyTwo;


import com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Main.MyImage;
import com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Main.MyImageTwo;
import com.company.shejimoshi.ProxyDemo2.StaticProxyTwo.Main.ProxyImage;

/**
 * @Author rookie.li
 * @create 2020/12/16
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage(new MyImage());
        proxyImage.display();

        ProxyImage proxyImage2 = new ProxyImage(new MyImageTwo());
        proxyImage2.display();
    }
}
