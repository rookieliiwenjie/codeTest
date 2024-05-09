package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 4, 5, 6, 7, 9};
        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> strings = summaryRanges.summaryRanges(nums);
        System.out.println(strings.toString());
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> strings = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return strings;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = end + 1;
            } else {
                strings.add(start != end ? start + "->" + end : String.valueOf(start));
                start = nums[i];
                end = nums[i];
            }
        }
        strings.add(start != end ? start + "->" + end : String.valueOf(start));
        return strings;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
