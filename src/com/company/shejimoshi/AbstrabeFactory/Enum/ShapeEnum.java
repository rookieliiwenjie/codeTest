package com.company.shejimoshi.AbstrabeFactory.Enum;

import com.company.shejimoshi.AbstrabeFactory.AbstractFactory;
import com.company.shejimoshi.AbstrabeFactory.color.Red;
import com.company.shejimoshi.AbstrabeFactory.shape.Rectangle;
import com.company.shejimoshi.AbstrabeFactory.shape.Suare;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public enum ShapeEnum {

    RED("圆", Rectangle.class),
    BULE("方", Suare.class);
    private String desc;
    private Class<?> clazz;

    ShapeEnum(String desc, Class<?> clazz) {
        this.desc = desc;
        this.clazz = clazz;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public AbstractFactory match(String matchFatcher) {

        return null;
    }
}
