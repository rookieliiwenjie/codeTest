package com.company.javaEigt.JavaEightDemo.domain;

import lombok.ToString;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/11 11:04 上午
 * @Description: 静态内部类
 */
public class Outter {

    private String desc;
    private int num;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static class Inner {
        private String innerDesc;
        private int innerNum;
        private static final String A = "a";

        public String getInnerDesc() {
            return innerDesc;
        }

        public void setInnerDesc(String innerDesc) {
            this.innerDesc = innerDesc;
        }

        public int getInnerNum() {
            return innerNum;
        }

        public void setInnerNum(int innerNum) {
            this.innerNum = innerNum;
        }

        public String show() {
            System.out.println("this.innerDesc+this.innerNum = " + this.innerDesc + this.innerNum);
            return "this.innerDesc+this.innerNum = " + this.innerDesc + this.innerNum;
        }

    }

    /**
     * 成员内部类
     * 无static修饰，属于外部类的对象（jdk16之后开始支持内部类中定义静态成员变量、方法。
     * 在jdk之前是不支持的），相当于是外部类的对象，通过创建对象来调用。
     * 内部类中的实例方法可以直接访问外部类的实例成员、静态成员。创建对象格式：
     *
     * @author wenjie.li
     * @date 2022/08/11 14:08:73
     */
    @ToString
    public class MemberInner {
        private String memberInnerDesc;
        private int memberInnerNum;

        public String getMemberInnerDesc() {
            return memberInnerDesc;
        }

        public void setMemberInnerDesc(String memberInnerDesc) {
            this.memberInnerDesc = memberInnerDesc;
        }

        public int getMemberInnerNum() {
            return memberInnerNum;
        }

        public void setMemberInnerNum(int memberInnerNum) {
            this.memberInnerNum = memberInnerNum;
        }
    }
}
