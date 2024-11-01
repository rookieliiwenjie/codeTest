package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestEqualSubArray {

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 3, 1, 3};
        int k = 3;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        LongestEqualSubArray longestEqualSubArray = new LongestEqualSubArray();
        System.out.println(longestEqualSubArray.longestEqualSubArray(list, k));
    }

    public int longestEqualSubArray(List<Integer> nums, int k) {
        int max = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int beingNum = nums.get(0);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(k);
        list.add(1);
        map.put(beingNum, list);
        for (int i = 0; i < nums.size(); i++) {
            if (beingNum != nums.get(i)) {
                if (map.containsKey(nums.get(i))) {
                    List<Integer> list1 = map.get(nums.get(i));
                    int index = list1.get(0);
                    Integer kNum = list1.get(1);
                    Integer sum = list1.get(2);
                    if ((i - index) - 1 <= kNum) {
                        max = Math.max(max, sum + (i - index));
                        kNum -= i - index;
                        list1.set(2, sum + (i - index));
                        list1.set(0, i);
                        list1.set(1, kNum);
                    } else {
                        list1.set(0, i);
                        list1.set(1, k);
                        list1.set(2, 0);
                    }
                    map.put(nums.get(i), list1);
                } else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(0, i);
                    list1.add(1, k);
                    list1.add(2, 0);
                    map.put(nums.get(i), list1);
                }
                beingNum = nums.get(i);
            }
        }
        return max;
    }


    public int longestEqualSubArray2(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int beingNum = nums.get(0);
        map.computeIfAbsent(beingNum, key -> new ArrayList<>()).add(0);
        for (int i = 0; i < nums.size(); i++) {
            if (beingNum != nums.get(i)) {
                map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
                map.computeIfAbsent(beingNum, key -> new ArrayList<>()).add(i);
                beingNum = nums.get(i);
            }
        }
        int max = 0;
        int leght = nums.size();
        for (List<Integer> values : map.values()) {

        }
        return max;
    }


    public int longestEqualSubArray3(List<Integer> nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }
        int max = 0;
        for (List<Integer> values : map.values()) {
            if (values.size() == 1) {
                max = Math.max(max, 1);
                continue;
            }
            int sum = 0;
            for (int i = 0; i < values.size(); i++) {
                int left = i;
                int right = i + 1;
                int Km = k;
                int Sun = 1;
                while (right < values.size() && left < values.size() - 1 && Km - (values.get(right) - values.get(left) - 1) >= 0) {
                    left++;
                    right++;
                    Sun++;
                    max = Math.max(max, Sun);
                    break;
                }
            }
        }
        return max;
    }
}
