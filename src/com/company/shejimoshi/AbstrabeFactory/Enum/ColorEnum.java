package com.company.shejimoshi.AbstrabeFactory.Enum;

import com.company.shejimoshi.AbstrabeFactory.AbstractFactory;
import com.company.shejimoshi.AbstrabeFactory.color.Bule;
import com.company.shejimoshi.AbstrabeFactory.color.Red;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public enum ColorEnum {

    RED("红色", Red.class),
    BULE("蓝色", Bule.class);
    private String desc;
    private Class<?> clazz;

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

    ColorEnum(String desc, Class<?> clazz) {
        this.desc = desc;
        this.clazz = clazz;
    }

    public AbstractFactory match(String matchFatcher) {
        return null;
    }
}
