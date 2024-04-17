package LeetCode.Strig;

public class CompressString {
    public static void main(String[] args) {
        //String s= "aabccccaaa";
        String s = "abbccd";
        System.out.println("args = " + compressString(s));
    }

    public static String compressString(String s) {
        if (s.length() <= 0) {
            return s;
        }
        char curron = s.charAt(0);
        int sum = 1;
        StringBuilder newS = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (curron == s.charAt(i)) {
                sum++;
            } else {
                newS.append(curron).append(sum);
                curron = s.charAt(i);
                sum = 1;
            }
        }
        newS.append(curron).append(sum);
        return newS.length() >= s.length() ? s : newS.toString();
    }
}
