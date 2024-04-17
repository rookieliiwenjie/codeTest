package LeetCode.Strig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountWords {
    public static void main(String[] args) {
        String words[] = {"hello", "world", "leetcode", "leetcode"};
        String words2[] = {"amaziong", "world", "leetcode"};
        System.out.println(countWords(words, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        int count = 0;
        for (String word : map2.keySet()) {
            if (map2.get(word) == 1 && map.getOrDefault(word, 0) == 1) {
                count++;
            }
        }
        return count;

    }

}
