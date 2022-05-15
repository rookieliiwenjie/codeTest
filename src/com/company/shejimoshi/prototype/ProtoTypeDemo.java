package com.company.shejimoshi.prototype;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 11:46 下午
 * @Description:
 */
public class ProtoTypeDemo {
    public static void main(String[] args) {
        CloneDemo cloneDemo = new CloneDemo();
        cloneDemo.setAge(1);
        System.out.println("cloneDemo = " + cloneDemo);
        CloneDemo clone = null;
        try {
            clone = (CloneDemo) cloneDemo.clone();
            clone.setName("liwenjie");
            System.out.println("clone = " + clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        cloneDemo.setName("12323");
        System.out.println("cloneDemo = " + cloneDemo);
        System.out.println("clone = " + clone);
    }
}
