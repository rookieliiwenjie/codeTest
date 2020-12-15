package com.company.shejimoshi.AbstrabeFactory;

import com.company.shejimoshi.AbstrabeFactory.color.Color;
import com.company.shejimoshi.AbstrabeFactory.shape.Shape;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public abstract class AbstractFactory {
    abstract  Color getColor(String color);
    abstract  Shape getShape(String Shape);
}
