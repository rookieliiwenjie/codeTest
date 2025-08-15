package LeetCode.QuestionAnwers;


public class MaxProfit {
    /**
     * 买卖股票的的最好时间1
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，
     * 最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，
     * 你不能在买入前卖出股票。
     */


    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buynUm = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - buynUm, maxProfit);
            if (prices[i] < buynUm) {
                buynUm = prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票
     * 。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润 。
     *
     * @param prices
     * @return 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
     * 最大总利润为 4 + 3 = 7 。
     */
    public static void main(String[] args) {
        int pri[] = {7, 1, 5, 3, 6, 4};
//        int pri[] = {1, 2, 3, 4, 5, 6};
//        int pri[] = {3, 3};
//        System.out.println(maxProfit2(pri));
//        System.out.println(maxProfit3(pri));
//        System.out.println(maxProfit5(pri));
        System.out.println(maxProfit4(pri));


    }

    public static int maxProfit2(int[] prices) {
        int max = 0;
        if (prices.length <= 1) {
            return max;
        }
        int nowPrice = prices[0];
        int i = 0;
        while (i < prices.length) {
            int j = i + 1;
            while (j < prices.length) {
                if (prices[j] > nowPrice) {
                    max += prices[j] - nowPrice;
                    nowPrice = prices[Math.min(j, prices.length - 1)];
                    i = j + 1;
                    continue;
                } else if (prices[j] < nowPrice) {
                    //prices[j] <= nowPrice
                    nowPrice = prices[j];
                    i = j + 1;
                    continue;

                }
                j++;
            }
            i = j + 1;
        }
        return max;
    }

    /**
     * 贪心算法 默认今天比昨天贵就买
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    /**
     * 动态规划 空间复杂度 n 的版本
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        int[][] maimaiNum = new int[prices.length][2];
        //不持有
        maimaiNum[0][0] = 0;
        //持有
        maimaiNum[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //i天不持有
            maimaiNum[i][0] = Math.max(maimaiNum[i - 1][0], maimaiNum[i - 1][1] + prices[i]);
            //i天持有
            maimaiNum[i][1] = Math.max(maimaiNum[i - 1][1], maimaiNum[i - 1][0] - prices[i]);
        }
        return maimaiNum[prices.length - 1][0];
    }

    /**
     * 动态规划 空间复杂度 o1 的版本
     *
     * @param prices
     * @return
     */
    public static int maxProfit5(int[] prices) {
        //不持有
        int noPriceNum = 0;
        //持有
        int getPriceNum = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //i不持有的情况 1、前一天不持有 今天也不持有没有操作，2、前一天持有的收益+今天卖出
            int inoPriceNum = Math.max(noPriceNum, getPriceNum + prices[i]);
            //i天持有，1、就是i天不买卖，2、和前一天不持有，今天 买入
            int igetPriceNum = Math.max(getPriceNum, noPriceNum - prices[i]);
            noPriceNum = inoPriceNum;
            getPriceNum = igetPriceNum;
        }
        return noPriceNum;
    }
}
