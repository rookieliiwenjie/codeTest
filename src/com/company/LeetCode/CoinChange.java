package com.company.LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author rookie.li
 * @create 2020/11/11
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {86, 419, 83, 408};
        //int x = 6259 / 408;

        // System.out.println("x = " + x);
        /***
         *  *输入：coins = [1, 2, 5], amount = 11
         *      * 输出：3
         *      * 解释：11 = 5 + 5 + 1
         *      * 输入：coins = [2], amount = 3
         *      * 输出：-1
         *      * 输入：coins = [1], amount = 0
         *      * 输出：0
         *      * 输入：coins = [1], amount = 1
         *      * 输出：1
         *      * 输入：coins = [1], amount = 2
         *      * 输出：2
         */
       /* int i = coinChangedp(coins, 6249);
        System.out.println("i = " + i);
        int z = coinChangedpflow(coins, 6249);
        System.out.println("i = " + z);*/
       /* int i = myDigui(coins, 6249);
        System.out.println("i = " + i);*/
        int i1 = mydpHight(coins, 6249);
        System.out.println("i1 = " + i1);
    }

    public static int mydpCount(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return mydbChange(coins, amount, new int[amount]);
    }

    public static int mydbChange(int[] coins, int amount, int[] ints) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (ints[amount - 1] != 0) {
            return ints[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = mydbChange(coins, amount - coin, ints);
            if (res != -1 && res < min) {
                min = res + 1;
            }
        }
        ints[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return ints[amount - 1];


    }

    public static int mydpHight(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int myDigui(int[] coins, int amount) {
        return mydiguishixian(0, coins, amount);
    }

    public static int mydiguishixian(int idex, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idex < coins.length && amount > 0) {
            int maxVal = amount / coins[idex];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                int res = mydiguishixian(idex + 1, coins, amount - (i * coins[idex]));
                if (res != -1) {
                    min = Math.min(min, res + i);
                }
            }
            return (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return -1;


    }

    ;

    /**
     * 动态规划：自下而上
     */
    public static int coinChangedpflow(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static int coinChangedp(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChangedp(coins, amount, new int[amount]);
    }

    private static int coinChangedp(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangedp(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static int coinChange5(int[] coins, int amount) {
        return coinChange5(0, coins, amount);
    }

    /**
     * @param idxCoin 第几个硬币
     * @param coins   硬币组合
     * @param amount  还剩多少钱
     * @return
     */
    private static int coinChange5(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        //如果数组完了还钱还不为空则返回-1
        if (idxCoin < coins.length && amount > 0) {
            //每一种硬币最多的硬币数
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange5(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;


    }


    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额
     * ，返回-1。
     * 你可以认为每种硬币的数量是无限的。
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChange2(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange2(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;

        }
        return -1;
    }

    public static int coinChange(int[] coins, int amount) {
        IntStream sorted = Arrays.stream(coins).sorted();
        int[] ints = sorted.toArray();
        if (amount <= 0) {
            return amount;
        }
        if (amount < ints[0]) {
            return -1;
        }
        int sum = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            if (amount == 0) {
                break;
            }
            int count = amount / ints[i];
            if (count > 0) {
                sum += count;
                amount = amount % ints[i];
            }
        }
        if (amount != 0) {

            return -1;
        }
        return sum;
    }
}
