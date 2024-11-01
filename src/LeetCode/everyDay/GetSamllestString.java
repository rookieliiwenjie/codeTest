package LeetCode.everyDay;

import java.util.Arrays;

public class GetSamllestString {

    public static void main(String[] args) {
        GetSamllestString getSamllestString = new GetSamllestString();
        String s = "001";
        System.out.println(getSamllestString.getSamllestString(s));
    }
    public String getSamllestString(String s) {
        char[] sChars = s.toCharArray();
        int size = sChars.length;
        if (size <= 1) {
            return s;
        }
        for (int i = 1; i < size; i++) {
            int prev = sChars[i - 1] - '0';
            int curr = sChars[i] - '0';
            if ((prev % 2 == 0 && curr % 2 == 0) || (prev % 2 != 0 && curr % 2 != 0)) {
                if (prev > curr) {
                    char temp = sChars[i - 1];
                    sChars[i - 1] = sChars[i];
                    sChars[i] = temp;
                    break;
                }
            }
        }
        return new String(sChars);
    }

}
