package LeetCode.Strig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {

    public static void main(String[] args) {
        char a = 'b';
        int anum = a - 'a';
        //System.out.println(anum);
        // String s = "bbbb";
        String s = "abcabcbb";
        //String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(s));
    }

    public static int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (hashMap.containsKey(sChar)) {
                while (start < (hashMap.get(sChar) + 1)) {
                    char indexW = s.charAt(start);
                    hashMap.put(indexW, 0);
                    start++;
                }
            }
            hashMap.put(sChar, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }


    public static int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int start = -1;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i != 0) {
                characters.remove(c);
            }
            while (start < n && !characters.contains(c)) {
                characters.add(c);
                start++;
            }
        }
        return 0;

    }
}
