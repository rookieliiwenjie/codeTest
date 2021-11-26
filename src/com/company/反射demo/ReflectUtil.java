package com.company.反射demo;

import com.company.DemoFatory.Father;

import java.lang.reflect.Field;

/**
 * @Author rookie.li
 * @create 2021/4/22
 */
public class ReflectUtil {
    private ReflectUtil() {
    }

    public static void main(String[] args) {
        FatherDemo fatherDemo = new FatherDemo();
        Field name = getField(fatherDemo, "name");
        System.out.println("name = " + name);
        Field age = getField(fatherDemo, "age");
        System.out.println("age = " + age);
        Field pulicName = getField(fatherDemo, "pulicName");
        System.out.println("pulicName = " + pulicName);
        System.out.println("fatherDemo = " + fatherDemo);
        SonDemo sonDemo = new SonDemo();
        Field sonFatherDemoname = getField(sonDemo, "name");
        System.out.println("sonFatherDemoname = " + sonFatherDemoname);
        Field pulicNameName = getField(sonDemo, "pulicName");
        System.out.println("pulicNameName = " + pulicNameName);
        Field sonName = getField(sonDemo, "sonName");
        System.out.println("sonName = " + sonName);
        System.out.println("sonName = " + sonDemo);


    }

    /**
     * 利用反射获取指定对象的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(obj, "11111");
                break;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                //这里不用做处理，子类没有该字段，可能父类有，都没有就返回null
                e.printStackTrace();

            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     *
     * @param obj        目标对象
     * @param fieldName  目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName, Object fieldValue) throws IllegalAccessException {
        Field field = getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            field.set(obj, fieldValue);
        }
    }
}
