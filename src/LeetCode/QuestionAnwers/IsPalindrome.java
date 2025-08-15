package LeetCode.QuestionAnwers;

//回文数
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
    }

    /**
     * string 类型解题
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        StringBuilder s = new StringBuilder();
        s.append(x);
        s.reverse();
        return s.toString().equals(String.valueOf(x));

    }

    //数学解题
    public static boolean isPalindrome2(int x) {
        // if (x < 0 || (x != 0 && x % 10 == 0)) {
        if (x < 0 || (x >= 10 && x % 10 == 0)) {
            return false;
        }
        int i = 0;
        int n = x;
        while (i < n) {
            i = i * 10 + n % 10;
            n = n / 10;
        }
        return n == i || i / 10 == n;

    }

}
