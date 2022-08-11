package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Outter;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/11 11:07 上午
 * @Description:
 */
public class OutterInnerDemo {
    public static void main(String[] args) {
        Outter.Inner inner = new Outter.Inner();
        inner.setInnerDesc("inner");
        inner.setInnerNum(1);
        inner.show();
        Outter.MemberInner memberInner = new Outter().new MemberInner();
        memberInner.setMemberInnerNum(1);
        memberInner.setMemberInnerDesc("11");
        System.out.println("memberInner = " + memberInner);
    }
}
