package com.company.反射demo;

/**
 * @Author rookie.li
 * @create 2021/4/22
 */
public class FatherDemo {

    private String name;

    private String age;

    public String pulicName;

    @Override
    public String toString() {
        return "FatherDemo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", pulicName='" + pulicName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPulicName() {
        return pulicName;
    }

    public void setPulicName(String pulicName) {
        this.pulicName = pulicName;
    }
}
