package LeetCode.everyDay;

import javafx.util.Pair;

import java.util.*;

public class MaxProfitAssignment {
    public static void main(String[] args) {
        MaxProfitAssignment maxProfitAssignment = new MaxProfitAssignment();
//        int difficulty[] = {2, 4, 6, 8, 10};
//        int profit[] = {10, 20, 30, 40, 50};
//        int work[] = {4, 5, 6, 7};
        int difficulty[] = {68, 35, 52, 47, 86};
        int profit[] = {67, 17, 1, 81, 3};
        int work[] = {92, 10, 85, 84, 82};

//        int difficulty[] = {85,47, 57};
//        int profit[] = {24,66,99};
//        int work[] = {40,25,25};
        int i = maxProfitAssignment.maxProfitAssignment3(difficulty, profit, work);
        System.out.println(i);
    }

    /**
     * @param difficulty 工作难度
     * @param profit     i 工作的收益
     * @param worker     工人i的能力 智能完成小于等于work[i]的工作
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        //最大的工作难度
        int max = worker[worker.length - 1];
        int[][] arrDifficulty = new int[difficulty.length][2];
        for (int i = 0; i < profit.length; i++) {
            arrDifficulty[i][0] = difficulty[i];
            arrDifficulty[i][1] = i;
        }
        Arrays.sort(arrDifficulty, (a, b) -> Integer.compare(b[0], a[0]));
        int maxProfit = 0;
        for (int i = worker.length - 1; i >= 0; i--) {
            int diffCult = 0;
            while (diffCult < arrDifficulty.length) {
                if (worker[i] >= arrDifficulty[diffCult][0]) {
                    maxProfit += profit[arrDifficulty[diffCult][1]];
                    break;
                }
                diffCult++;
            }
        }
        return maxProfit;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int min = worker[0];
        int max = worker[worker.length - 1];
        int[][] diffclutDprofit = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            diffclutDprofit[i][0] = profit[i];
            diffclutDprofit[i][1] = i;
        }
        int[][] arrDprofit = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            arrDprofit[i][0] = profit[i];
            arrDprofit[i][1] = i;
        }
        Arrays.sort(arrDprofit, (a, b) -> Integer.compare(b[0], a[0]));
        int maxProfit = 0;
        for (int i = worker.length - 1; i >= 0; i--) {
            int diffCult = 0;
            while (diffCult < arrDprofit.length) {
                if (worker[i] >= difficulty[arrDprofit[diffCult][1]]) {
                    maxProfit += arrDprofit[diffCult][0];
                    break;
                }
                diffCult++;
            }
        }
        return maxProfit;
    }


    /**
     * 自己版本
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        int[][] arrDprofit = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            arrDprofit[i][0] = profit[i];
            arrDprofit[i][1] = difficulty[i];
        }
        Arrays.sort(arrDprofit, (a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(worker);
        int maxProfit = 0;
        for (int i = worker.length - 1; i >= 0; i--) {
            int diffCult = 0;
            while (diffCult < arrDprofit.length) {
                if (worker[i] >= arrDprofit[diffCult][1]) {
                    maxProfit += arrDprofit[diffCult][0];
                    break;
                }
                diffCult++;
            }
        }
        return maxProfit;
    }

    /**
     * 自己版本改进
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment320(int[] difficulty, int[] profit, int[] worker) {
        int profitLenght = profit.length;
        int[][] arrDprofit = new int[profitLenght][2];
        for (int i = 0; i < profitLenght; i++) {
            arrDprofit[i][0] = difficulty[i];
            arrDprofit[i][1] = profit[i];
        }
        //从小到大
        Arrays.sort(arrDprofit, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int maxProfit = 0;
        int diffCult = 0;
        int beast = 0;
        for (int work : worker) {
            // 返回最大的数据。且难度小于等于该工人的能力
            // 相当于每次获取当前工人能力下的最大收益 因为前面的都是小于等于当前工人能力的且是最大beast的数据
            while (diffCult < profitLenght && arrDprofit[diffCult][0] <= work) {
                beast = Math.max(beast, arrDprofit[diffCult][1]);
                diffCult++;
            }
            maxProfit += beast;
        }
        return maxProfit;
    }

    public int maxProfitAssignment5(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int ans = 0, j = 0, maxProfit = 0;
        for (int w : worker) {
            while (j < n && jobs[j][0] <= w) {
                maxProfit = Math.max(maxProfit, jobs[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;
    }

    /**
     * 排序+双指针
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment4(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, best = 0;
        for (int j = 0; j < N; ++j) {
            jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        }
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int w : worker) {
            // 第一个条件就是工作难度小于等于工人的能力
            //第二个条件就是工作的收益最大
            while (i < N && w >= jobs.get(i).getKey()) {
                best = Math.max(best, jobs.get(i).getValue());
                i++;
            }
            res += best;
        }
        return res;
    }


}
