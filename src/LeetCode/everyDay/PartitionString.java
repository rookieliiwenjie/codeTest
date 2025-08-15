package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {
    //预处理的回文数组
    boolean[][] dp;
    //
    List<List<String>> res;
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        String s= "aab";
        PartitionString partitionString = new PartitionString();
        List<List<String>> res = partitionString.partition(s);
        System.out.println(res);
    }
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
        backTrack(s, 0);
        return res;
    }

    public void backTrack(String s, int start) {
        if (start > s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backTrack(s, end + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
