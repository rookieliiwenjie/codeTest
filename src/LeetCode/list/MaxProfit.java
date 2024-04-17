package LeetCode.list;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                max = Math.max(prices[i] - minPrice, max);
            } else {
                minPrice = prices[i];
            }
        }
        return max;
    }


}
