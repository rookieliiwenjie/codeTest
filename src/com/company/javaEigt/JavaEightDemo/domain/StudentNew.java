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
public class StudentNew implements Comparable<StudentNew> {
    private String name;
    private Integer age;
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentNew(String name, Integer age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(StudentNew s) {
        return age.compareTo(s.getAge());
    }

//    public static List<StudentNew> getStudentList() {
////        StudentNew s1 = new StudentNew("Ram", 18);
////        StudentNew s2 = new StudentNew("Ram", 22);
////        StudentNew s3 = new StudentNew("Mohan", 19);
////        StudentNew s4 = new StudentNew("Mahesh", 20);
////        StudentNew s5 = new StudentNew("Krishna", 21);
////        List<StudentNew> list = Arrays.asList(s1, s2, s3, s4, s5);
////        return list;
//    }
}

