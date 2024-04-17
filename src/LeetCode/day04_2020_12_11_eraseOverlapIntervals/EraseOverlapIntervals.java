package LeetCode.day04_2020_12_11_eraseOverlapIntervals;

import java.util.Arrays;

/**
 * @Author rookie.li
 * @create 2020/12/11
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {

       /* int[][] nums = new int[][]{{1, 3}, {1, 2}, {4, 5}, {3, 7}};
        Arrays.sort(nums, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }*/
        int[][] arr = {

        };
        /*for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("arr[i][j] = " + arr[i][j]);
            }
        }*/
        int i = eraseOverlapIntervals(arr);
        System.out.println("i = " + i);


    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int num = 0;

        if (  intervals[0].length <= 0) {
            return num;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        //获取目前最小的前缀
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            //当后一个区间前面的值小于前一个区间后一个值说明一定重合了
            //如果不重合则将最小值设置为当前区间的后一个值
            if (intervals[i][0] < pre) {
                ++num;
            } else {
                pre = intervals[i][1];
            }
        }
        return num;
    }
}
