package LeetCode.Strig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * 是否互为字符串
 */
public class CheckPermutation {

    public static void main(String[] args) {
        BigDecimal num2 = new BigDecimal(997*0.31);
        BigDecimal num = new BigDecimal(997*0.31).setScale(0, RoundingMode.HALF_UP);
        System.out.println(num);
        System.out.println(num2);
        BigDecimal num3 = new BigDecimal(997).multiply(new BigDecimal(0.31)).setScale(0, RoundingMode.HALF_UP);
        BigDecimal num4 = new BigDecimal(997).multiply(new BigDecimal(0.31));
        System.out.println(num3);
        System.out.println(num4);

//        new BigDecimal(wareStockVOTmp.getNum() * wareStockVOTmp.getLockRatio() / 100);
//        BigDecimal result = num2.divide(num1,5,BigDecimal.ROUND_HALF_UP);
    }

    public static boolean CheckPermutation(String s1, String s2) {

        int arr[] = new int[24];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            arr[index]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            if (arr[index] == 0) {
                return false;
            }
            arr[index]--;
        }
        return true;
    }

    /**
     * 排序
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] charArray = s1.toCharArray();
        char[] charArray1 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray);
        return Arrays.equals(charArray, charArray1);
    }
}
