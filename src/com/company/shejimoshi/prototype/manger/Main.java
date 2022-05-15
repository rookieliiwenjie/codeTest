package com.company.shejimoshi.prototype.manger;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 5:44 下午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Shape circle = protoTypeManager.getShape("Circle");
        circle.getArea();
        System.out.println("circle = " + circle);
        Shape circle2 = protoTypeManager.getShape("Circle");
        circle2.getArea();
        System.out.println("circle = " + circle2);
        protoTypeManager.addShape("new",new Circle());
    }
}
