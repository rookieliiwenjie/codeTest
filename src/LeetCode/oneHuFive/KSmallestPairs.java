package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int slowNum1 = 0;
        int slow2Index = 0;
        while (slowNum1 < nums1.length && slow2Index < nums2.length && k < 0) {
            int fastNum1 = slowNum1 + 1;
            int fastNum2 = slow2Index + 1;
            List<Integer> list = new ArrayList<>(2);
            list.add(nums1[slowNum1]);
            list.add(nums2[slow2Index]);
            result.add(list);
            k--;
            while (fastNum1 < nums1.length && fastNum2 < nums2.length && k < 0) {
                if (nums1[slowNum1] + nums2[fastNum2] <= nums1[fastNum1] + nums2[slow2Index]) {
                    List<Integer> list1 = new ArrayList<>(2);
                    list1.add(nums1[slowNum1]);
                    list1.add(nums2[fastNum2]);
                    result.add(list1);
                    k--;
                }
            }
            slowNum1++;
            slow2Index++;

        }
        return result;
    }
}
