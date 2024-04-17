package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/8 4:24 下午
 * @Description:
 */
public class CoinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = { 186,419,83,408};
        int amount = 6249;
        System.out.println("amount = " + coinChange(coins, amount));
    }

    /**
     * 大概率是贪心
     * 首先第一不知道加多少，加多了太复杂
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        int num = 0;
        while (amount > 0 && index>=0) {
            num += amount / coins[index];
            amount = amount % coins[index];
            if (amount == 0) {
                return num;
            } else if (amount < coins[index]) {
                index--;
            }
        }
        return amount != 0 ? -1 : num;
    }
}
