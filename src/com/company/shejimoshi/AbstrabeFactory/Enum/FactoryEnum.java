package com.company.shejimoshi.AbstrabeFactory.Enum;

import com.company.shejimoshi.AbstrabeFactory.ColorFactory;
import com.company.shejimoshi.AbstrabeFactory.ShapeFactory;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public enum FactoryEnum implements MatchFatcher {
    COLOR("颜色", ColorFactory.class),
    SHAPE("形状", ShapeFactory.class);
    private String desc;
    private Class<?> clazz;

    FactoryEnum(String desc, Class<?> clazz) {
        this.desc = desc;
        this.clazz = clazz;
    }

    public String getDesc() {
        return desc;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    @Override
    public Class<?> match(String desc) {
        FactoryEnum[] factoryEnum = FactoryEnum.values();
        for (int i = 0; i < factoryEnum.length; i++) {
            if(factoryEnum[i].getDesc().equals(desc)){
                return factoryEnum[i].getClazz();
            }
        }
        return null;
    }
}
