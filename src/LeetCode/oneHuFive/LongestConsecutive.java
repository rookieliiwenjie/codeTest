package LeetCode.oneHuFive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flat = true;
            int SumFor = 1;
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            while (flat) {
                if (set.contains(left)) {
                    SumFor++;
                    left--;
                }
                if (set.contains(right)) {
                    SumFor++;
                    right++;
                }
                if (!set.contains(right) && !set.contains(left)) {
                    flat = false;
                }
            }
            sum = Math.max(sum, SumFor);

        }
        return sum;
    }

    public int longestConsecutive2(int[] nums) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : nums) {
            //这里就很厉害，我那会还在纠结可不可以进行少算几次，还想使用list，这里使用和这个，就可以避免计算很多数据。
            if (!set.contains(num - 1)) {
                int SumFor = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    SumFor++;
                }
                sum = Math.max(sum, SumFor);

            }
        }
        return sum;
    }
}
