package com.company.LeetCode.day5_2020_12_14_findMinArrowShots;

/**
 * @Author rookie.li
 * @create 2020/12/14
 */
public class MaxProfit {
    /**
     * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public static void main(String[] args) {
        //int[] price = {7, 6, 4, 3, 1};
        //int price[] = {1, 2, 3, 4, 5};
        int[] price = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(price);
        int i1 = maxProfit2(price);
        System.out.println("i = " + i);
        System.out.println("i = " + i1);
    }
    public static int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 0; i < n-1; ++i) {
            ans += Math.max(0, prices[i+1] - prices[i]);
        }
        return ans;
    }

    public static int maxProfit(int[] prices) {
        //记录利润
        int sum = 0;
        /**
         *贪心算法，假设我每一次都买入但是选择最低点买入
         */
        //
        //int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; ++i) {
            int minNum = prices[i];
            int max = 0;
            for (int j = i + 1; j < prices.length; ++j) {
                max = Math.max(max, prices[j] - minNum);
                minNum = Integer.MAX_VALUE;
            }
            sum += max;
            /*if (minNum > prices[i]) {
                minNum = prices[i];
            } else {
                sum += prices[i] - minNum;
                minNum = Integer.MAX_VALUE;

            }*/
        }
        return sum;
    }
}
