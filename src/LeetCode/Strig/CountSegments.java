package LeetCode.Strig;

import java.util.Arrays;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-07 21:04
 */
public class CountSegments {
    public static void main(String[] args) {
        int i = countSegments(", , , ,        a, eaefa");
        int j = countSegments5(", , , ,        a, eaefa");
        System.out.println("i = " + i);
    }

    public static int countSegments(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Object[] stringStream = Arrays.stream(s.split(" ")).filter(s1 -> !s.isEmpty()).toArray();
        return stringStream.length;
    }

    public static int countSegments5(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1.length;
    }

    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    public int countSegments3(String s) {
        int segmentCount = 0;

        if (s == null || s.isEmpty()) {
            return segmentCount;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    public int countSegment6(String s) {
        int segmentCount = 0;

        if (s == null || s.isEmpty()) {
            return segmentCount;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
