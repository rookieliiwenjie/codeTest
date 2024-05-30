package LeetCode.everyDay;

import java.util.Arrays;

public class FindIndices {
    public static void main(String[] args) {
        FindIndices findIndices = new FindIndices();
//        int nums[]={5,1,4,1};
//        int indexDifference=2;
//        int valueDifference=4;
//        int nums[]={2,1};
//        int indexDifference=0;
//        int valueDifference=0;
        int nums[] = {1, 2, 3};
        int indexDifference = 2;
        int valueDifference = 4;
        int[] result = findIndices.findIndices(nums, indexDifference, valueDifference);
        System.out.println(Arrays.toString(result));
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int left = 0;
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int length = nums.length;
        boolean flat = false;
        while (left < length) {
            int right = left + indexDifference;
            while (right < length) {
                if (Math.abs(left - right) >= indexDifference && Math.abs(nums[left] - nums[right]) >= valueDifference) {
                    result[0] = left;
                    result[1] = right;
                    flat = true;
                    break;

                }
                right++;
            }
            if (flat) break;
            left++;
        }
        return result;
    }

    /**
     * 一次循环
     * 我只能说很厉害，尤其是 int i = j-indexDifference;
     * 这样循环不断的向后走，但是已经拿到了最小的一个index，相当于
     * i 循环0 到 length-indexDifferent 保证获取
     * j 循环的 indexDifference - length
     * 而且保证了 i -j>=indexDifferent
     * @param nums
     * @param indexDifference
     * @param valueDifference
     * @return
     */
    public int[] findIndicesOnce(int[] nums, int indexDifference, int valueDifference) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int length = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for (int j = indexDifference; j < length; j++) {
            int i = j - indexDifference;
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[j] - nums[minIndex] >= valueDifference) {
                return new int[]{minIndex, j};
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[maxIndex] - nums[j] >= valueDifference) {
                return new int[]{maxIndex, j};
            }
        }
        return new int[]{-1, -1};
    }
}
