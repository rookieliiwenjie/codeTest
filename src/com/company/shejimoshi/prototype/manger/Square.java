package com.company.shejimoshi.prototype.manger;

import java.util.Scanner;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 5:33 下午
 * @Description:
 */
public class Square implements Shape {
    @Override
    public void getArea() {
        int a = 0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("该正方形的面积=" + a * a + "\n");
    }

    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("拷贝失败");
        }
        return square;
    }
}
