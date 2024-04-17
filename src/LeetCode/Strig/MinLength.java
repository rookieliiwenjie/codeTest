package LeetCode.Strig;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class MinLength {

    public static void main(String[] args) {
//        String s = "ACBBD";
//        String s = "ABFCACDB";
//        // System.out.println(minLength2(s));
//        System.out.println(minLength3(s));

        try {
            int x = 1 / 0;
        }  finally {
            System.out.println("finally");
        }
    }

    /**
     * AB CD
     *
     * @param s
     * @return
     */
    public static int minLength(String s) {
        int min = Integer.MAX_VALUE;
        if (s.contains("AB") || s.contains("CD")) {
            int ab1 = s.indexOf("AB");
            int index = ab1 == -1 ? s.indexOf("CD") : ab1;
            min = Math.min(minLength(s.substring(0, index) + s.substring(index + 2)), min);
        }
        return Math.min(s.length(), min);
    }

    public static int minLength2(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            int ab1 = s.indexOf("AB");
            int index = ab1 == -1 ? s.indexOf("CD") : ab1;
            s = s.substring(0, index) + s.substring(index + 2);
        }
        return s.length();
    }

    /**
     * 模拟栈实现
     *
     * @param s
     * @return
     */
    public static int minLength3(String s) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characters.add(c);
            int len = characters.size();
            if (len >= 2 && ((characters.get(len - 2) == 'A' && characters.get(len - 1) == 'B') ||
                    (characters.get(len - 2) == 'C' && characters.get(len - 1) == 'D'))) {
                characters.remove(len - 1);
                characters.remove(len - 2);
            }
        }
        return characters.size();
    }

    public static int minLength4(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            int len = s.length();
//            if (len >= 2 && ((s.charAt(0) == 'A' && s.charAt(1) == 'B') ||
//                    (s.charAt(0)== 'C' && s.charAt(1) == 'D'))) {
//                characters.remove(len - 1);
//                characters.remove(len - 2);
//            }
//        }
//        return s.length();
        return 0;
    }


}
