package com.company.并发编程.day12_2021_02_25_THREAD;

/**
 * @Author rookie.li
 * @create 2021/2/25
 * JAVAC XX.JAVA
 * JAVAP -V CLASS
 */
public class SyDemo {
    public static void main(String[] args) {
// 对Synchronized Class对象进行加锁 synchronized (Synchronized.class) { }
        // 静态同步方法，对Synchronized Class对象进行加锁
        /*synchronized (SyDemo.class){
            m();
        }*/
        String str="我是中国rendd—";//你需du要判断的字符串zhi
        String len="";
        int j=0;
        if(str.length()>10)
            System.out.println("该字符串大于10");
        char[] c=str.toCharArray();
        for(int i=0;i<c.length;i++){
            len=Integer.toBinaryString(c[i]);
            if(len.length()>8)
                j++;
        }
        System.out.println("共有中文字符："+j);
    }

    public static synchronized void m() {
    }
}
