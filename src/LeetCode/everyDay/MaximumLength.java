package LeetCode.everyDay;

import java.util.*;

public class MaximumLength {
    /**
     * 出现三次的最长子字符串
     *
     * @param s
     * @return
     */
    public int maximumLength(String s) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String baseCase = String.valueOf(s.charAt(i));
            String waiS = String.valueOf(s.charAt(i));
            resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
            for (int j = i + 1; j < s.length(); j++) {
                if (!baseCase.equals(String.valueOf(s.charAt(j)))) {
                    break;
                } else {
                    waiS += s.charAt(j);
                }
                resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
            }
        }
        for (String key : resultMap.keySet()) {
            if (resultMap.get(key) >= 3) {
                max = Math.max(max, key.length());
            }
        }
        return max == 0 ? -1 : max;
    }

    /**
     * 2.0版本
     * 这个版本也没有提升多少
     * 目前按照我的思路来看一定没办法去掉map 只能在匹配逻辑做文章。
     *
     * @param s
     * @return
     */
    public int maximumLength2(String s) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String baseCase = String.valueOf(s.charAt(i));
            String waiS = String.valueOf(s.charAt(i));
            resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
            if (resultMap.get(waiS) >= 3) {
                max = Math.max(max, waiS.length());
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (!baseCase.equals(String.valueOf(s.charAt(j)))) {
                    break;
                } else {
                    waiS += s.charAt(j);
                }
                resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
                if (resultMap.get(waiS) >= 3) {
                    max = Math.max(max, waiS.length());
                }
            }
        }
        return max == 0 ? -1 : max;
    }


    public int maximumLength3(String s) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        int max = 0;
        int i = 0;
        while (i < s.length()) {
            String waiS = String.valueOf(s.charAt(i));
            resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
            if (resultMap.get(waiS) >= 3) {
                max = Math.max(max, waiS.length());
            }
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                waiS += s.charAt(j);
                resultMap.put(waiS, resultMap.getOrDefault(waiS, 0) + 1);
                j++;
                if (resultMap.get(waiS) >= 3) {
                    max = Math.max(max, waiS.length());
                }
            }
            i++;
        }
        return max == 0 ? -1 : max;
    }


    /**
     * 一次遍历，我想到了可以算长度然后再进行计算，但是我不知道如何算，这里可以学习一下
     *
     * @param s
     * @return
     */
    public int maximumLength4(String s) {
        int ans = -1;
        int len = s.length();

        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<Integer>();
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;
            if (i + 1 == len || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;

                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }
                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (chs[i].size() > 0 && chs[i].get(0) > 2) {
                ans = Math.max(ans, chs[i].get(0) - 2);
            }
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            if (chs[i].size() > 2) {
                ans = Math.max(ans, chs[i].get(2));
            }
        }
        return ans;
    }

    /**
     * 二分查找法
     * @param s
     * @return
     */

    public int maximumLength6(String s) {
        int n = s.length();
        Map<Character, List<Integer>> cnt = new HashMap<>();

        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            cnt.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(j - i);
        }

        int res = -1;
        for (List<Integer> vec : cnt.values()) {
            int lo = 1, hi = n - 2;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                int count = 0;
                for (int x : vec) {
                    if (x >= mid) {
                        count += x - mid + 1;
                    }
                }
                if (count >= 3) {
                    res = Math.max(res, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return res;
    }

    /**
     * 灵神版本
     * @param S
     * @return
     */
    public int maximumLength7(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            cnt++;
            if (i + 1 == s.length || s[i] != s[i + 1]) {
                groups[s[i] - 'a'].add(cnt); // 统计连续字符长度
                cnt = 0;
            }
        }
        int ans = 0;
        for (List<Integer> a : groups) {
            if (a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0); // 假设还有两个空串
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }
//        for (int i = 0; i < 26; i++) {
//            if (chs[i].size() > 0 && chs[i].get(0) > 2) {
//                ans = Math.max(ans, chs[i].get(0) - 2);
//            }
//            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
//                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
//            }
//            if (chs[i].size() > 2) {
//                ans = Math.max(ans, chs[i].get(2));
//            }
//        }
        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        MaximumLength maximumLength = new MaximumLength();
//        String s = "abcabcabc";
//        String s = "aaaa";
//        String s="abcdef";
//        String s="cabal";
        String s="aaaaaaaabbaaaa";
     //   String s= "aaaa";
      // String s = "cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde";
        System.out.println(maximumLength.maximumLength7(s));
//        System.out.println(maximumLength.maximumLength2(s));
//        System.out.println(maximumLength.maximumLength3(s));
    }
}
