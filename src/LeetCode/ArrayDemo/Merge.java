package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 9}, {8, 10}, {15, 18}};
        //int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int [][]intervals = {{1,4},{4,5}};
//
//        int[][] intervals = {{1, 4}, {0, 0}};
//        Merge merge = new Merge();
//        int[][] merge1 = merge.merge(intervals);
//        System.out.println(merge1);

        Merge merge = new Merge();
//        int[] A = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int B[] = {2, 5, 6};
//        int n = 3;
        int[] A = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int B[] = {1, 2, 3};
        int n = 3;
        merge.mergeList(A, m, B, n);
    }

    public void mergeList(int[] A, int m, int[] B, int n) {

        int alenght = A.length;
        int aStart = 0, bStart = 0;
        while (aStart < alenght && bStart < n) {
            if (A[aStart] > B[bStart]) {
                int aNum = A[aStart];
                for (int i = aStart + 1; i < alenght; i++) {
                    int aNuma = A[i];
                    A[i] = aNum;
                    aNum = aNuma;
                }
                A[aStart] = B[bStart];
                aStart++;
                bStart++;
            }else {
                aStart++;

            }
        }
        if (aStart >= alenght && bStart < n) {
            for (int i = m + bStart; i < alenght && bStart<n; i++, bStart++) {
                A[i] = B[bStart];
            }
        }
        System.out.println(A);
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 1;
        while (i < intervals.length) {
            if (end < intervals[i][0]) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            i++;
        }
        res.add(new int[]{start, end});
        int[][] newArr = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            newArr[j] = res.get(j);
        }
        return newArr;
    }
}
