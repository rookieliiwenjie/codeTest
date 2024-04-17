package java.lang;

import com.company.SingleonDemo.A;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/9 6:04 下午
 * @Description:
 */
public class MyObject {
    public static void main(String[] args) {
        A myObject = new A();
        ClassLoader classLoader = myObject.getClass().getClassLoader();
        System.out.println("classLoader。 = " + classLoader);
    }
}
