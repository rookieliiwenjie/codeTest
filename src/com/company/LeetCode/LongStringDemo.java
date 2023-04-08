package com.company.LeetCode;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/7 2:32 下午
 * @Description:
 */
public class LongStringDemo {
    public static void main(String[] args) {
        Integer abcdd = getStr("dvdf");
        Integer abba = getStr("abba");
        System.out.println("dvdf = " + abcdd+ "getStr2 ="+getStr2("abba"));
    }

    /**
     * 第一版
     * @param s
     * @return
     */
    public static Integer getStr(String s){
        HashMap<Character, Integer> stringHashMap = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        while (startIndex < s.length()) {
            char c = s.charAt(startIndex);
            if (stringHashMap.containsKey(c)) {
                maxLength = Math.max(maxLength, stringHashMap.keySet().size());
                startIndex = stringHashMap.get(c) + 1;
                stringHashMap = new HashMap<>();
                continue;
            }
            stringHashMap.put(c, startIndex);
            startIndex++;
        }
        return Math.max(maxLength, stringHashMap.keySet().size());
    }


    public static Integer getStr3(String s){
        HashMap<Character, Integer> stringHashMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stringHashMap.containsKey(c)) {
                start = Math.max(stringHashMap.get(c) + 1, start);
            }
            stringHashMap.put(c, i);
            maxLength =  Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
    public static Integer getStr2(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                //这里就是为了记录截取的最大长度 如果出现 abba 就是确认start滑动到重复的最大的地方 abba 如果不比较的话 就会出现拿最开始出现的数据了，如abba 就会取a
               start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}
