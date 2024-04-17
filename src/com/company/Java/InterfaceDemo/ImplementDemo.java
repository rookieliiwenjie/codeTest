package com.company.Java.InterfaceDemo;

import com.company.Java.ClassLoaderDemo.MyClassLoader;
import com.company.Java.Demo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 5:22 下午
 * @Description:
 */
public class ImplementDemo implements Demo {
    int num = 0;

    @Override
    public int get() {
        return 0;
    }

    @Override
    public int getnum(int num) {
        this.num = num;
        return Demo.super.getnum(num);
    }

    static int getNums() {
        return 1;
    }

//    public static void main(String[] args) {
//        Demo demo = new ImplementDemo();
//    }

    public static void main(String[] args) {
//        MyClassLoader myFileClassLoader = new MyClassLoader("/Users/liuyuhang/Downloads/liwenjie/codeTest/src");
//        Class clazz = null;
//        try {
//            clazz = myFileClassLoader.loadClass("com.company.Java.ClassLoaderDemo.ClassLoaderDemo");
//            System.out.println("clazz.getClassLoader() = " + clazz.getClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            Object o = clazz.newInstance();
//            System.out.println("o = " + o);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
