package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HalveArray {
    public static void main(String[] args) {
//        int[] nums = {3, 8, 20};
        int[] nums = {5, 19, 8, 1};
        System.out.println("args = " + halveArray2(nums));
    }

    /**
     * 可以对减半的数继续操作
     *
     * @param nums
     * @return
     */
    public static int halveArray(int nums[]) {
        int min = 0;
        Arrays.sort(nums);
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = nums.length - 1;
        double sumTwo = 0;
        while (left <= right || sum / 2 == sumTwo / 2) {
            sumTwo += (double) nums[right] / 2;
            min++;
            if (sumTwo < sum / 2) {
                right--;
            }
            if (sumTwo >= sum / 2) {
                return min;
            }
        }
        return min;
    }

    public static int halveArray2(int nums[]) {
        int min = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((a,b)-> Double.compare(b, a));
        double sum = 0;
        for (int num : nums) {
            double halfNum = (double) num / 2;
            priorityQueue.offer(halfNum);
            sum += halfNum;
        }
        double sumTow = 0;
        while (!priorityQueue.isEmpty() && sumTow < sum) {
            double poll = priorityQueue.poll();
            sumTow += poll;
            min++;
            if (sum <= sumTow) {
                return min;
            }
            priorityQueue.offer(poll / 2);
        }
        return min;
    }
}
