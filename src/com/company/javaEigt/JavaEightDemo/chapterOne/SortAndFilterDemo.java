package com.company.javaEigt.JavaEightDemo.chapterOne;


import com.company.javaEigt.JavaEightDemo.domain.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/9 11:40 下午
 * @Description:
 */
public class SortAndFilterDemo {
    public static void main(String[] args) {
        List<Student> studentList = Student.getStudentList()
                .stream().filter(student -> "Ram".equals(student.getName()))
                .sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println("studentList = " + studentList);
        
    }
}
