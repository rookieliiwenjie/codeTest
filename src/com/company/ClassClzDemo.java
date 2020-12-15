/*
package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

*/
/**
 * @Author rookie.li
 * @create 2020/10/27
 *//*


public class ClassClzDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setPrice(12);
        try {
            Class clz = Apple.class;*/
/*Class.forName("com.company.Apple");*//*

            ReentrantLock reentrantLock = new ReentrantLock();
            reentrantLock.lock();
            Field[] fields = clz.getDeclaredFields();
            Auth ac = (Auth) clz.getDeclaredAnnotation(Auth.class);
            System.out.println("ac = " + ac);
            for(Field field: fields){
                if(field.isAnnotationPresent(Auth.class)){
                    Auth bananaAnnotation = field.getDeclaredAnnotation(Auth.class);
                    System.out.println("bananaAnnotation"+bananaAnnotation);
                }
            }
            Auth Auth = (com.company.Auth) clz.getAnnotation(Auth.class);
            System.out.println("annotation = " + Auth);
            Method[] methods = clz.getMethods();
            Constructor constructor = clz.getConstructor();
            Object instance = constructor.newInstance();
            for (Method method : methods) {
                System.out.println("method = " + method.getName());
                if (method.getName().equals("setPrice")) {
                    Auth annotation1 = method.getAnnotation(Auth.class);
                    System.out.println("annotation1 = " + annotation1.neii());
                    System.out.println(" = " + method.invoke(instance, 22));
                }
            }
            Method getPrice = clz.getMethod("getPrice");
            System.out.println("getPrice.invoke(instance) = " + getPrice.invoke(instance));
            // System.out.println("clz.getPackage() = " + clz.getPackage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("e = " + e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
*/
