package com.company.javaEigt.fanshe;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @Author rookie.li
 * @create 2020/12/9
 */
public class demo1 {
    public String Byte(String demo,String name){
        return "1234";
    }
    public static void main(String[] args) throws NoSuchMethodException {
        Class<demo1> demo1Class = demo1.class;
        Method declaredMethods = demo1Class.getDeclaredMethod("Byte",String.class,String.class);
        Parameter[] parameters = declaredMethods.getParameters();
        Arrays.stream(parameters).forEach(parameter -> {

            System.out.println("parameter = " + parameter);
        });


    }
}
