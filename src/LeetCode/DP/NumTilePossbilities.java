package LeetCode.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/19 9:41 上午
 * @Description:
 */
public class NumTilePossbilities {
    /**
     * 那种 反转的如何处理 打乱顺序 这个很妙 借助一个
     * 重复的除了hashmap还有没有其他方式。
     *
     * @param tiles
     * @return
     */
    public int numTilePoss(String tiles) {

        int max = tiles.length();
        HashMap<String, Integer> hashMap = new HashMap();
        for (int i = 0; i < tiles.length(); i++) {
            for (int j = 0; j < tiles.length(); j++) {

            }

        }
        return max;
    }

    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println("numTilePossibilities(tiles) = " + numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs(tiles.length(), count, tile) - 1;
    }

    private static int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs(i - 1, count, tile);
                //加回去
                count.put(t, count.get(t) + 1);
            }
        }
        return res;
    }
}
