package com.company.javaBase;

public class StaticDemo {

    static {
        a = 2;
//        System.out.println(a);
        System.out.println("static block");
    }
    static int a = 1;

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
    }
}
