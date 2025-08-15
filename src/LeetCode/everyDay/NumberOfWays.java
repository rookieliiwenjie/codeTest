package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWays {
    /**
     * 给你两个 正 整数 n 和 x 。
     * <p>
     * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。
     * 换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1x + n2x + ... + nkx 。
     * <p>
     * 由于答案可能非常大，请你将它对 109 + 7 取余后返回。
     * <p>
     * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 23 + 33 + 53 。
     *
     * @param n
     * @param x 示例 1：
     *          <p>
     *          输入：n = 10, x = 2
     *          输出：1
     *          解释：我们可以将 n 表示为：n = 32 + 12 = 10 。
     *          这是唯一将 10 表达成不同整数 2 次方之和的方案。
     *          示例 2：
     *          <p>
     *          输入：n = 4, x = 1
     *          输出：2
     *          解释：我们可以将 n 按以下方案表示：
     *          - n = 41 = 4 。
     *          - n = 31 + 11 = 4 。
     * @return
     */

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        System.out.println(numberOfWays(n, x));

    }

    // 我理解就是相当于吧n 拆分为 a ^ x + b ^x
    public static int numberOfWays(int n, int x) {
        // 获取可以 的数据源
        List<Integer> canNumber = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            if (Math.pow(i, x) > n) {
                break;
            }
            canNumber.add(i);
            i++;
        }
        // 组合排列
        return backtrack(canNumber, (double) n, 0, x);
    }

    public static int backtrack(List<Integer> canNumber, double target, int start, int x) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int count = 0;
        for (int i = start; i < canNumber.size(); i++) {
            count += backtrack(canNumber, target - Math.pow(canNumber.get(i), x), i + 1, x);
            count = count % 1000000007;
        }
        return count;
    }

    public static int numberOfWays2(int n, int x) {
        // 获取可以 的数据源
        List<Integer> canNumber = new ArrayList<>();
        int z = 1;
        while (z <= n) {
            if (Math.pow(z, x) > n) {
                break;
            }
            canNumber.add(z);
            z++;
        }
        // 动态规划
        int m = canNumber.size();
        long dp[][] = new long[m + 1][n + 1];
        //
        for (int i = 1; i < m; i++) {
            //
            long val = (long) Math.pow(canNumber.get(i), x);
            for (int j = 0; j <= n; j++) {
                // 不选当前数字
                dp[i][j] = dp[i - 1][j];
                // 选当前数字（前提j>=val）
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) val]) % 1_000_000_007;
                }
            }
        }
        return (int) dp[m][n];
    }

    final int MOD = 1_000_000_007;

    /**
     *
     * @param n
     * @param x
     * @return
     */
    public int numberOfWay4(int n, int x) {
        // dp[i][j]前i个数j的和 的总个方案
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long val = (long) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) val]) % MOD;
                }
            }
        }
        return (int) dp[n][n];
    }

    public int numberOfWay5(int n, int x) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            // i的
            long val = (long) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) val]) % MOD;
                }
            }

        }
        return dp[n][n];
    }

    public int numberOfWay6(int n,int x){
           // 找到最大的整数 i，使 i^x <= n
           int maxNum = 1;
           while (Math.pow(maxNum, x) <= n) {
               maxNum++;
           }
           maxNum--;
   
           int[] dp = new int[n + 1];
           dp[0] = 1; // base case: 凑出0的方案数是1
           for (int i = 1; i <= maxNum; i++) {
               int pow = (int) Math.pow(i, x);
               // 倒序更新，保证每个整数只用一次 
               //正序反例 当 j =4 也就是pow =4 n =8 就有问题
               // 1.dp[4] = dp[4]+dp[0]  这里dp[4] 已经更新过了， 
               //2.当 dp[8] =dp[8]+dp[4] 这里再次使用了 dp【4】而且dp【4】 是已经被本轮i更新过一次了，
               for (int j = n; j >= pow; j--) {
                   dp[j] = (dp[j] + dp[j - pow]) % MOD;
               }
           }
           return dp[n];
    }

}
