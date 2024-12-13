package LeetCode.everyDay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetFinalState {
    public static void main(String[] args) {
        GetFinalState getFinalState = new GetFinalState();

//        输出
//                [4,8,6,5,6]
//        预期结果
//                [8,4,6,5,6]
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] finalState = getFinalState.getFinalState2(nums, k, multiplier);
        for (int i : finalState) {
            System.out.print(i+",");
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.offer(poll);
        }
        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res[poll[1]] = poll[0];
        }
        return res;
    }


    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            int min = nums[0];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    maxIndex = j;
                }
            }
            nums[maxIndex] *= multiplier;
        }
        return nums;

    }
    public int[] getFinalState3(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            nums[maxIndex] *= multiplier;
        }
        return nums;

    }
//        [4,5,6,6,8]
//        预期结果
//    [8,4,6,5,6]
}
