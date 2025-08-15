package LeetCode.everyDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSpending {
    public static void main(String[] args) {
        int[][] values = {{8, 5, 2}, {6, 4, 1}, {9, 7, 3}};
        MaxSpending maxSpending = new MaxSpending();
        long l = maxSpending.maxSpending(values);
        System.out.println(l);
    }

    public long maxSpending(int[][] values) {
        long maxSpending = 0;
        int[] arr = new int[values.length * values[0].length];
        int index = 0;
        for (int i = 0; values.length > i; i++) {
            for (int j = 0; values[0].length > j; j++) {
                arr[index] = values[i][j];
                index++;
            }
        }
        Arrays.sort(arr);
        for (int i = 0; arr.length > i; i++) {
            maxSpending += (long) arr[i] * (i + 1);
        }
        return maxSpending;
    }

    /**
     * 方法一：排序不等式 + 小根堆
     * 思路与算法
     *
     * 由于每一个商店的物品都已经按照价值单调递减排好序了，
     * 那么当我们选择某个商店购买物品时，都可以买到该商店中价值最低的物品。
     * 由于我们可以任意选择商店，这就说，我们总是可以买到当前所有物品中价值最低的那个。
     *
     * 在开销的计算公式中，物品的价值会乘上购买它的天数。
     * 根据排序不等式，在理想状态下我们应该将所有商品按照价值从低到高排序，
     * 分别在第 1 到 m×n 天去购买。根据上一段的结论，我们一定是可以达到这个理想状态的。
     *
     * 因此，我们可以将 m×n 个商品按照价值进行排序，就可以得到答案，
     * 但这样做的时间复杂度是 O(mnlog(mn))，
     * 没有进一步用到「每一个商店的物品都已经按照价值单调递减排好序」这个性质。
     * 我们可以使用「23. 合并 K 个升序链表」中的方法，使用一个小根堆
     * ，存储每个商店当前价值最小的物品，那么小根堆的堆顶就是全局价值最小的物品。
     * 随后，我们将该物品在对应的商店中的下一个物品放入小根堆中，
     * 重复一共 m×n 次操作即可，时间复杂度降低至 O(mnlogm)。
     *
     */
    //因为是已经排序过的啦，所以可以直接维护 最后一列的值

    /**
     * maxSpending 的时间复杂度是 (O(m \cdot n \log(m \cdot n)))，
     * 因为它对数组中的所有元素进行排序。  maxSpending2 的时间复杂度是 (O(m \cdot n \log m))，
     * 因为它使用优先队列（小根堆）来合并已排序的列表，这种方法更高效。
     * @param values
     * @return
     */
    public long maxSpending2(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{values[i][n - 1], i, n - 1});
        }

        long ans = 0;
        for (int turn = 1; turn <= m * n; turn++) {
            int[] top = pq.poll();
            int val = top[0], i = top[1], j = top[2];
            ans += (long) val * turn;
            if (j > 0) {
                pq.offer(new int[]{values[i][j - 1], i, j - 1});
            }
        }
        return ans;
    }

}
