package LeetCode.QuestionAnwers;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        int gas[] = {1, 2, 3, 4, 5};
        int cost[] = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;//总油量
        int nowTotal = 0;
        int n = gas.length;
        int curIndex = 0;
        int res = curIndex;
        while (curIndex < n) {
            int num = gas[curIndex] - cost[curIndex];
            total += num;
            nowTotal += num;
            if (nowTotal < 0) {
                res = curIndex + 1;
                nowTotal = 0;
            }
            curIndex++;
        }
        return total < 0 ? -1 : res;
    }
}
