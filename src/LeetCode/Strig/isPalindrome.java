package LeetCode.Strig;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/30 8:14 下午
 * @Description:
 */
public class isPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toUpperCase();
        while (left <= right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuffer.append(s.charAt(i));
            }
        }
        StringBuffer reverse = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(reverse.toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("s = " + isPalindrome2( s));
    }
}
