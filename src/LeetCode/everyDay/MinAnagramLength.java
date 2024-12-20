package LeetCode.everyDay;

import java.util.Arrays;

public class MinAnagramLength {
    /**
     * 给你一个字符串 s ，它由某个字符串 t 和若干 t  的 同位字符串 连接而成。
     * <p>
     * 请你返回字符串 t 的 最小 可能长度。
     * 同位字符串 指的是重新排列一个单词得到的另外一个字符串，
     * 原来字符串中的每个字符在新字符串中都恰好只使用一次。
     * 示例 1：
     * 输入：s = "abba"
     * 输出：2
     * 解释：
     * 一个可能的字符串 t 为 "ba" 。
     * 入：s = "cdef"
     * <p>
     * 输出：4
     * <p>
     * 解释：
     * <p>
     * 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。
     *
     * @param s
     * @return
     */
    public static void main(String[] args) {
        MinAnagramLength minAnagramLength = new MinAnagramLength();
        String s = "abba";
        System.out.println(minAnagramLength.minAnagramLength2(s));
    }

    //失败版本
    public int minAnagramLength(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                res++;
            }
        }
        return res;
    }
    //低耗时
    public int minAnagramLength4(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        for(int k=1; k<=n/2; k++){
            if(n%k != 0) continue;
            int[] cnt = new int[26];
            for(int j=0; j<k; j++){
                cnt[ch[j]-'a']++;
            }
            boolean flg = true;
            for(int i=k; i<=n-k; i+=k){
                int[] cnt0 = new int[26];
                for(int j=i; j<i+k; j++){
                    cnt0[ch[j]-'a']++;
                }
                if(!Arrays.equals(cnt, cnt0)){
                    flg = false;
                    break;
                }
            }
            if(!flg) continue;
            return k;
        }
        return n;
    }
    public int minAnagramLength2(String s) {
        int n = s.length();
        for (int i = 1; i <= n/2; i++) {
            //屏蔽非整长的数据
            if (n%i != 0) {
                continue;
            }
            String curronStr = s.substring(0, i);
            boolean flag = true;
            for (int j = 0; j < n; j += i) {
                String isA = s.substring(j, j + i);
                if (!isAnagram(curronStr, isA)) {
                    flag = false;
                    break;
                }
            }
            //如果每一段都可以那么就返回
            if (flag) {
                return i;
            }
        }
        return n;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26]; // 假设字符串只包含小写字母
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public int minAnagramLength3(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (n % i != 0) {
                continue;
            }
            if (check(s, i)) {
                return i;
            }
        }
        return n;
    }

    public boolean check(String s, int m) {
        int[] count0 = new int[26];
        for (int j = 0; j < s.length(); j += m) {
            int[] count1 = new int[26];
            for (int k = j; k < j + m; k++) {
                count1[s.charAt(k) - 'a']++;
            }
            if (j > 0 && !Arrays.equals(count0, count1)) {
                return false;
            }
            count0 = count1;
        }
        return true;
    }


}
