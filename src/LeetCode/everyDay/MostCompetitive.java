package LeetCode.everyDay;

import java.util.*;

public class MostCompetitive {
    /**
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive(int nums[], int k) {
        int result[] = new int[k];
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {

        }
        return result;

    }

    public static void main(String[] args) {
        MostCompetitive mostCompetitive = new MostCompetitive();
//        int nums[] = {3, 5, 2, 6};
//        int k = 2;
//        int nums[] = {2, 4, 3, 3, 5, 4, 9, 6};
//        int k = 4;
        int nums[] = {71,18,52,29,55,73,24,42,66,8,80,2};
        int k = 3;
        int result[] = mostCompetitive.mostCompetitiveGuan(nums, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] mostCompetitive2(int nums[], int k) {
        int result[] = new int[k];
        int[][] sortNum = new int[nums.length][2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sortNum[i][0] = nums[i];
            sortNum[i][1] = i;
        }
        Arrays.sort(sortNum, Comparator.comparingInt(a -> a[0]));
        int resultIndex = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < n && resultIndex < k; i++) {
            if (sortNum[i][1] > minIndex) {
                result[resultIndex] = sortNum[i][0];
                resultIndex++;
                continue;
            }
            if (n - sortNum[i][1] > (k - 1) && minIndex == Integer.MAX_VALUE) {
                minIndex = Math.min(minIndex, sortNum[i][1]);
                result[resultIndex] = sortNum[i][0];
                resultIndex++;
            }
        }

        return result;

    }

    public int[] mostCompetitiveGuan(int nums[], int k) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && n - i + stack.size() > k && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] res = new int[k];
        while (stack.size() > k) {
            stack.pop();
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;

    }
}
