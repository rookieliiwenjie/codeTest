package com.company.shejimoshi.builder;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 6:38 下午
 * @Description:
 */
public class StudentBuilder {
    private Student student = new Student();

    private void schoolName(String schoolName) {
        student.setSchoolName(schoolName);
    }

    private void grade(String grade) {
        student.setGrade(grade);
    }
}
