package LeetCode.everyDay;

public class CountOfPairs {
    /**
     * 给你一个长度为 n 的 正 整数数组 nums 。
     * 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：
     * 两个数组的长度都是 n 。
     * arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
     * arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
     * 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
     * 请你返回所有 单调 数组对的数目。
     * 由于答案可能很大，请你将它对 109 + 7 取余 后返回。
     * 1 <= n == nums.length <= 2000
     * 1 <= nums[i] <= 50

     * @param nums
     * @return
     */
    int MOD = 1000000007;
    public int countOfPairs(int nums[]) {
        int n = nums.length;
        int[][] dp = new int[n][51];
        for (int v = 0; v <= nums[0]; v++) {
            dp[0][v] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int v2 = 0; v2 <= nums[i]; v2++) {
                for (int v1 = 0; v1 <= v2; v1++) {
                    if (nums[i - 1] - v1 >= nums[i] - v2) {
                        dp[i][v2] = (dp[i][v2] + dp[i - 1][v1]) % MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int v : dp[n - 1]) {
            res = (res + v) % MOD;
        }
        return res;
    }
    /**
     * 给你一个长度为 n 的 正 整数数组 nums 。
     * 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：
     * 两个数组的长度都是 n 。
     * arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
     * arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
     * 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
     * num[i] - x = arr1[i]
     * 请你返回所有 单调 数组对的数目。
     * 由于答案可能很大，请你将它对 109 + 7 取余 后返回。
     *  * 1 <= n == nums.length <= 2000
     *      * 1 <= nums[i] <= 1000
     * @param nums
     * @return
     */
    public int countOfPairs2(int nums[]) {
        int n = nums.length, m = 0, mod = 1000000007;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] dp = new int[n][m + 1];
        for (int a = 0; a <= nums[0]; a++) {
            dp[0][a] = 1;
        }
        for (int i = 1; i < n; i++) {
            int d = Math.max(0, nums[i] - nums[i - 1]);
            for (int j = d; j <= nums[i]; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j - d];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - d]) % mod;
                }
            }
        }
        int res = 0;
        for (int num : dp[n - 1]) {
            res = (res + num) % MOD;
        }
        return res;


    }

    public int countMonotonicPairs(int[] nums) {
        int n = nums.length;

        // dp[j] 表示 arr1[i] = j 的合法配对数目
        long[] dp = new long[1001];
        dp[0] = 1;  // 初始条件，第一个元素选择 arr1[0] = 0

        // 遍历 nums 数组，处理每个位置
        for (int i = 0; i < n; i++) {
            // 创建一个新的 dp 数组来存储下一个位置的合法配对数目
            long[] next = new long[1001];
            long prefixSum = 0;  // 前缀和，用来加速计算

            // 遍历 arr1[i] 的所有可能的取值
            for (int j = 0; j <= nums[i]; j++) {
                // 使用前缀和来更新 next 数组，保证 arr1 是单调递增的
                prefixSum = (prefixSum + dp[j]) % MOD;
                next[j] = prefixSum;
            }

            // 更新 dp 数组
            dp = next;
        }

        // 计算最终结果，即所有合法配对的数目
        long result = 0;
        for (long count : dp) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        CountOfPairs obj = new CountOfPairs();
        int[] nums = {2, 3, 2};
        System.out.println(obj.countMonotonicPairs(nums));  // 输出 4
    }
}
