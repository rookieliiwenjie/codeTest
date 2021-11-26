package com.company.shejimoshi.AbstrabeFactory;

import com.company.shejimoshi.AbstrabeFactory.Enum.ColorEnum;
import com.company.shejimoshi.AbstrabeFactory.color.Color;
import com.company.shejimoshi.AbstrabeFactory.shape.Shape;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class ColorFactory extends AbstractFactory{
    @Override
     Color getColor(String color) {
        ColorEnum colorEnum[] = ColorEnum.values();
        for (int i = 0; i < colorEnum.length; i++) {
            if(color.equals(colorEnum[i].getDesc())){
                try {
                    return (Color) colorEnum[i].getClazz().newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
     Shape getShape(String shape) {
        return null;
    }
}
