package LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/4
 */
public class AddBinary {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * <p>
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * <p>
     *  
     * <p>
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     * <p>
     * 提示：
     * <p>
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     */
    public static void main(String[] args) {
        System.out.println("addBinary2 = " + addBinary2("1010", "1011"));
        System.out.println("addBinary3 = " + addBinary3("1010", "1011"));
    }

    public static String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    public static String addBinary3(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = Math.max(a.length(), b.length());
        int yushu = 0;
        for (int i = 0; i < length; ++i) {
            yushu += i < a.length() ? (a.charAt(a.length() - 1 - i)) - '0' : 0;
            yushu += i < b.length() ? (b.charAt(b.length() - 1 - i)) - '0' : 0;
            stringBuilder.append(yushu % 2);
            yushu /= 2;
        }
        if (yushu > 0) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }

}
