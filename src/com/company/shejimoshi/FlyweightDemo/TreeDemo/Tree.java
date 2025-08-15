package com.company.shejimoshi.FlyweightDemo.TreeDemo;

/**
 * 内部状态
 */
public class Tree {
    String type;
    String color;
    String name;
    public void draw(int x, int y) {
        System.out.printf("在(%d,%d)绘制%s色的%s（纹理：%s）%n",
                x, y, color, name, type);
    }
    public Tree(String type, String color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
