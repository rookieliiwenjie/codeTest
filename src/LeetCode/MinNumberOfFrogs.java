package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/6 10:07 上午
 * @Description:
 */
public class MinNumberOfFrogs {
    public static void main(String[] args) {
        int croakcroak = minNumberOfFrogs("croakcroak");
        System.out.println("croakcroak = " + croakcroak);
    }
    public static int minNumberOfFrogs2(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        int res = 0, frogNum = 0;
        int[] cnt = new int[4];
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
            put('k', 4);
        }};
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            int t = map.get(c);
            if (t == 0) {
                cnt[t]++;
                frogNum++;
                if (frogNum > res) {
                    res = frogNum;
                }
            } else {
                if (cnt[t - 1] == 0) {
                    return -1;
                }
                cnt[t - 1]--;
                if (t == 4) {
                    frogNum--;
                } else {
                    cnt[t]++;
                }
            }
        }
        if (frogNum > 0) {
            return -1;
        }
        return res;
    }
//    public static int minNumberOfFrogs(String croakOfFrogs) {
//        char[] arr = new char[]{'c', 'r', 'o', 'a', 'k'};
//        int min=0;
//        int index = 0;
//        for (int i = 0; i < croakOfFrogs.length(); i++) {
//          if(croakOfFrogs.charAt(i)==arr[0]){
//              index
//              if(index)
//          }
//        }
//        return min;
//    }
    public static int minNumberOfFrogs(String croakOfFrogs) {
        if(croakOfFrogs.length()%5!=0){
            return -1;
        }
        char[] arr = new char[4];
        int min=0;
        int index = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('c',0);
        hashMap.put('r',1);
        hashMap.put('o',2);
        hashMap.put('a',3);
        hashMap.put('k',4);
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            Character charC = croakOfFrogs.charAt(i);
            Integer charIndex =hashMap.get(charC);
            if (charIndex==0) {
                index++;
                arr[charIndex]++;
                if(index>min){
                   min = index;
               }
            }else {
                //如果前面一个没有了，说明不是有效的字符
                if(arr[charIndex-1]==0){
                    return -1;
                }
                //过了第一层判断，那么前面的字符可以删除了，因为已经算
                arr[charIndex-1]--;
                if (charIndex == 4) {
                    index--;
                } else {
                    //当前加1
                    arr[charIndex]++;
                }
            }
        }
        if(index>0){
            return -1;
        }
        return min;
    }
}
