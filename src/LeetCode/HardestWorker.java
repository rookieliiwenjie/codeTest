package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 10:33 上午
 * @Description:
 */
public class HardestWorker {
    public static void main(String[] args) {
        int[][] logs = {{0, 3}, {2, 5},{0, 9},{1, 15}};
        int n = 26;
        System.out.println("hardestWorker(n, logs) = " + hardestWorker(n, logs));
    }

    public static int hardestWorker(int n, int[][] logs) {
        int maxWord =logs[0][1];
        int minId = logs[0][0];
        int preWord = maxWord;
        for (int j = 1; j < logs.length; j++) {
            int id = logs[j][0];
            int work = logs[j][1];
            if ((work - preWord) > maxWord) {
                minId = id;
                maxWord = (work - preWord);
            }
            if ((work - preWord) == maxWord && id < minId) {
                minId = id;
                maxWord = (work - preWord);
            }
            preWord = work;
        }
        return minId;
    }

    public int hardestWorker2(int n, int[][] logs) {
        int ans = logs[0][0], maxcost = logs[0][1];
        for (int i = 1; i < logs.length; ++i) {
            int idx = logs[i][0];
            int cost = logs[i][1] - logs[i - 1][1];
            if (cost > maxcost || (cost == maxcost && idx < ans)) {
                ans = idx;
                maxcost = cost;
            }
        }
        return ans;
    }
}
