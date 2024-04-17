package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/15 8:50 下午
 * @Description:
 */
public class MaxProFit {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
        }
        return max;
    }
}
