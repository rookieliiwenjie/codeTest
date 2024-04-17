package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 4:24 下午
 * @Description:
 */
public class Permutation {
    public static void main(String[] args) {

    }

    public String[] permutation(String s) {
        if (s.length() <= 1) {
            return new String[]{s};
        }
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

            }
        }
        return null;
    }

}
