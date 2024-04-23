package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams.groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String keyString = Arrays.toString(charArray);
            hashMap.computeIfAbsent(keyString, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> returnList = new ArrayList<>(hashMap.values());
        return returnList;
    }
}
