package com.company.abstractDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 11:44 下午
 * @Description:
 */
public interface InterFaceDemo {
    abstract void jiaoIn();
    static final int i =0;
    /**
     * 接口中除了抽象方法，还可以有默认方法（default）、静态方法(static)、私有方法（private
     */
    static int demo(){
        return i;
    }
    default void demo2(){

    }
}
