package LeetCode.everyDay;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        int nums[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate.singleNonDuplicate2(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }

    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            //这里相等意味着现在 mid 是偶数 ，所以mid+1 == mid 的时候 mid+1 的左边是偶数长度，所以low == mid +2；
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid - 1;
            }

        }
        return nums[low];
    }
}
