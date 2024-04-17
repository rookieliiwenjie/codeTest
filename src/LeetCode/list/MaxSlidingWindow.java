package LeetCode.list;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums,k);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }
        int newNums[] = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + k -1) < nums.length) {
                int max = Integer.MIN_VALUE;
                for (int j = i; j <= i + k-1 && j < nums.length; j++) {
                    max = Math.max(nums[j], max);
                }
                newNums[index] = max;
                index++;
            }
        }
        return newNums;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }
        int newNums[] = new int[nums.length - k + 1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(3);
        arrayDeque.offer(nums[0]);
        arrayDeque.offer(nums[1]);
        arrayDeque.offer(nums[2]);
        int index = 0;
        for (int i = 3; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arrayDeque.element(); j++) {
                max=Math.max(max,arrayDeque.element());
            }
            arrayDeque.poll();
            arrayDeque.offer(nums[i]);
        }
        return newNums;
    }

    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(k);

        int newNums[] = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            arrayDeque.offer(nums[i]);
        }
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arrayDeque.element(); j++) {
                max=Math.max(max,arrayDeque.element());
            }
            arrayDeque.poll();
            arrayDeque.offer(nums[i]);
        }
        return newNums;
    }
}
