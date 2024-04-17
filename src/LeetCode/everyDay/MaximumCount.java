package LeetCode.everyDay;

public class MaximumCount {

    public int maximumCount(int[] nums) {
        int fuNum = 0;
        int zengNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                fuNum++;
            }
            if (nums[i] > 0) {
                zengNum++;
            }
        }
        return Math.max(fuNum, zengNum);
    }

    public static void main(String[] args) {
        MaximumCount maximumCount = new MaximumCount();
        int[] nums = {-5,-4,-3,-1, 2, 3, 4, 5,6};
        System.out.println(maximumCount.maximumCount2(nums));
    }

    /**
     * 二分查找 还是合理的
     * @param nums
     * @return
     */
    public int maximumCount2(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    private int lowerBound(int[] nums, int val) {
        int left = 0, r = nums.length;
        while (left < r) {
            int mid = (left + r) / 2;
            if (nums[mid] >= val) {
                r = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
