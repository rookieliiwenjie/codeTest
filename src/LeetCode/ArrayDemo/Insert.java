package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};
//        int intervals[][]={{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int newInterval[] = {4,8};

//        int intervals[][]={{1,5}};
////        int newInterval[] = {2,3};
//        int newInterval[] = {2,7};

//        int intervals[][] = {{1, 5}};
//        int newInterval[] = {6, 8};
//        int intervals[][] = {{1, 5}};
//        int newInterval[] = {0, 0};
        int intervals[][] = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int newInterval[] = {4, 8};
        Insert insert = new Insert();
        int[][] res = insert.insert2(intervals, newInterval);
        System.out.println(res);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        boolean flag = false;
        while (i < intervals.length) {
            int[] arr = intervals[i];
            if ((start > arr[1]) || flag) {
                res.add(arr);
                i++;
            } else {
                int newStart = -1;
                int newEnd = -1;
                while (i < intervals.length) {
                    int[] arrW = intervals[i];
                    if (end < arrW[0]) {
                        if (newStart == -1) {
                            res.add(newInterval);
                        } else {
                            res.add(new int[]{newStart, newEnd});
                        }
                        flag = true;
                        res.add(arrW);
                        i++;
                        break;
                    }
                    if (arrW[0] >= start) {
                        if (newStart == -1) {
                            newStart = start;
                        }
                        if (end <= arrW[1]) {
                            res.add(new int[]{newStart, arrW[1]});
                            i++;
                            flag = true;
                            break;
                        } else {
                            newEnd = end;
                        }
                    } else {
                        if (newStart == -1) {
                            newStart = arrW[0];
                        }
                        if (end < arrW[1]) {
                            res.add(new int[]{newStart, arrW[1]});
                            i++;
                            flag = true;
                            break;
                        } else {
                            newEnd = end;
                        }
                    }
                    i++;
                }
                if (!flag && newStart != -1) {
                    res.add(new int[]{newStart, newEnd});
                    flag = true;
                }
            }
        }
        if (!flag) {
            res.add(newInterval);
        }
        int[][] resArr = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            resArr[j] = res.get(j);
        }
        return resArr;

    }

    public int[][] insert3(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        boolean flag = false;
        while (i < intervals.length) {
            if ((start > intervals[i][1])) {
                res.add(intervals[i]);
                i++;
            } else {
                while (i < intervals.length) {
                    if (end < intervals[i][0]) {
                        if(!flag){
                            res.add(new int[]{start,end});
                            flag = true;
                        }
                        res.add(intervals[i]);
                        i++;
                        break;
                    } else {
                        start = Math.min(start, intervals[i][0]);
                        end = Math.max(end, intervals[i][1]);
                    }
                    i++;
                }
            }
        }
        if (!flag) {
            res.add(new int[]{start,end});
        }
        int[][] resArr = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            resArr[j] = res.get(j);
        }
        return resArr;

    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean flag = false;
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < start) {
                res.add(intervals[i]);
            } else if (intervals[i][0] > end) {
                if (!flag) {
                    res.add(new int[]{start, end});
                    flag = true;
                }
                res.add(intervals[i]);
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            i++;
        }
        if (!flag) {
            res.add(new int[]{start, end});
        }
        int[][] resArr = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            resArr[j] = res.get(j);
        }
        return resArr;
    }

}
