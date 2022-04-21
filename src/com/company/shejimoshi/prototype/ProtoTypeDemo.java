package com.company.shejimoshi.prototype;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 11:46 下午
 * @Description:
 */
public class ProtoTypeDemo {
    public static void main(String[] args) {
        CloneDemo cloneDemo = new CloneDemo();
        System.out.println("cloneDemo = " + cloneDemo);
        try {
            CloneDemo clone = (CloneDemo) cloneDemo.clone();
            clone.setName("liwenjie");
            System.out.println("clone = " + clone);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        cloneDemo.setAge(1);
        System.out.println("cloneDemo = " + cloneDemo);
    }
}
