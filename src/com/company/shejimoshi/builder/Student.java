package com.company.shejimoshi.builder;

import lombok.Builder;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 6:33 下午
 * @Description:
 */
public class Student {
    private String schoolName;
    private String grade;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
