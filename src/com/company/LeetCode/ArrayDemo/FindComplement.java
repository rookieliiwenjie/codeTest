package com.company.LeetCode.ArrayDemo;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * <p>
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 * <p>
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num < 231
 * 链接：https://leetcode-cn.com/problems/number-complement
 *
 * @author rookie.li
 * @date 2021-10-18 15:37
 */
public class FindComplement {
    public int findComplement(int num) {
        int buNum = 0;
        while ((num / 2) % 2 == 0) {
            num = num / 2;
        }
        return buNum;
    }
}
