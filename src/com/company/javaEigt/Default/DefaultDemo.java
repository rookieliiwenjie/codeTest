package com.company.javaEigt.Default;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class DefaultDemo {
    public static void main(String[] args) {
        Defalut defalut = new Defalut() {
            @Override
            public int add(int i) {
                return (int) (sqrt(i) + 1);
            }
        };
        System.out.println("defalut.add(1) = " + defalut.add(1));
    }
}
