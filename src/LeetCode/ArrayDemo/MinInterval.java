package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/18 11:05 上午
 * @Description:
 */
public class MinInterval {
    public static void main(String[] args) {
        int arr[][] = {{1, 4}, {3, 6}, {2, 4}, {4, 4}};
        int query[] = {2, 3, 4, 5};
        System.out.printf("min", minInterVal(arr, query));
    }

    public static int[] minInterVal(int[][] intervals, int[] queries) {
        Integer[] qindex = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qindex[i] = i;
        }
        Arrays.sort(qindex, (i,j)->queries[i]-queries[j]);
        Arrays.sort(intervals,(i,j)->i[0]-j[0]);
        int[] newArr = new int[queries.length];
        Arrays.fill(newArr, -1);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int i = 0;
        for (int index : qindex) {
            while (i < intervals.length && intervals[i][0] <= queries[index]) {
                priorityQueue.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] < queries[index]) {
                priorityQueue.poll();
            }
            if (!priorityQueue.isEmpty()) {
                newArr[index] = priorityQueue.peek()[0];
            }
        }
        return newArr;
    }

    public int[] minInterval2(int[][] intervals, int[] queries) {
        Integer[] qindex = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qindex[i] = i;
        }
        Arrays.sort(qindex, (i, j) -> queries[i] - queries[j]);
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int i = 0;
        for (int qi : qindex) {
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }
        }
        return res;
    }
}
