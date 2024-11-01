package LeetCode.oneHuFive;

import java.util.HashMap;

public class IsIsomorphic {
    public static void main(String[] args) {
       boolean re =  isIsomorphic("paper", "title");
        System.out.println(re);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)) && hashMap.containsKey(t.charAt(i))) {
                if (hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) != t.charAt(i)) return false;
                if (hashMap.containsKey(t.charAt(i)) && hashMap.get(t.charAt(i)) != s.charAt(i)) return false;
            } else {
                if (hashMap.containsKey(t.charAt(i))) {
                    hashMap.put(s.charAt(i), t.charAt(i));
                }
                if (hashMap.containsKey(s.charAt(i))) {
                    hashMap.put(t.charAt(i), s.charAt(i));
                }
            }
        }
        return true;
    }
}
