package com.company.shejimoshi.AbstrabeFactory;

import com.company.shejimoshi.AbstrabeFactory.Enum.FactoryEnum;
import com.company.shejimoshi.AbstrabeFactory.Enum.MatchFatcher;
import com.company.shejimoshi.AbstrabeFactory.color.Color;
import com.company.shejimoshi.AbstrabeFactory.shape.Shape;

import java.util.AbstractList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> aClass =  FactoryEnum.COLOR.getClazz();
        AbstractFactory abstractFactory = (AbstractFactory) aClass.newInstance();
        Color red = abstractFactory.getColor("红色");
        red.drwa();
        Class<?> clazzShape = FactoryEnum.SHAPE.getClazz();
        AbstractFactory clazzFactory = (AbstractFactory) clazzShape.newInstance();
        Shape shap = clazzFactory.getShape("圆");
        shap.fill();
    }
}
