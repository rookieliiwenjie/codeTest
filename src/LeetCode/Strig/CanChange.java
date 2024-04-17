package LeetCode.Strig;

public class CanChange {

    public static boolean canChange(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        int length = start.length();
        int LIndext = -1;
        int LNum = 0;
        int RIndext = -1;
        int RNum = 0;
        for (int i = 0; i < length; i++) {
            if ('L' == start.charAt(i)) {
                LIndext = i;
                LNum++;
            } else if ('R' == start.charAt(i)) {
                if (RIndext == -1) {
                    RIndext = i;
                }
                RNum++;
            }
        }
        for (int i = 0; i < length; i++) {
            if ('L' == target.charAt(i)) {
                LNum--;
                if (i > LIndext) {
                    return false;
                }
            } else if ('R' == target.charAt(i)) {
                RNum--;
                if (i < RIndext) {
                    return false;
                }
            }
        }
        return RNum == 0 && LNum == 0;
    }

    public static void main(String[] args) {
//        String start = "R______L_";
//        String target = "RRR____LL";
        String start = "_L__R__R_";
        String target = "L______RR";
        boolean b = canChange2(start, target);
        System.out.println(b);
    }

    public static boolean canChange2(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        int length = start.length();
        int lNum = 0;
        int rNum = 0;
        for (int i = 0; i < length; i++) {
            if ('L' == target.charAt(i)) {
                if (rNum > 0) {
                    return false;
                }
                lNum++;
            } else if ('R' == target.charAt(i)) {
                if (rNum == 0) {
                    return false;
                }
                rNum--;
            }
            if ('L' == start.charAt(i)) {
                if (lNum == 0 || rNum > 0) {
                    return false;
                }
                lNum--;
            } else if ('R' == start.charAt(i)) {
                rNum++;
            }
        }
        return lNum == 0 && rNum == 0;
    }


    public boolean canChange3(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j++;
        }
        return true;
    }


}
