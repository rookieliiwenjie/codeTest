package LeetCode.ArrayDemo;

public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        // int nums[] = {1, -2, 3, -2};
        int nums[] = {5, -2, 5};
        System.out.println(maxSubarraySumCircular3(nums));

    }

    public static int maxSubarraySumCircular(int nums[]) {
        int numLength = nums.length - 1;
        int left = 0;
        int right = 1;
        int max = nums[left], pre = nums[left];
        if (nums.length == 1) {
            return max;
        }
        //比较大的问题是如何环 ，到了第一个环如何解决
        while (left <= numLength && left <= (right % numLength)) {
            if ((pre + nums[right % numLength]) >= pre) {
                pre = pre + nums[right % numLength];
                right++;
            } else {
                left = right;
                pre = nums[left];
            }
            max = Math.max(max, pre);
        }
        return max;
    }


    public static int maxSubarraySumCircular2(int nums[]) {
        if (nums.length <= 0) {
            return 0;
        }
        int sum = nums[0], pre = nums[0];
        int left = 0;
        for (int i = 1; i < nums.length * 2; i++) {
            int numIndex = i % nums.length;
            if (numIndex == left) {
                pre = pre - nums[numIndex];
                left++;
                if (sum < pre) {
                    sum = pre;
                }
            }
            pre = Math.max(pre + nums[numIndex], nums[numIndex]);
            sum = Math.max(sum, pre);
        }
        return sum;
    }

    public static int maxSubarraySumCircular3(int nums[]) {
        if (nums.length <= 0) {
            return 0;
        }
        int sum = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            sum = Math.max(sum, pre);
        }

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            sum = Math.max(sum, pre);
        }
        return sum;
    }
}


