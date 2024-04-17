package LeetCode.Strig;

public class OneEditAway {
    public static void main(String[] args) {
        String first = "pales";
        String second = "pal";
//        String first = "pale";
//        String second = "ple";
//        String first = "";
//        String second = "a";
        System.out.println("args = " + oneEditAway(first, second));
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }

        int firstNum = 0;
        int sendNum = 0;
        int firstLenght = first.length();
        int secondLength = second.length();
        boolean flag = false;
        if(Math.abs(firstLenght-secondLength)>1){
            return false;
        }
        while (firstNum < firstLenght && sendNum < secondLength) {
            if (first.charAt(firstNum) != second.charAt(sendNum)) {
                if (flag) {
                    return false;
                }
                flag = true;
                if (secondLength - firstLenght == 1) {
                    sendNum++;
                } else if (firstLenght == secondLength) {
                    firstNum++;
                    sendNum++;
                } else if (firstLenght - secondLength == 1) {
                    firstNum++;
                }
            } else {
                firstNum++;
                sendNum++;
            }
        }
        return (flag && sendNum == secondLength && firstLenght == firstNum) || !flag;
    }

//    public boolean oneEditAway2(String first, String second) {
//        char[] charArray = first.toCharArray();
//        char[] charArray1 = second.toCharArray();
//        Arrays.sort(charArray);
//        Arrays.sort(charArray1);
//        int firstLenght = first.length() - 1;
//        int secondLength = second.length() - 1;
//        while (firstLenght <= 0 || secondLength <= 0) {
//            if (firstLenght) {
//
//            }
//        }
//    }



    public boolean oneEditAway2(String first, String second) {
        int m = first.length(), n = second.length();
        if (n - m == 1) {
            return oneInsert(first, second);
        } else if (m - n == 1) {
            return oneInsert(second, first);
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean oneInsert(String shorter, String longer) {
        int length1 = shorter.length(), length2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            if (index2 - index1 > 1) {
                return false;
            }
        }
        return true;
    }
}
