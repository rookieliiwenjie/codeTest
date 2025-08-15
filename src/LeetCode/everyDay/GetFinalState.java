package LeetCode.everyDay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetFinalState {
//    public static void main(String[] args) {
//        GetFinalState getFinalState = new GetFinalState();
//
////        输出
////                [4,8,6,5,6]
////        预期结果
////                [8,4,6,5,6]
//        int[] nums = {161209470};
//        int k = 56851412;
//        int multiplier = 39846;
//        int[] finalState = getFinalState.getFinalState4(nums, k, multiplier);
//        for (int i : finalState) {
//            System.out.print(i + ",");
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new GetFinalState().new Solution();
       int [] nums ={2,1,3,5,6};
        int k = 9;
       int  multiplier = 2;
        solution.getFinalState(nums, k, multiplier);
    }
    public static int quickPow(int x, int y, int mod) {
        if (y == 0) {
            return 1;
        }
        int res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            y = y >> 1;
            x = (x * x) % mod;
            System.out.println("x = " + x + " y = " + y + " res = " + res);
        }
        return res;
    }

    /**
     * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
     * <p>
     * 你需要对 nums 执行 k 次操作，每次操作中：
     * <p>
     * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
     * 将 x 替换为 x * multiplier 。
     * k 次操作以后，你需要将 nums 中每一个数值对 109 + 7 取余。
     * <p>
     * 请你返回执行完 k 次乘运算以及取余运算之后，最终的 nums 数组。
     * <p>
     * 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
     * <p>
     * 输出：[8,4,6,5,6]
     *
     * @param nums
     * @param k
     * @param multiplier
     * @return
     */
    public int[] getFinalState4(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Long.compare(o1[0], o2[0]);
            } else {
                return Long.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            long[] poll = pq.poll();
            poll[0] = (poll[0] * multiplier) % 1000000007;
            pq.offer(poll);
        }
        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            res[(int) poll[1]] = (int) (poll[0] % 1000000007);
        }
        return res;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.offer(poll);
        }
        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res[poll[1]] = poll[0];
        }
        return res;
    }


    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            int min = nums[0];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    maxIndex = j;
                }
            }
            nums[maxIndex] *= multiplier;
        }
        return nums;

    }

    public int[] getFinalState3(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            nums[maxIndex] *= multiplier;
        }
        return nums;

    }


    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            if (multiplier == 1) {
                return nums;
            }
            int n = nums.length, mx = 0;
            long m = 1000000007L;
            PriorityQueue<long[]> v = new PriorityQueue<>((x, y) -> {
                if (x[0] != y[0]) {
                    return Long.compare(x[0], y[0]);
                } else {
                    return Long.compare(x[1], y[1]);
                }
            });
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, nums[i]);
                v.offer(new long[]{nums[i], i});
            }
            //这里可以理解啦，最大的值变成最小值
            for (; v.peek()[0] < mx && k > 0; k--) {
                long[] x = v.poll();
                x[0] *= multiplier;
                v.offer(x);
            }
            for (int i = 0; i < n; i++) {
                long[] x = v.poll();
                int t = k / n + (i < k % n ? 1 : 0);
                nums[(int) x[1]] = (int) ((x[0] % m) * quickMul(multiplier, t, m) % m);
            }
            return nums;
        }

        // 快速幂
        private long quickMul(long multiplier, long y, long m) {
            long res = 1;
            while (y > 0) {
                /**
                 * `if ((y & 1) == 1)`
                 * 这行代码的意思是检查变量 `y` 的最低位是否为 1。
                 * 具体来说，它使用按位与运算符 `&` 来检查 `y`
                 * 的二进制表示的最低位。如果最低位是 1，则条件为真；否则为假。
                 * 这是在实现快速幂算法时常用的技巧，用来判断当前的 `
                 * y` 是否是奇数。如果 `y` 是奇数，则 `y & 1` 的结果为 1；
                 * 如果 `y` 是偶数，则 `y & 1` 的结果为 0。
                 */
                if ((y & 1) == 1) {
                    res = (res * multiplier) % m;
                }
                //除以2
                y >>= 1;
                multiplier = (multiplier * multiplier) % m;
            }
            return res;
        }


    }
}
