package LeetCode.oneHuFive;

public class SearchInsert {
    public static void main(String[] args) {
//        int nums[] = {1, 3, 5, 6};
//        int target = 5;
        int nums[] = {1, 3, 5, 6};
        int target = 7;
//        int nums[] = {1, 3, 5, 6};
//        int target = 2;
//
//        int nums[] = {1};
//        int target = 1;

        SearchInsert searchInsert = new SearchInsert();
        searchInsert.searchInsert(nums, target);
    }

    public int searchInsert(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left >= nums.length ? left : nums[left] < target ? left + 1 : left;
    }

    /**
     * 官方版本
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int nums[], int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public int searchInsert3(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int num = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                num = mid + 1;
                right = mid - 1;
            } else if (nums[mid] < target) {
                num = mid - 1;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return num;
    }
}
