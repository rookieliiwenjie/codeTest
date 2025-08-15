package LeetCode.everyDay;

public class CountTexts {
    /**
     * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
     *
     *
     *
     * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，
     * i 是该字母在这个按键上所处的位置。
     *
     * 比方说，为了按出字母 's' ，
     * Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
     * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
     * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，
     * 反而收到了 按键的字符串信息 。
     *
     * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
     * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice
     * 总共可能发出多少种文字信息 。
     *
     * 由于答案可能很大，将它对 109 + 7 取余 后返回。
     * @param pressedKeys
     * @return
     */
    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts("22233"));

    }
    public int countTexts(String pressedKeys) {

        int n = pressedKeys.length();

        // dp[i] 表示处理到 pressedKeys[i-1] 时，可能的组合数
        long[] dp = new long[n + 1];
        dp[0] = 1;  // 空字符串只有一种方式

        int i = 0;
        while (i < n) {
            char digit = pressedKeys.charAt(i);
            int j = i;

            // 找到连续相同的数字出现的次数
            while (j < n && pressedKeys.charAt(j) == digit) {
                j++;
            }

            // 对应的字母的数量
            int numLetters = 0;
            switch (digit) {
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '8':
                    numLetters = 3;
                    break;
                case '7':
                case '9':
                    numLetters = 4;
                    break;
                default:
                    numLetters = 0;
                    break;
            }
            // 将连续相同的数字对 dp 状态进行转移
            int length = j - i;  // 连续数字的长度
            for (int k = 1; k <= length; k++) {
                dp[j] = (dp[j] + dp[i] * numLetters) % 1000000007;
            }

            // 更新 i 为 j
            i = j;
        }

        return (int) dp[n];
    }
}
