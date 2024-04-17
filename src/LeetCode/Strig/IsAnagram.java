package LeetCode.Strig;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/30 9:00 下午
 * @Description:
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("args = " + isAnagram2("abcdefa","acdebfa"));

        System.out.println("args = " + isAnagram3("abcdefa","acdebfa"));
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }


    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int tc = t.charAt(i) - 'a';
            if (arr[tc] <= 0) {
                return false;
            }
            arr[tc]--;
        }
        return true;
    }
}
