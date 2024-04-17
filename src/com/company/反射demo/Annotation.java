package com.company.反射demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/3 3:44 下午
 * @Description:
 */
@Deprecated
@Hello("vv")
public class Annotation {
    @Hello("dd")
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Class clss = Annotation.class;
        Class<? extends Class> aClass = clss.getClass();
        System.out.println("clss.getClassLoader = " + clss.getClassLoader());
        java.lang.annotation.Annotation[] annotations = clss.getAnnotations();
        for (java.lang.annotation.Annotation annotation: annotations) {
            if(annotation.annotationType()==Deprecated.class){
                System.out.println("annotations = " + annotation);
            }
        }
        Method main = clss.getMethod("main", String[].class);
        Hello annotation = main.getAnnotation(Hello.class);
        System.out.println("annotation.value() = " + annotation.value());

        Class<?> annotation1 = Class.forName("com.company.反射demo.Annotation");
        Constructor[] constructors = clss.getConstructors();
        for (Constructor constructor :constructors) {
            System.out.println("constructor = " + constructor);
        }
    }
}
