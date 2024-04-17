package LeetCode;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-19 22:38
 */
public class MinSteps {
    public static void main(String[] args) {
       /* int i = minSteps(8);
        System.out.println("i = " + i);
        int x = 4;
        int y = 2;
        System.out.println("x%y = " + x % y);*/
        // lengthOfLastWord("Today is a nice day");
        char leetcode = firstUniqChar("leetcode");
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length <= 0) {
            return 0;
        }
        int min = numbers[0];
        for (int i = 1; i < numbers[i]; i++) {
            min = Math.min(min, numbers[i]);
        }
        return min;
    }

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * @param s
     * @return
     */

    public static char firstUniqChar(String s) {
       /* char x = ' ';
        if (s.isEmpty()) {
            return x;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!hashMap.containsKey(chars[i])) {
                hashMap.put(chars[i], 1);
            } else {
                hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
         if(hashMap.get(chars[i]) == 1){
             return chars[i];
         }
        }
        return x;*/
        int result = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            int i1 = s.indexOf(i);
            if (i1 != -1 && i1 == s.lastIndexOf(i)) {
                result = Math.min(result, i1);
            }
        }
        if (result == s.length()) {
            return ' ';
        }
        return s.charAt(result);

    }

    /**
     * 给你一个字符串 s，由若干单词组成，
     * 单词前后用一些空格字符隔开。
     * 返回字符串中最后一个单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        int maxLenget = 0;
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() > maxLenget) {
                return s1[i].length();
            }
        }
        return maxLenget;
    }

    /**
     * 缺少的代码就是如果是马上就可以了那么我们就不需要CopyAll而是直接Paste
     * 在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
     *
     * @param n
     * @return
     */
    public static int minSteps(int n) {
        int aNums = 1;
        if (n == aNums) {
            return 0;
        }
        int minSteps = 1;
        //目前的数量
        //目前Paste上面的数量
        int pa = 1;
        while (n > aNums) {
            //如果当前的复制的数量小于总的一半那么我们CapyAll一次
            //剩余数量
            int now = n - aNums;
            if (Math.ceil(n / 2) > pa && aNums != 1 && now % (aNums) == 0) {
                minSteps++;
                pa = aNums;
            }
            if (aNums == 1) {
                aNums = aNums + 1;
            } else {
                aNums = aNums + pa;
            }
            minSteps++;
        }
        return minSteps;

    }

}
