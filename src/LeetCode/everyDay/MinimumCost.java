package LeetCode.everyDay;

import java.util.Arrays;

public class MinimumCost {
    /**
     * 有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
     * <p>
     * 给你整数 m ，n 和两个数组：
     * <p>
     * horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
     * verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
     * 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
     * <p>
     * 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
     * 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
     * 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
     * <p>
     * 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
     * <p>
     * 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
     * 沿着垂直线 0 切开蛋糕，开销为 5 。
     * 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
     * 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
     * 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
     * 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
     * 总开销为 5 + 1 + 1 + 3 + 3 = 13 。
     * 输出：13
     * 2、
     * 输入：m = 2, n = 2, horizontalCut = [7], verticalCut = [4]
     * <p>
     * 输出：15
     * <p>
     * 解释：
     * <p>
     * 沿着水平线 0 切开蛋糕，开销为 7 。
     * 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
     * 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
     * 总开销为 7 + 4 + 4 = 15 。
     *
     * @param m
     * @param n
     * @param horizontalCut 水平
     * @param verticalCut   垂直
     * @return
     */
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int res = 0;
        // 排序切割开销数组
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
// 使用两个指针分别遍历水平和垂直切割数组
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;

        // 初始化水平和垂直块数
        int hCount = 1; // 初始只有一个水平块
        int vCount = 1; // 初始只有一个垂直块
        while (h >= 0 || v >= 0) {
            if (v < 0 || (h >= 0 && horizontalCut[h] >= verticalCut[v])) {
                // 选择水平切割
                res += (long) horizontalCut[h] * vCount;
                hCount++; // 新增水平块
                h--; // 移动水平指针
            } else {
                // 选择垂直切割
                res += (long) verticalCut[v] * hCount;
                vCount++; // 新增垂直块
                v--; // 移动垂直指针
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();
        int m = 3, n = 2;
        int[] horizontalCut = {1, 3};
        int[] verticalCut = {5};
        System.out.println(minimumCost.minimumCostPlus(m, n, horizontalCut, verticalCut));
        System.out.println(minimumCost.minimumCost2(m, n, horizontalCut, verticalCut));
    }
    /**
     * 困难版本
     *
     * @param m
     * @param n
     * @param horizontalCut
     * @param verticalCut
     * @return
     */
    public long minimumCostPlus(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long res = 0;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;
        int hcount = 1;
        int vcount = 1;
        while (h >= 0 || v >= 0) {
            //水平分割
            if (v < 0 || (h >= 0 && horizontalCut[h] >= verticalCut[v])) {
                res += (long) horizontalCut[h] * vcount;
                hcount++;
                h--;
            } else {
                res += (long) verticalCut[v] * hcount;
                vcount++;
                v--;
            }
        }
        return res;
    }


    /* @param m
     * @param n
     * @param horizontalCut 水平
     * @param verticalCut   垂直*/
    public int minimumCost2(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int res = 0;
        // 排序切割开销数组
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        //记录指针
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;
        int hcount = 1;
        int vcount = 1;
        while (h >= 0 || v >= 0) {
            //水平分割
            if (v < 0 || (h >= 0 && horizontalCut[h] >= verticalCut[v])) {
                res += horizontalCut[h] * vcount;
                vcount++;
                h--;
            } else {
                res += verticalCut[v] * hcount;
                hcount++;
                v--;
            }
        }
        return res;
    }
}
