package LeetCode.everyDay;

import java.util.Arrays;

public class MinValidStrings {
    //    给你一个字符串数组 words 和一个字符串 target。
//
//    如果字符串 x 是 words 中 任意 字符串的前缀
//  ，则认为 x 是一个 有效 字符串。
//
//    现计划通过 连接 有效字符串形成 target ，
//    请你计算并返回需要连接的 最少 字符串数量。如果无法通过这种方式形成 target，则返回 -1。

    /**
     * 示例 1：
     * <p>
     * 输入： words = ["abc","aaaaa","bcdef"], target = "aabcdabc"
     * <p>
     * 输出： 3
     * <p>
     * 解释：
     * <p>
     * target 字符串可以通过连接以下有效字符串形成：
     * <p>
     * words[1] 的长度为 2 的前缀，即 "aa"。
     * words[2] 的长度为 3 的前缀，即 "bcd"。
     * words[0] 的长度为 3 的前缀，即 "abc"。
     * 示例 2：
     * <p>
     * 输入： words = ["abababab","ab"], target = "ababa ababa"
     * <p>
     * 输出： 2
     * <p>
     * 解释：
     * <p>
     * target 字符串可以通过连接以下有效字符串形成：
     * <p>
     * words[0] 的长度为 5 的前缀，即 "ababa"。
     * words[0] 的长度为 5 的前缀，即 "ababa"。
     * 示例 3：
     * <p>
     * 输入： words = ["abcdef"], target = "xyz"
     * <p>
     * 输出： -1
     *
     * @param words
     * @param target
     * @return
     */
    public static void main(String[] args) {
        MinValidStrings minValidStrings = new MinValidStrings();
        String words[] = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        int res = minValidStrings.minValidStrings(words, target);
        System.out.println(res);
//        System.out.println( target.substring(0, target.length()));

    }

    public int minValidStrings(String[] words, String target) {
        int res = -1;
        int dp[] = new int[target.length() + 1];
        Arrays.fill(dp, -1);
        int index = 0;
        int subjectLength = -1;
        while (index < target.length()) {
            int j = index + 1;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int k = 1; k < word.length(); k++) {
                    if ((j + k) <= target.length() && target.substring(index, (index + k))
                            .equals(word.substring(0, k))) {
                        subjectLength = Math.max(j, subjectLength);
                    } else  {
                        break;
                    }
                    if (subjectLength != -1) {
                        dp[subjectLength + 1] = Math.max(dp[subjectLength + 1], (subjectLength + 1));
                    }
                }

            }
            index = subjectLength + 1;
        }

        return res;
    }
}
