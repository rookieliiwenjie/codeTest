package LeetCode.everyDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidSubstringCount {

    /*给你两个字符串 word1 和 word2 。

如果一个字符串 x 重新排列后，word2 是重排字符串的
前缀，那么我们称字符串 x 是 合法的 。

请你返回 word1 中 合法
子字符串
 的数目。
    子字符串
    的数目。
    示例 1：

    输入：word1 = "bcca", word2 = "abc"
    输出：1
    解释：
    唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。
    示例 2：
    输入：word1 = "abcabc", word2 = "abc"
    输出：10
    abc
    bca
    解释：除了长度为 1 和 2 的所有子字符串都是合法的。
    示例 3：
    输入：word1 = "abcabc", word2 = "aaabc"

    输出：0*/


    public long validSubstringCount2(String word1, String word2) {
        long res = 0;
        return res;
    }

    public static long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> word2Counter = new HashMap<>();
        for (char c : word2.toCharArray()) {
            word2Counter.put(c, word2Counter.getOrDefault(c, 0) + 1);
        }
        long validCount = 0;

        for (int start = 0; start < word1.length(); start++) {
            Map<Character, Integer> currentCounter = new HashMap<>();
            for (int end = start; end < word1.length(); end++) {
                char c = word1.charAt(end);
                currentCounter.put(c, currentCounter.getOrDefault(c, 0) + 1);

                if (currentCounter.size() >= word2Counter.size()) {
                    boolean isValid = true;
                    for (Map.Entry<Character, Integer> entry : word2Counter.entrySet()) {
                        if (currentCounter.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        validCount++;
                    }
                }
            }
        }

        return validCount;
    }
    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abc";
        System.out.println(validSubstringCount(word1, word2));  // Output the number of valid substrings
    }

    /**
     * guanwang
     * @param word1
     * @param word2
     * @return
     */
    public long validSubstringCount3(String word1, String word2) {
        int[] diff = new int[26];
        for (char c : word2.toCharArray()) {
            diff[c - 'a']--;
        }

        long res = 0;
        int[] cnt = { (int) Arrays.stream(diff).filter(c -> c < 0).count() };
        int l = 0, r = 0;
        while (l < word1.length()) {
            while (r < word1.length() && cnt[0] > 0) {
                update(diff, word1.charAt(r) - 'a', 1, cnt);
                r++;
            }
            if (cnt[0] == 0) {
                res += word1.length() - r + 1;
            }
            update(diff, word1.charAt(l) - 'a', -1, cnt);
            l++;
        }
        return res;
    }

    private void update(int[] diff, int c, int add, int[] cnt) {
        diff[c] += add;
        if (add == 1 && diff[c] == 0) {
            // 表明 diff[c] 由 -1 变为 0
            cnt[0]--;
        } else if (add == -1 && diff[c] == -1) {
            // 表明 diff[c] 由 0 变为 -1
            cnt[0]++;
        }
    }
}
