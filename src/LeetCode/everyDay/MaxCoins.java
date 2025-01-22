package LeetCode.everyDay;

import java.util.Arrays;
import java.util.Comparator;

public class MaxCoins {


    /**
     * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
     * <p>
     * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
     * Alice 将会取走硬币数量最多的那一堆。
     * 你将会取走硬币数量第二多的那一堆。
     * Bob 将会取走最后一堆。
     * 重复这个过程，直到没有更多硬币。
     * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
     * <p>
     * 返回你可以获得的最大硬币数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：piles = [2,4,1,2,7,8] 1 2 2 4  7 8
     * 1 7 8
     * 224
     * <p>
     * 输出：9
     * 解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
     * 选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
     * 你可以获得的最大硬币数目：7 + 2 = 9.
     * 考虑另外一种情况，如果选出的是 (1, 2, 8) 和 (2, 4, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
     *
     * @param piles
     * @return
     */
    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        int piles[] = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        maxCoins.maxCoins(piles);
    }

    public int maxCoins(int[] piles) {
//        int numPile[][] = new int[piles.length][2];
//        for (int i = 0; i < piles.length; i++) {
//            numPile[i][0] = piles[i];
//            numPile[i][]
//        }
//        Arrays.stream(numPile).sorted(Comparator.comparingInt(num -> num[0]));
        int res = 0;
        Arrays.sort(piles);
        int length = piles.length;
        int forNum = length / 3;
        while (forNum > 0) {
            res += piles[length - 2];
            length = length - 2;
            forNum--;
        }
        return res;

    }

    /**
     * 贪心逻辑
     *
     * @param piles
     * @return
     */
    public int maxCoins2(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int rounds = length / 3;
        int coins = 0;
        int index = length - 2;
        for (int i = 0; i < rounds; i++) {
            coins += piles[index];
            index -= 2;
        }
        return coins;


    }
}
