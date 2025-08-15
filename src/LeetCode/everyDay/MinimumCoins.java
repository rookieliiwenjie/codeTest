package LeetCode.everyDay;

public class MinimumCoins {
    /**
     * 给你一个 下标从 1 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
     * 水果超市有如下促销活动：
     * 如果你花费 prices[i] 购买了下标为 i 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。
     * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以获得它的奖励。
     * 请你返回获得所有水果所需要的 最少 金币数。
     * 示例 1：
     * 输入：prices = [3,1,2]
     * 输出：4
     * 解释：
     * 用 prices[0] = 3 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
     * 用 prices[1] = 1 个金币购买第 2 个水果，你可以免费获得第 3 个水果。
     * 免费获得第 3 个水果。
     * 请注意，即使您可以免费获得第 2 个水果作为购买第 1 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。
     *
     * @param prices
     * @return 解题思路，
     * 贪心算法
     */
    public int minimumCoins(int[] prices) {
        int minPrice = 0;
        minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int index = i + 1;
            int index2 = 2 * i + 2;
//            if (i + 1)
        }
        return minPrice;

    }
}
