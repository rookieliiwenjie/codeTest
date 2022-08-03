package com.company.javaEigt.JavaEightDemo.domain;

/**
 * @Author: wenjie.li
 * @Date: 2022/7/29 2:11 下午
 * @Description:
 */

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
@ToString
public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Student s) {
        return age.compareTo(s.getAge());
    }

    public static List<Student> getStudentList() {
        Student s1 = new Student("Ram", 18);
        Student s2 = new Student("Shyam", 22);
        Student s3 = new Student("Mohan", 19);
        Student s4 = new Student("Mahesh", 20);
        Student s5 = new Student("Krishna", 21);
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
        return list;
    }
}

