package com.company.Java.ReflectionDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 7:59 下午
 * @Description:
 */
public class PersonDemo extends PersonParentDemo{
    private String name;
    public int age;
    private String garden;

    public void soMe() {
        System.out.println("name = " + name);
    }

    public int soAge() {
        return age;
    }

    public static void main(String[] args) {
        Double aLong = Double.valueOf("4.3");
        System.out.println("aLong = " + aLong);
    }
}
