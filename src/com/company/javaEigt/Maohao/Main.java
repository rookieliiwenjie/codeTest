package com.company.javaEigt.Maohao;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create(1);
    }
}
