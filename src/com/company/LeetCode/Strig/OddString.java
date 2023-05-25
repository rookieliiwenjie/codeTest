package com.company.LeetCode.Strig;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/25 10:16 上午
 * @Description:
 */
public class OddString {
    public static String oddString(String[] words) {
        int[] word1 = getNum(words[0]);
        int[] word2 = getNum(words[1]);
        if (Arrays.equals(word1, word2)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(word1, getNum(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(word1, getNum(words[2])) ? words[1] : words[0];
    }

    public static int[] getNum(String word) {
        int[] arr = new int[word.length() - 1];
        //ifference[i][j] = words[i][j+1] - words[i][j]
        for (int i = 0; i < word.length() - 1; i++) {
            arr[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        getNum("adc");
        String arr[] = {"aaa", "bob", "ccc", "ddd"};
        oddString(arr);
    }


}
