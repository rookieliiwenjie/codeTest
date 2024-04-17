package LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/10
 */

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * 也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 *  
 * <p>
 *
 * <p>
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println("fib = " + fib3(5));
    }
    public static int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int x = 1, y = 1;
        for (int i = 3; i <= N; i++) {
            int sum = x + y;
            y = x;
            x = sum;

        }
        return x;
    }

    public static int fib(int N) {
        int arr[] = new int[N + 1];
        if (N == 0) {
            return 0;
        }
        if (N <= 1) {
            return N;
        }
        arr[0] = 0;
        arr[1] = 1;
        int num = 2;
        while (N >= num && N >= 2) {
            arr[num] = arr[num - 1] + arr[num - 2];
            num++;
        }
        return arr[N];
    }


    /**
     * 递归算法
     */
    public static int fib2(int N) {
        /**
         *  示例 1：
         *  * 输入：2
         *  * 输出：1
         *  * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
         *  * 示例 2：
         *  * 输入：3
         *  * 输出：2
         *  * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
         */
        if (N == 0) {
            return 0;
        }
        if (N > 0 && N < 3) {
            return 1;
        }

        return fib2(N - 1) + fib2(N - 2);
    }
}
