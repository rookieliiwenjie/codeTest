package LeetCode.everyDay;

import java.util.Arrays;

/**
 * 示例 1
 * <p>
 * 输入： fruits = [4,2,5], baskets = [3,5,4]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * fruits[0] = 4 放入 baskets[1] = 5。
 * fruits[1] = 2 放入 baskets[0] = 3。
 * fruits[2] = 5 无法放入 baskets[2] = 4。
 * 由于有一种水果未放置，我们返回 1。
 * <p>
 * 示例 2
 * <p>
 * 输入： fruits = [3,6,1], baskets = [6,4,7]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * fruits[0] = 3 放入 baskets[0] = 6。
 * fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
 * fruits[2] = 1 放入 baskets[1] = 4。
 * 由于所有水果都已成功放置，我们返回 0。
 */
public class NumOfUnplacedFruits {
    /**
     * * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量
     * ，baskets[j] 表示第 j 个篮子的 容量。
     * *
     * * 你需要对 fruits 数组从左到右按照以下规则放置水果：
     * *
     * * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
     * * 每个篮子只能装 一种 水果。
     * * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
     * * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
     *
     * @param fruits
     * @param baskets
     * @return
     */
    public static void main(String[] args) {
        int[] fruits = {6, 5};
        int[] baskets = {3, 5};
        numOfUnplacedFruits(fruits, baskets);
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            int flag = 1;
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = -1;
                    flag = 0;
                    break;
                }
            }

            res +=flag;
        }
        return res;
    }


    private int[] segTree = new int[400007];
    private int[] baskets;

    private void build(int p, int l, int r) {
        if (l == r) {
            segTree[p] = baskets[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(p << 1, l, mid);
        build(p << 1 | 1, mid + 1, r);
        segTree[p] = Math.max(segTree[p << 1], segTree[p << 1 | 1]);
    }

    private int query(int p, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return Integer.MIN_VALUE;
        }
        if (ql <= l && r <= qr) {
            return segTree[p];
        }
        int mid = (l + r) >> 1;
        return Math.max(query(p << 1, l, mid, ql, qr),
                query(p << 1 | 1, mid + 1, r, ql, qr));
    }

    private void update(int p, int l, int r, int pos, int val) {
        if (l == r) {
            segTree[p] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            update(p << 1, l, mid, pos, val);
        } else {
            update(p << 1 | 1, mid + 1, r, pos, val);
        }
        segTree[p] = Math.max(segTree[p << 1], segTree[p << 1 | 1]);
    }
    /**
     * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，
     * baskets[j] 表示第 j 个篮子的 容量。
     *
     * 你需要对 fruits 数组从左到右按照以下规则放置水果：
     * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
     * 每个篮子只能装 一种 水果。
     * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
     * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
     * @param fruits
     * @param baskets
     * @return
     * 这个数据量很大，所以普通方法是不可以的，只能使用
     */
    public int numOfUnplacedFruits4(int[] fruits, int[] baskets) {
        this.baskets = baskets;
        int m = baskets.length;
        int count = 0;
        if (m == 0) {
            return fruits.length;
        }
        Arrays.fill(segTree, Integer.MIN_VALUE);
        build(1, 0, m - 1);
        for (int i = 0; i < fruits.length; i++) {
            int l = 0, r = m - 1, res = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (query(1, 0, m - 1, 0, mid) >= fruits[i]) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (res != -1 && baskets[res] >= fruits[i]) {
                update(1, 0, m - 1, res, Integer.MIN_VALUE);
            } else {
                count++;
            }
        }
        return count;
    }

}
