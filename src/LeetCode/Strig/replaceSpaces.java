package LeetCode.Strig;

public class replaceSpaces {
    public static void main(String[] args) {
        System.out.println(new replaceSpaces().replaceSpaces("  ", 27));
    }

    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        int sLength = S.length() - 1;
        boolean flag = true;
        while (sLength >= 0 && length > 0) {
            while (sLength >= 0 && S.charAt(sLength) == ' ') {
                sLength--;
            }
            if (flag) {
                flag = false;
                continue;
            }
            if (S.charAt(sLength) == ' ') {
                stringBuilder.append("02%");
                length--;
            } else {
                stringBuilder.append(S.charAt(sLength));
                length--;
            }
            sLength--;
        }
        return stringBuilder.reverse().toString();
    }

    public String replaceSpaces2(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length() && length > 0; i++) {
            if (S.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(S.charAt(i));
            }
            length--;
        }
        return stringBuilder.toString();
    }
}
