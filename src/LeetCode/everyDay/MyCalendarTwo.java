package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    public MyCalendarTwo() {
        books = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    //记录每组数据
    List<int[]> books;
    //两两相交的数据
    List<int[]> overlaps;

    /**
     * 直接遍历
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean book(int startTime, int endTime) {
        //如果第三次重合那么就返回false
        for (int[] overlap : overlaps) {
            int l = overlap[0], r = overlap[1];
            if (l < endTime && r > startTime) {
                return false;
            }
        }
        //判断是否有相交
        for (int[] book : books) {
            int l = book[0], r = book[1];
            if (l < endTime && r > startTime) {
                overlaps.add(new int[]{Math.max(l, startTime), Math.min(r, endTime)});
            }
        }
        books.add(new int[]{startTime, endTime});
        return true;
    }
}
