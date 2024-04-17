package LeetCode.Strig;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/17 1:58 下午
 * @Description:
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println("args = " + addStrings("0", "0"));
    }

    public static String addStrings(String num1, String num2) {
        int num1Lenght = num1.length() - 1;
        int num2Lenght = num2.length() - 1;
        int yushu = 0;
        StringBuilder returnNum = new StringBuilder();
        while (num1Lenght >= 0 || num2Lenght >= 0 || yushu!=0) {
            int num1Char = num1Lenght >= 0 ? num1.charAt(num1Lenght) - '0' : 0;
            int num2Char = num2Lenght >= 0 ? num2.charAt(num2Lenght) - '0' : 0;
            int num = (num1Char + num2Char + yushu) % 10;
            yushu = (num1Char + num2Char + yushu) / 10;
            returnNum.append(num);
            num1Lenght--;
            num2Lenght--;
        }
        return  returnNum.reverse().toString();
    }
}
