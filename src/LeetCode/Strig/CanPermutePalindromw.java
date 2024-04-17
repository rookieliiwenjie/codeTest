package LeetCode.Strig;

public class CanPermutePalindromw {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[122];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
