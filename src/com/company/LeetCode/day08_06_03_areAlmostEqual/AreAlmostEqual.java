package com.company.LeetCode.day08_06_03_areAlmostEqual;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lwj32 on 2021/6/4.
 */
public class AreAlmostEqual {
    public static void main(String[] args) {
        boolean b = areAlmostEqual("bank", "kanb");
        System.out.println("b = " + b);
        HashSet<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('a');
        characters.forEach(character -> System.out.println("character = " + character));

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int sum = 0;
        int s1Index = -1;
        int s2Index = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sum++;
                if (s1Index == -1) {
                    s1Index = i;
                }
                if (s2Index == -1 && s1Index != i) {
                    s2Index = i;
                }
            }
        }
        if (sum == 0) {
            return true;
        } else if (sum == 2) {
            return s1.charAt(s1Index) == s2.charAt(s2Index) && s2.charAt(s1Index) == s1.charAt(s2Index);
        }
        return false;
    }
}
