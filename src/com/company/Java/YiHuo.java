package com.company.Java;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/13 5:13 下午
 * @Description:
 */
public class YiHuo {


    /**
     * 按位与&
     */
    public static void test1(int num, int num2) {
        int x = num & num2;
        System.out.println("按位与&:" + x);
    }

    /**
     * 按位或｜
     */
    public static void test2(int num, int num2) {
        int x = num | num2;
        System.out.println("按位或｜" + x);
    }

    /**
     * 按位异或 ^
     *
     * @param num
     * @param num2
     */
    public static void test3(int num, int num2) {
        int x = num ^ num2;
        System.out.println("按位异或 ^" + x);
    }

    public static void main(String[] args) {
        test1(1, 2);
        test2(1, 2);
        test3(1, 2);
        test4(4, 1);
        test5(21, 1);
        test6(-10, 0);
        System.out.println("args = " +  f(2,3));

    }

    /**
     * xy 的平均值
     * @param x
     * @param y
     * @return
     */
    static int f( int x,  int y ) {
        return  (x +y )  >>  1 ;
    }

    /**
     * 左移 << 箭头向那边就向那边移动
     *
     * @param num
     * @param num2
     */
    public static void test4(int num, int num2) {
        int x = num << num2;
        System.out.println("左移：" + x);
    }

    /**
     * 带符号 右移 >>
     *
     * @param num
     * @param num2
     */
    public static void test5(int num, int num2) {
        int x = num >> num2;
        System.out.println("右移" + x);
    }

    /**
     * 不带带符号 右移 >>>
     *
     * @param num
     * @param num2
     */
    public static void test6(int num, int num2) {
        int x = num >>> num2;
        System.out.println("无符号移动" + x);
    }
}
