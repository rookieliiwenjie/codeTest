package com.company.shejimoshi.prototype;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 11:43 下午
 * @Description:
 */
public class CloneDemo implements Cloneable {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "CloneDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (CloneDemo)super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
