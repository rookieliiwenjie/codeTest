package LeetCode.everyDay;

public class LargestGoodInteger {
    public static void main(String[] args) {

    }

    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (!res.equals("")) {
                    char c = res.charAt(0);
                    char c1 = num.charAt(i);
                    if (c1 > c) {
                        res = num.substring(i, i + 3);
                    }
                    continue;
                }
                res = num.substring(i, i + 3);
            }
        }
        return res;
    }

    public String largestGoodInteger2(String num) {
        String res = "";
        int matchNum = 2;
        int lengt = num.length() - matchNum;
        for (int i = 0; i < lengt; i++) {
            int whileNUm = 1;
            int currIndex = num.charAt(i);
            boolean flag = true;
            while (whileNUm <= matchNum) {
                if (currIndex != num.charAt(i + whileNUm)) {
                    flag = false;
                    break;
                }
                whileNUm++;
            }
            if (flag) {
                if (!res.equals("")) {
                    char c = res.charAt(0);
                    char c1 = num.charAt(i);
                    if (c1 > c) {
                        res = num.substring(i, i + 3);
                    }
                    continue;
                }
                res = num.substring(i, i + 3);
            }
        }
        return res;
    }
}
