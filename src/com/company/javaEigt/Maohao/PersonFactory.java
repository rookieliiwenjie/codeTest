package com.company.javaEigt.Maohao;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public interface PersonFactory<P extends Person> {
    P create(Integer age);
}
