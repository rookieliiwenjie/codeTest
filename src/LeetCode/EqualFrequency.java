package LeetCode;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 3:36 下午
 * @Description:
 */
public class EqualFrequency {

    public static void main(String[] args) {
        boolean abcc = equalFrequecy("aaaabbbbccc");
        System.out.println("aacc = " + abcc);
    }
    public static boolean equalFrequecy(String word) {
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < word.length(); i++) {
            if (hashMap.containsKey(word.charAt(i))) {
                hashMap.put(word.charAt(i), hashMap.get(word.charAt(i)) + 1);
            } else {
                hashMap.put(word.charAt(i), 1);
            }
        }
        if(hashMap.size()==1){
            return true;
        }
        HashMap<Integer, Integer> wordNumd = new HashMap();
        hashMap.values().stream().forEach(value->{
            if (wordNumd.containsKey(value)) {
                wordNumd.put(value, wordNumd.get(value) + 1);
            } else {
                wordNumd.put(value, 1);
            }
        });
        if(wordNumd.size() == 2){
            int first = 0;
            int firstValu = 0;
            for (Integer key :wordNumd.keySet()) {
                if(first==0){
                    first = key;
                    firstValu = wordNumd.get(key);
                }else {
                   if(firstValu > wordNumd.get(key)){
                       if(key>first && (key -first) == 1){

                       }
                    return true;
                   }else if(key<=first && (first - key) == 1){

                   }
                }
            }

        }
        return wordNumd.size()==1 && wordNumd.containsKey(1);
    }

    public boolean equalFrequency(String word) {
        int[] charCount = new int[26];
        for (char c : word.toCharArray()) {
            charCount[c - 'a']++;
        }
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int c : charCount) {
            if (c > 0) {
                freqCount.put(c, freqCount.getOrDefault(c, 0) + 1);
            }
        }
        for (int c : charCount) {
            if (c == 0) {
                continue;
            }
            freqCount.put(c, freqCount.get(c) - 1);
            if (freqCount.get(c) == 0) {
                freqCount.remove(c);
            }
            if (c - 1 > 0) {
                freqCount.put(c - 1, freqCount.getOrDefault(c - 1, 0) + 1);
            }
            if (freqCount.size() == 1) {
                return true;
            }
            if (c - 1 > 0) {
                freqCount.put(c - 1, freqCount.get(c - 1) - 1);
                if (freqCount.get(c - 1) == 0) {
                    freqCount.remove(c - 1);
                }
            }
            freqCount.put(c, freqCount.getOrDefault(c, 0) + 1);
        }
        return false;
    }
}
