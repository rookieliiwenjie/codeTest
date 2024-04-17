package com.company.shejimoshi.Observer;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/12 12:07 上午
 * @Description:
 */
public class demo {
    private int i ;
    private int z = 1;
    private void  add(){
        i=i+1;
    }
    public demo() {
        this.i = 1;
    }

    public static void main(String[] args) {
        demo demo = new demo();
        demo.add();
        System.out.println("demo = " + demo.i);
        System.out.println("demo = " + demo.z);
        demo demo2 = new demo();
        demo2.add();
        System.out.println("demo2.i = " + demo2.i);
        System.out.println("demo2.i = " + demo2.i);
    }

}
