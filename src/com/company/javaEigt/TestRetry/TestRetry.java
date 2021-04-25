package com.company.javaEigt.TestRetry;

/**
 * @Author rookie.li
 * @create 2020/12/22
 */
public class TestRetry {
    public static void main(String[] args) {
        testRetry();
    }

    public static void testRetry() {
        int i = 2;
        System.out.println(" retry------ ");
        retry:

        for (; ; ) {
            for (int j = 1; j < 4; j++) {
                if (j == i) {
                    break retry;
                }
            }
        }
    }
}
