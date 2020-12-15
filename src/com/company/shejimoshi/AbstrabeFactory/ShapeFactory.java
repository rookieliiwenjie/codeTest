package com.company.shejimoshi.AbstrabeFactory;

import com.company.shejimoshi.AbstrabeFactory.Enum.ColorEnum;
import com.company.shejimoshi.AbstrabeFactory.Enum.ShapeEnum;
import com.company.shejimoshi.AbstrabeFactory.color.Color;
import com.company.shejimoshi.AbstrabeFactory.shape.Shape;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        ShapeEnum shapeEnums[] = ShapeEnum.values();
        for (int i = 0; i < shapeEnums.length; i++) {
            if (shape.equals(shapeEnums[i].getDesc())) {
                try {
                    return (Shape) shapeEnums[i].getClazz().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
