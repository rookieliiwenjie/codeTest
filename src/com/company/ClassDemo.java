package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author rookie.li
 * @create 2020/11/4
 */
public class ClassDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class apple = Apple.class;
        Constructor constructors = apple.getConstructor();
       /* try {
            Object instance = constructors.newInstance();
            System.out.println("instance = " + instance);
            Method setName = apple.getMethod("setName", String.class);
            Object liwenjie = setName.invoke(instance, "liwenjie");
            System.out.println("liwenjie = " + liwenjie);
            Apple apple1 = (Apple) apple.newInstance();
            Method getName = apple.getMethod("getName");
            System.out.println("getName = " + getName.invoke(instance));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
       
        
    }
}
