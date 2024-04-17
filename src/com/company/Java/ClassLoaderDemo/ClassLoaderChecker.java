package com.company.Java.ClassLoaderDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/14 8:47 下午
 * @Description:
 */
public class ClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/liuyuhang/Downloads/liwenjie/codeTest/src/com/company/Java/ClassLoaderDemo/", "random");
        Class<?> c = myClassLoader.loadClass("Hello");
        System.out.println("ClassLoader:" + c.getClassLoader());
        System.out.println("ClassLoader.parent:" + c.getClassLoader().getClass().getClassLoader());
        Object instance = c.newInstance();
    }

}
