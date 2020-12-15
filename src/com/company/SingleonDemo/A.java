package com.company.SingleonDemo;

/**
 * Created by lwj32 on 2020/6/19.
 */
class B{
    static {
        System.out.println("Bsta");
    }

    public B() {
        System.out.println("B");
    }
}

class C extends B{
    static {
        System.out.println("C static");
    }

    public C() {
        System.out.println("C");
    }
}

public class A {
 public static void main(String argsp[]){
     B b = new B();
     b = new B();
 }
}

