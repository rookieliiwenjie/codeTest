package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
//        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums = {0};
        System.out.println(summaryRanges.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int num = nums[0], currindex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((num + 1) == nums[i]) {
                num += 1;
            } else {
                if(currindex==num){
                    list.add(String.valueOf(currindex));

                }else {
                    String stringBuilder = currindex +
                            "->" +
                            num;
                    list.add(stringBuilder);
                }
                num = nums[i];
                currindex = nums[i];
            }
        }
        if(currindex==num){
            list.add(currindex+"");

        }else {
            list.add(currindex + "->" + num);
        }
        return list;
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
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
