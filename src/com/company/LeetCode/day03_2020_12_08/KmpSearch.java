package com.company.LeetCode.day03_2020_12_08;

import com.sun.tools.javac.util.StringUtils;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class KmpSearch {
    public static void main(String[] args) {
        int i = strStrKmp("abcdadaaaadaaaaaa", "aaaaaa");
        //System.out.println("i = " + i);
        String a = "dddadfadfadf";
        String b = "adf";
        int i1 = a.indexOf(b);
        System.out.println("i1 = " + i1);

    }

    private static int num = -1;

    //sunday
    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return num;
        }
        for (int start = 0; start < haystack.length() - needle.length() + 1; ++start) {
            if (haystack.startsWith(needle, start)) {
                return start;
            }

        }
        return num;
    }

    //sunday
    public int strStrSunday(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return num;
        }
        for (int start = 0; start < haystack.length() - needle.length() + 1; ++start) {
            if (haystack.startsWith(needle, start)) {
                return start;
            }

        }
        return num;
    }

    public static int strStrKmp(String source, String pattern) {
        if (null == source || source.length() <= 0 || null == pattern || pattern.length() <= 0) {
            return -1;
        }
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = getNext(ptn);
        while (i < sLen && j < pLen) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;
    }

   

    public static int[] getNext2(char[] p) {
        int[] next = new int[p.length];
        int i = 0;
        int j = -1;
        while (p.length - 1 > i) {
            if (j == -1 && p[i] == p[j]) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int[] getNext(char[] p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        //-1是为了避免死循环
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        // next数组中next[0]为-1
        next[0] = -1;
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    public static int kmpSearch22(String str, String par){
        if(str.length()<=0||par.length()<=0){
            return num;
        }
        int strLenght = str.length();
        return num;
    }
    public static int[] getNext22(char[] p) {
        int k = -1;
        int i = 0;
        int[] next = new int[p.length];
        next[0] = -1;
        while (p.length > i) {
            if (k == -1 || (next[i] == next[k])) {
                k++;
                i++;
                next[i] = k;
            }else {
                k=next[k];
            }
        }
        return next;
    }
}

