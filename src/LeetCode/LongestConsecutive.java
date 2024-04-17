package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        if (nums.length == 0) {
            return longest;
        }
        Set<Integer> numSet = new HashSet<>();
        Arrays.stream(nums).forEach(numSet::add);
        for (int num : nums) {
            int curronNum = num;
            int currSum = 1;
            while (numSet.contains(curronNum + 1)) {
                currSum++;
                curronNum++;
            }
            longest = Math.max(longest, currSum);
        }
        return longest;
    }
}
