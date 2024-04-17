package LeetCode.Strig;

public class IsUnique {
    public static void main(String[] args) {
        isUnique("abc");
    }

    public static boolean isUnique(String astr) {
        if (astr.length() > 26) {
            return false;
        }
        int arr[] = new int[26];
        for (int i = 0; i < astr.length(); i++) {

            int index = astr.charAt(i) - 'a';
            if (arr[index] > 0) {
                return false;
            }
            arr[index]++;
        }
        return true;
    }
}
