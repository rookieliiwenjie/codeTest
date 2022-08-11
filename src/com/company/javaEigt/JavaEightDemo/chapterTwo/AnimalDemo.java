package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Animal;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/11 7:39 下午
 * @Description:
 */
public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println(" eat ");
            }

            @Override
            public void show() {
                System.out.println("show");
            }
        };
        animal.eat();
        animal.show();
    }
}
