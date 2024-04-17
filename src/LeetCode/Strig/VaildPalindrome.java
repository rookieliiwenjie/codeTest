package LeetCode.Strig;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/30 8:42 下午
 * @Description:
 */
public class VaildPalindrome {
    public static void main(String[] args) {
        System.out.println("args = " + validPalindrome("abcad"));
    }

    /**
     * 贪心算法，就当他是可以回文字符串。
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return valid(s, left, right - 1) || valid(s, left + 1, right);
                //在这里有一个问题，我这个时候应该移动谁
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean valid(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
                //在这里有一个问题，我这个时候应该移动谁
            }
            left++;
            right--;
        }
        return true;
    }
}
