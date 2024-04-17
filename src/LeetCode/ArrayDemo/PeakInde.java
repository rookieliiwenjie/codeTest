package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/17 3:24 下午
 * @Description:
 */
public class PeakInde {

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1};
        peakIndex(arr);
    }

    public static int peakIndex(int[] arr) {
        if (arr.length <= 0) {
            return 0;
        }
        int index = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
                //在山峰的右侧 所以 这个时候要+1
            if (arr[mid] > arr[mid + 1]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        }

        return end;
    }
}
