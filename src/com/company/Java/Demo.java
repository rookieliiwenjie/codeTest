package com.company.Java;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 5:21 下午
 * @Description: 测试继承方法啊
 */
public interface Demo {
    public int get();

    default int getnum(int num) {
        getNum2();
        return num;
    }

    static int getNum2() {
        return 1;
    }
}
