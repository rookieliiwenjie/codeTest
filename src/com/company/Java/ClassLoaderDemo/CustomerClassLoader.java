package com.company.Java.ClassLoaderDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/14 8:31 下午
 * @Description:
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomerClassLoader extends ClassLoader{

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/liuyuhang/Downloads/liwenjie/codeTest/src", name.replace(".", "\\").concat(".class"));
        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b = fis.read(buffer)) != -1) {
                bos.write(buffer,0, b);
            }
            byte[] bytes = bos.toByteArray();
            System.out.println("file = " + file);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("file = " + file);
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader();
        Class clazz = customerClassLoader.loadClass("com.company.Java.ClassLoaderDemo.ClassLoaderDemo",false);
        Object o = clazz.newInstance();
        System.out.println("o = " + o);
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("classLoader = " + classLoader);
//        Method method = clazz.getMethod("testMethod");
//        method.invoke(clazz.newInstance(), null);
    }
}