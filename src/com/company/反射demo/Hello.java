package com.company.反射demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/3 3:48 下午
 * @Description:
 */
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface   Hello {
    String value();
}
