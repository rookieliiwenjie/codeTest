package LeetCode.Strig;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/3 11:16 上午
 * @Description:
 */
public class MaxrepOpt1 {
    public static void main(String[] args) {
        String text = "aaabaaa";
        maxRepOpt1(text);
    }
    public static int maxRepOpt1(String text) {
        char[] chs = text.toCharArray();
        int[] cnt = new int[26];
        for (char c : chs) {
            cnt[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            char curChar = text.charAt(i);
            int j = i;
            //获取每一段相同的数据
            while (j < text.length() && text.charAt(i) == text.charAt(j)) {
                j++;
            }
            //获取相同字段的最长长度
            int curCnt = j - i;
            //因为可以交互一次，所以当 选中的字母长度小于当前切割的长度且 端点不是0且端点不是尾部，这个时候 +1
            if (cnt[curChar - 'a'] > curCnt && i != 0 && j < text.length()) {
                res = Math.max(curCnt + 1, res);
            }
            //往后延展，因为可以交换位置，所以我们可以找到相隔为1的下一个相同的字符，如果相等继续走，如果不相等那么就开始第二个字符
            int k = j + 1;
            while (k < text.length() && text.charAt(i) == text.charAt(k)) {
                k++;
            }
            //因为在上面有一部中我们默认中间相隔的是相同字母，所以后面在计算的时候我们要和当前的字符做比较不能大于当前字符
            res = Math.max(res, Math.min(k - i,cnt[curChar-'a']));

        }
        return res;

    }

    public int maxRepOpt2(String text) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < text.length(); ) {
            // step1: 找出当前连续的一段 [i, j)
            int j = i;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int curCnt = j - i;
            // step2: 如果这一段长度小于该字符出现的总数，并且前面或后面有空位，则使用 curCnt + 1 更新答案
            if (curCnt < count.getOrDefault(text.charAt(i), 0) && (j < text.length() || i > 0)) {
                res = Math.max(res, curCnt + 1);
            }

            // step3: 找到这一段后面与之相隔一个不同字符的另一段 [j + 1, k)，如果不存在则 k = j + 1
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - i, count.getOrDefault(text.charAt(i), 0)));
            i = j;
        }
        return res;
    }



    class Solution {
        public int maxRepOpt1(String text) {
            if (text == null || text.length() == 0) {
                return 0;
            }
            char[] chs = text.toCharArray();
            int[] cnt = new int[26];
            for (char c : chs) {
                cnt[c - 'a']++;
            }
            char currChar = chs[0];
            int currCharCnt = 1;
            int len = chs.length;
            int ans = 1;
            for (int i = 1; i < len; i++) {
                if (chs[i] == currChar) {
                    currCharCnt++;
                } else {
                    int idxSecond = i + 1;
                    while (idxSecond < len && chs[idxSecond] == currChar) {
                        idxSecond++;
                        currCharCnt++;
                    }
                    if (cnt[currChar - 'a'] > currCharCnt) {
                        currCharCnt++;
                    }
                    ans = Math.max(ans, currCharCnt);
                    currChar = chs[i];
                    currCharCnt = 1;
                }
            }
            if (cnt[currChar - 'a'] > currCharCnt) {
                currCharCnt++;
            }
            ans = Math.max(ans, currCharCnt);
            return ans;
        }
    }
}
