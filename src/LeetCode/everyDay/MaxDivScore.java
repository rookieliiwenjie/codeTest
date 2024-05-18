package LeetCode.everyDay;

import LeetCode.Tree.TreeNode;
import LeetCode.oneHuFive.MinStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class MaxDivScore {

    public static void main(String[] args) {
        MaxDivScore maxDivScore = new MaxDivScore();
//        int nums[] = {4, 7, 9, 3, 9};
//        int div[] = {5, 2, 3};
        int nums[] = {20, 14, 21, 10};
        int div[] = {5, 7, 5};
        int i = maxDivScore.maxDivScore2(nums, div);
        System.out.println(i);
    }

    /**
     * nums 得分高的， 得分相同的的选取最低的
     *
     * @param nums
     * @param divisors
     * @return
     */
    public int maxDivScore(int[] nums, int[] divisors) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int divisor : divisors) {
            if (!hashMap.containsKey(divisor)) {
                int sum = 0;
                for (int num : nums) {
                    if (num % divisor == 0) {
                        sum++;
                    }
                }
                hashMap.put(divisor, sum);
            }

        }
        int max = Integer.MIN_VALUE;
        int minKey = Integer.MAX_VALUE;
        for (Integer key : hashMap.keySet()) {
            Integer sum = hashMap.get(key);
            if (sum == max) {
                minKey = Math.min(minKey, key);
            }
            if (sum > max) {
                minKey = key;
                max = sum;
            }
        }
        return minKey;
    }

    public int maxDivScore2(int[] nums, int[] divisors) {
        Set<Integer> hashMap = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int minKey = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            if (!hashMap.contains(divisor)) {
                int sum = 0;
                for (int num : nums) {
                    if (num % divisor == 0) {
                        sum++;
                    }
                }
                if (max < sum || (sum == max && divisor < minKey)) {
                    minKey = divisor;
                    max = sum;
                }
                hashMap.add(divisor);
            }
        }
        return minKey;
    }

    public int maxDivScore3(int[] nums, int[] divisors) {
        int cnt = -1, ans = 0;

        for (int i = 0; i < divisors.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    tmp++;
                }
            }

            if (tmp > cnt || (tmp == cnt && divisors[i] < ans)) {
                cnt = tmp;
                ans = divisors[i];
            }
        }
        return ans;
    }
}
