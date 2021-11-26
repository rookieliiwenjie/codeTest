package com.company.shejimoshi.BuilderDemo;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.Meal;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.MealBuilder;

import java.lang.annotation.Annotation;

/**
 * @Author rookie.li
 * @create 2020/11/4
 */
public class Main {
    public static void main(String[] args) {
        //StringBuilder stringBuilder = new StringBuilder();
        //Annotation annotation
        MealBuilder malBuilder = new MealBuilder();
        malBuilder.chickenAndCokeMeal().showItem();
    }
}
