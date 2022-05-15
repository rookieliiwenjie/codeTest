package com.company.shejimoshi.prototype.manger;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 5:42 下午
 * @Description:
 */
public class ProtoTypeManager {

    private final HashMap<String, Shape> stringShapeHashMap = new HashMap<>();

    public ProtoTypeManager() {
        stringShapeHashMap.put("Circle", new Circle());
        stringShapeHashMap.put("Square", new Square());
    }

    public Shape getShape(String type) {
        return (Shape) stringShapeHashMap.get(type).clone();
    }

    public void addShape(String name, Shape shape) {
        stringShapeHashMap.put(name, shape);
        System.out.println("stringShapeHashMap = " + stringShapeHashMap.toString());
    }

}
