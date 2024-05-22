package LeetCode.everyDay;

import java.util.*;

public class findWinners {

    public static void main(String[] args) {
        findWinners findWinners = new findWinners();
        int[][] matcher = {{1, 3},
                {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        findWinners.findWinners(matcher);
        findWinners.findWinners2(matcher);
    }

    /**
     * 1、至少一次比赛
     * 2、没有输过的和 输掉一次的
     *
     * @param matches
     * @return
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winners = new HashMap<>();
        HashMap<Integer, Integer> losers = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            winners.put(winner, winners.getOrDefault(winner, 0) + 1);
            losers.put(loser, losers.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> resl = new ArrayList<>();

        List<Integer> winnerAlayw = new ArrayList<>();
        for (Integer winner : winners.keySet()) {
            if (!losers.containsKey(winner)) {
                winnerAlayw.add(winner);
            }
        }
        Collections.sort(winnerAlayw);
        resl.add(winnerAlayw);
        List<Integer> loseOnce = new ArrayList<>();
        for (Integer loser : losers.keySet()) {
            if (losers.get(loser) == 1) {
                loseOnce.add(loser);
            }
        }
        Collections.sort(loseOnce);
        resl.add(loseOnce);

        return resl;
    }


    public List<List<Integer>> findWinners2(int[][] matches) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            freq.putIfAbsent(winner, 0);
            freq.put(loser, freq.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            //这里很精巧， 就是 使用 0 和1 去区分 失败和成功的数据
            int key = entry.getKey(), value = entry.getValue();
            if (value < 2) {
                ans.get(value).add(key);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
