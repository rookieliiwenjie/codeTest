package com.company.LeetCode;

/**
 * 给你两个整数 a 和 b ，不使用 运算符+
 * 和-，
 * 计算并返回两整数之和。
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author rookie.li
 * @date 2021-09-26 11:43
 */
public class GetSum {

    public static void main(String[] args) {

    }
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
