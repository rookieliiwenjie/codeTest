package LeetCode.everyDay;

import java.util.Arrays;

public class MiniumuRounds {
    public static void main(String[] args) {
        MiniumuRounds miniumuRounds = new MiniumuRounds();
        int tasks[] = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
//        int tasks[] = {2, 3, 3};
//        int tasks[] = {66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67,
//                61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61};
        int i = miniumuRounds.minimumRounds(tasks);
        System.out.println(i);
    }

    /**
     * 排序
     *
     * @param tasks
     * @return
     */
    public int minimumRounds(int tasks[]) {
        Arrays.sort(tasks);
        int begin = tasks[0];
        int num = 1;
        int minNum = 0;
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i] == begin) {
                num++;
            } else {
                if (num > 1) {
                    minNum += num % 3 != 0 ? num / 3 + 1 : num / 3;
                    begin = tasks[i];
                    num = 1;
                } else {
                    return -1;
                }
            }
        }
        if (num > 1) {
            minNum += num % 3 != 0 ? num / 3 + 1 : num / 3;
        } else {
            return -1;
        }
        return minNum;
    }

    /**
     * hash
     *
     * @param tasks
     * @return
     */
    public int minimumRounds2(int tasks[]) {
        for (int task : tasks) {

        }
        int begin = tasks[0];
        int num = 1;
        int minNum = 0;
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i] == begin) {
                num++;
            } else {
                if (num > 1) {
                    minNum += num % 3 != 0 ? num / 3 + 1 : num / 3;
                    begin = tasks[i];
                    num = 1;
                } else {
                    return -1;
                }
            }
        }
        if (num > 1) {
            minNum += num % 3 != 0 ? num / 3 + 1 : num / 3;
        } else {
            return -1;
        }
        return minNum;
    }
}
