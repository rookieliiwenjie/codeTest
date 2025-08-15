package com.company.javaBase;

public class StringDemo {
    public static void main(String[] args) {
        Exception exception = new RuntimeException();
//        String s1="JAVA";
//        String s2 = "JAVA";
//        System.out.println(s1 == s2);
//        String s3 = s1.intern();
//        System.out.println(s1 == s3);
//        String s4 = new String("JAVA");
//        String s5 = s4.intern();
//        System.out.println(s1 == s4);//false
//        System.out.println(s1 == s5);//true
//        System.out.println(s4 == s5);//false
        //对于编译期可以确定值的字符串，也就是常量字符串 ，jvm 会将其存入字符串常量池
        // 。并且，字符串常量拼接得到的字符串常量在编译阶段就已经被存放字符串常量池，这个得益于编译器的优化。

        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        //引用的值在程序编译期是无法确定的，编译器无法对其进行优化。
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
        //final修饰的变量在编译期就可以确定值，所以在编译期就会被优化
        final String str7 = "str";
        final String str8 = "ing";
// 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 常量池中的对象
        System.out.println(c == d);// true
    }
}
