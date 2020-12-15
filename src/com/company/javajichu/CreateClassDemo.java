package com.company.javajichu;

/**
 * @Author rookie.li
 * @create 2020/12/7
 */
public class CreateClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CreateClassDemo createClassDemo1 = new CreateClassDemo();
        CreateClassDemo createClassDemo2 = (CreateClassDemo) Class.forName("com.company.javajichu.CreateClassDemo").newInstance();

    }
}
