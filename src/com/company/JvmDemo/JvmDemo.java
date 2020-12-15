package com.company.JvmDemo;

/**
 * Created by lwj32 on 2020/6/2.
 */
public class JvmDemo {
    //方法区静态属性引用的对象
    private static JvmDemo jvmDemo = new JvmDemo();
    private static final JvmDemo getJvmDemo = new JvmDemo();

    public static void m1() {
        JvmDemo jvmDemo = new JvmDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
