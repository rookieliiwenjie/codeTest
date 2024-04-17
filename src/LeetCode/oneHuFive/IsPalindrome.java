package LeetCode.oneHuFive;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean aba = isPalindrome.isPalindrome("0P");
    }
    public boolean isPalindrome(String s) {
        String lowerCase = s.trim().toLowerCase();
        int left = 0;
        int right = lowerCase.length()-1;
        while (left<=right){
            char leftChar = lowerCase.charAt(left);
            char rightChar  = lowerCase.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)){
                right--;
                continue;
            }
            if (lowerCase.charAt(left)==lowerCase.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
