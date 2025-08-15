package LeetCode.everyDay;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductQueries {
    /**
     * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，
     * 且它们的和为 n 。powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
     * <p>
     * 同时给你一个下标从 0 开始的二维整数数组 queries ，
     * 其中
     * 1、queries[i] = [lefti, righti] ，其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
     * <p>
     * 请你返回一个数组 answers ，长度与 queries 的长度相同，
     * 其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个 answers[i] 都对 109 + 7 取余 。
     *
     * @param n
     * @param queries
     * @return 示例 1：
     * <p>
     * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
     * 输出：[2,4,64]
     * 解释：
     * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
     * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
     * 第 2 个查询的答案：powers[2] = 4 。
     * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
     * 每个答案对 109 + 7 取余得到的结果都相同，所以返回 [2,4,64] 。
     * <p>
     * 输入：n = 2, queries = [[0,0]]
     * 输出：[2]
     * 解释：
     * 对于 n = 2, powers = [2] 。
     * 唯一一个查询的答案是 powers[0] = 2 。答案对 109 + 7 取余后结果相同，所以返回 [2] 。
     * <p>
     * 1 <= n <= 109
     * 1 <= queries.length <= 105
     * 0 <= starti <= endi < powers.length
     */


    public int[] productQueries(int n, int[][] queries) {
        int result[] = new int[queries.length];
        List<Integer> getPower = getPower(n);
        for (int i = 0; i < queries.length; i++) {
            List<Integer> list = getPower.subList(queries[i][0], queries[i][1] + 1);
            long num = 1;
            for (int listnum : list) {
                num = (num * listnum) % (1000000007);
            }
            result[i] = (int) num;
        }
        return result;
    }

    public List<Integer> getPower(int n) {
        int beginPower = 1; //2^0 = 1;
        int num = n;
        List<Integer> powerList = new ArrayList<>();
        while (num > 0) {
            if ((num & 1) == 1) {
                powerList.add(beginPower);
            }
            num >>= 1;// n 右移一位，处理下一位
            beginPower <<= 1;// power * 2，移动到下一位的2的幂
        }
        return powerList;
    }


    private static final int MOD = 1000000007;

    /**
     * 预处理
     *
     * @param n
     * @param queries
     * @return
     */
    public int[] productQueries2(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        int m = bins.size();
        int[][] results = new int[m][m];
        for (int i = 0; i < m; i++) {
            long cur = 1;
            for (int j = i; j < m; j++) {
                cur = (cur * bins.get(j)) % MOD;
                results[i][j] = (int) cur;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = results[queries[i][0]][queries[i][1]];
        }
        return ans;
    }

    /**
     * 前缀乘积
     *
     * @param n
     * @param queries
     * @return
     */

    public int[] productQueries3(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }
        long prefixProd[] = new long[bins.size() + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < bins.size(); i++) {
            prefixProd[i + 1] = (prefixProd[i] * bins.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long numerator = prefixProd[right + 1];
            long denominator = prefixProd[left];
            long inverse = modInverse(denominator, MOD);
            ans[i] = (int) ((numerator * inverse) % MOD);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int[][] queries = {{0, 1}, {2, 2}, {0, 3}};
        ProductQueries productQueries = new ProductQueries();
//        int[] ints = productQueries.productQueries(n, queries);
        int[] ints = productQueries.productQueries4(n, queries);
        for (int i : ints) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    public int[] productQueries4(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }
        // x 为 x y = y 累加
        long prefixProd[][] = new long[bins.size()][bins.size()];
        for (int i = 0; i < bins.size(); i++) {
            long cur = 1;
            for (int j = i; j < bins.size(); j++) {
                cur = (cur * bins.get(j)) % MOD;
                prefixProd[i][j] = cur;
            }

        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = (int) prefixProd[left][right];
        }
        return ans;
    }

    // 快速幂计算模逆元（费马小定理，MOD为质数）
    private long modInverse(long x, int mod) {
        return modPow(x, mod - 2, mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        long cur = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * cur) % mod;
            }
            cur = (cur * cur) % mod;
            exp >>= 1;
        }
        return result;
    }


}