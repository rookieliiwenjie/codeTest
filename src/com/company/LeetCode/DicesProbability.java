package com.company.LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class DicesProbability {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556
     *
     */
    public static void main(String[] args) {

    }
    public double[] dicesProbability(int n) {
        double num[] = new double[(int) Math.pow(6,n)];
        return num;
    }
}
