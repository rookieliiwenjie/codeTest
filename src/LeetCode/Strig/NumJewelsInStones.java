package LeetCode.Strig;

import java.util.HashSet;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String jew = "aab";
        String stones = "aaBBbBDCCEb";
        numJewelsInStones2(jew,stones);
    }
    public static int numJewelsInStones2(String jewels, String stones) {
        // 把 jewels 转换成字符集合 mask
        long mask = 0;
        for (char c : jewels.toCharArray())
            mask = mask | (1L << (c & 63));
        // 统计有多少 stones[i] 在集合 mask 中
        int ans = 0;
        for (char c : stones.toCharArray())
            ans += mask >> (c & 63) & 1;
        return ans;
    }
}
