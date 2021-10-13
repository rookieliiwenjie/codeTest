package com.company.rocketMqDemo;

import java.util.Random;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-11 21:58
 */
public class ThreadLocalIndex {
    private static Random random = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("random = " + random.nextInt());
        }
    }
}
