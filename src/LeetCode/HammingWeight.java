package LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/2
 */
public class HammingWeight {
    public static void main(String[] args) {
        // System.out.println("args = " + hammingWeight(11111111111111111111111111111101));
    }

    /*请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如
    ，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

   */
    public static int hammingWeight(int n) {

        int sum = 0;
        while (n > 0) {
            int zore = n % 2;
            n = n / 2;
            if (zore == 1) {
                sum++;
            }
        }

        return sum;
    }

    public static int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            //因为n&1 但n末尾为1是才为1 1&1 = 1 0&1=0 0&0=0  1&0=0
            sum += n & 1;
            n>>>=1;
        }
        return sum;


       /* int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;*/
    }


}
