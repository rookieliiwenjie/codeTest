package LeetCode.everyDay;

public class IsSubstringPresent {


    /**
     * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
     * <p>
     * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
     * 示例 1：
     * 输入：s = "leetcode"
     * 输出：true
     * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中
     * @param s
     * @return
     */

    public boolean isSubstringPresent(String s) {
        String recoverString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            recoverString += s.charAt(i);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (recoverString.contains(substring)) {
                return true;
            }
        }
        return false;

    }

    //给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
    public boolean isSubstringPresent2(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            String matchStr = new StringBuffer(s.substring(i, i + 2)).reverse().toString();
            if (s.contains(matchStr)) {
                return true;
            }
        }
        return false;

    }

    /**
     * 思路与算法
     * <p>
     * 我们可以用哈希表提前存储字符串中的每个长度为 2 的子串，这样在判断翻转后的字符串是否出现时就避免了花费 O(n) 的时间查找。
     * <p>
     * 由于字符仅包含小写字母，该哈希表可以用一个整数类型的二维数组实现，形如 hash[26][26]。如果要进一步优化
     * ，还可以考虑将第二维使用二进制表示，例如 hash[2] 二进制形式中，如果从低到高第 1 位为 1，
     * 则表示子串 ‘‘cb" 出现在字符串中（2 表示字符 c，1 表示字符 b）。
     *
     * @param s
     * @return
     */
    public boolean isSu(String s) {
        int[] h = new int[26];
        for (int i = 0; i + 1 < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i + 1) - 'a';
            h[x] |= 1 << y;
            if ((h[y] >> x & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubstringPresent isSubstringPresent = new IsSubstringPresent();
        System.out.println(isSubstringPresent.isSubstringPresent("abcba"));
    }
}
