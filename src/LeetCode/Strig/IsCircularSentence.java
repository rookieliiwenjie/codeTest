package LeetCode.Strig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/30 10:15 上午
 * @Description:
 */
public class IsCircularSentence {
    public static void main(String[] args) {
//        String s = "leetcode exercises sound delightful";
        //String s = "Leetcode is cool";
//        String s = "leetcode";
        String s = "ab a";
        System.out.println("s = " + isCircularSentence(s));
    }

    public static boolean isCircularSentence(String sentence) {
        List<String> spiltString = Arrays.asList(sentence.split(" "));
        int size = spiltString.size();
        char firstChar = spiltString.get(0).charAt(0);
        char endChar = spiltString.get(0).charAt(spiltString.get(0).length() - 1);
        if (size == 1) {
            return firstChar == endChar;
        }
        for (int i = 1; i < size; i++) {
            String s = spiltString.get(i);
            char end = s.charAt(s.length() - 1);
            char first = s.charAt(0);
            if (first != endChar) {
                return false;
            }
            if (i == size - 1) {
                return end == firstChar;
            }
            endChar = end;
        }
        return true;
    }

    public boolean isCircularSentence2(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public boolean myisCircularSentence(String sentence) {
        int size = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(size - 1)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            } else {
                hashMap.put(nums[i], i);
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
