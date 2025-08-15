package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> res = new ArrayList<>();
        hashMap.forEach((k, v) -> {
            if (v > nums.length / 3) {
                res.add(k);
            }
        });
        return res;
    }

}
