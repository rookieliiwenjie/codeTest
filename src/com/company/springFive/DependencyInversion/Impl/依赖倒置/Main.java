package com.company.springFive.DependencyInversion.Impl.依赖倒置;

/**
 * Created by lwj32 on 2021/6/29.
 */
public class Main {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.study(new PythonCourse());
    }
}
