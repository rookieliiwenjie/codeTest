package LeetCode.everyDay;

public class FindClosestNumber {
    public static void main(String[] args) {
        FindClosestNumber findClosestNumber = new FindClosestNumber();
        int nums[] = {2, -1, 1};
        findClosestNumber.findClosestNumber(nums);
        System.out.println(findClosestNumber.findClosestNumber(nums));
    }

    public int findClosestNumber(int[] nums) {
        int minMax = nums[0];
        for (int num : nums) {
            int min = Math.abs(num);
            if (min <= Math.abs(minMax)) {
                minMax = Math.abs(num) == Math.abs(minMax) ? Math.max(num, minMax) : num;
            }
        }
        return minMax;
    }
}
