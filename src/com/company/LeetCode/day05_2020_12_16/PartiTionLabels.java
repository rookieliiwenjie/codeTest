package com.company.LeetCode.day05_2020_12_16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rookie.li
 * @create 2020/12/15
 */
public class PartiTionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integerList = partitionLabels(s);
        System.out.println("integerList.toString() = " + integerList.toString());
    }

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
     * 同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     * 示例：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegdege", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


}
