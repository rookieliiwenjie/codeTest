package LeetCode.match;

public class IsMatch {

    public static void main(String[] args) {
        String s= "aa";
        System.out.println(isMatch(s,""));
    }
    public static boolean isMatch(String s, String p) {

//        int sIndex = 1;
//        int pIndex = 0;
//        char sPreChar = s.charAt(0);
//        while (sIndex < s.length()) {
//            if(pIndex==0 && ){}
//            char sChar = s.charAt(sIndex);
//            if (p.charAt(pIndex) == '.') {
//                sPreChar = s.charAt(sIndex);
//            }
//            if (p.charAt(pIndex) == '*') {
//                if (sPreChar == sChar) {
//                    sIndex++;
//                    continue;
//                } else {
//                    if (pIndex + 1 < p.length()) {
//                        if (p.charAt(pIndex + 1) == '.') {
//                            sIndex++;
//                            pIndex++;
//                            sPreChar = s.charAt(sIndex);
//                            continue;
//                        }
//                        return false;
//                    }
//                }
//            }
//            if (p.charAt(pIndex) != s.charAt(pIndex)) {
//                return false;
//            }
//            sPreChar = sChar;
//            sIndex++;
//        }
//        while (pIndex < p.length()) {
//            if (p.charAt(pIndex) != '*') {
//                return false;
//            }
//            pIndex++;
//        }
//        return true;
        return false;
    }


}
