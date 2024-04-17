package LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/17
 */
public class ReverseBits {
    public static void main(String[] args) {
       /* int i =00000010100101000001111010011100;
        int i1 = reverseBits(i);
        System.out.println("i = " + i1);*/
    }

    public static int reverseBits(int n) {
        //n=1 n&1 = 1 n=0 n&1 = 0
        StringBuilder stringBuilder = new StringBuilder(n);
        return Integer.parseInt(stringBuilder.reverse().toString());

    }
    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     * 输入：11111111111111111111111111111101
     * 输出：10111111111111111111111111111111
     * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111
     */
}
