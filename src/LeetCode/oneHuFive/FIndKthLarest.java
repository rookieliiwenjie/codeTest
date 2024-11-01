package LeetCode.oneHuFive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FIndKthLarest {
    public int findKthLarest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
