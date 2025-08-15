package LeetCode.everyDay;

import java.util.*;

public class RankTeams {
    /**
     * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，
     * 每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
     * 排名规则如下：
     * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况
     * ，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
     * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
     * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
     * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
     * 示例 1：
     * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
     * 输出："ACB"
     * 解释：
     * A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
     * B 队获得两票「排位第二」，三票「排位第三」。
     * C 队获得三票「排位第二」，两票「排位第三」。
     * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
     *
     * @param votes
     * @return
     */
    public String rankTeams(String[] votes) {
        if (votes.length <= 1) {
            return votes[0];
        }
        TreeMap<Character, int[]> rankMap = new TreeMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                if (rankMap.containsKey(vote.charAt(i))) {
                    int[] rank = rankMap.get(vote.charAt(i));
                    rank[i]++;
                } else {
                    int[] rank = new int[vote.length()];
                    rank[i] = 1;
                    rankMap.put(vote.charAt(i), rank);
                }

            }
        }
        String res = null;
        return res;
    }

    public static void main(String[] args) {
        RankTeams rankTeams = new RankTeams();
//        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String[] votes = {"WXYZ","XYZW"};
//        int num = 'O'-'A';
//        System.out.println(num);
//        int num2 = 'Z'-'A';
//        System.out.println(num2);
        System.out.println(rankTeams.rankTeams2(votes));
//        rankTeams.rankTeams2(votes);
        System.out.println(rankTeams.rankTeams2(votes));
    }

    public String rankTeams2(String[] votes) {
        if (votes.length <= 1) {
            return votes[0];
        }
        int rankNum = votes[0].length();
        int being = 0;
        StringBuilder res = new StringBuilder();
        int[][] arr = new int[26][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
        }
        while (being < rankNum) {
            if (res.length() >= rankNum) {
                return res.toString();
            }
            boolean flag = false;
            for (String vote : votes) {
                arr[vote.charAt(being) - 'A'][1]++;
                if (arr[vote.charAt(being) - 'A'][1] > rankNum / 2) {
                    res.append(vote.charAt(being));
                    being++;
                    flag = true;
                    break;
                }
            }
            if (flag){
                continue;
            }
            Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
            for (int i = 0; i < rankNum - 1; i++) {
                if (arr[i][1] != 0 && arr[i][1] > arr[i + 1][1]) {
                    int index = arr[i][0] + 41;
                    char Zimu = (char)index;
                    res.append(Zimu);
                } else if (arr[i][1]==arr[i+1][1]){
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = i;
                arr[i][1] = 0;
            }
            being++;
        }
        return res.toString();
    }

}
