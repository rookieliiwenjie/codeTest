package LeetCode;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/7 5:12 下午
 * @Description:
 */
class MyCalendar2 {
    TreeSet<int[]> booked;

    public MyCalendar2() {
        booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        //返回最接近的一个数
        int[] arr = booked.ceiling(tmp);
        //last返回TreeSet中当前的最后一个（最高）元素。
        int[] prev = arr == null ? booked.last() : booked.lower(arr);//从集合中返回指定元素中最接近的最小元素，如果没有，则返回null。;
        //用于检索和删除最小（第一个）元素。
        if (arr == booked.first() || Objects.requireNonNull(booked.lower(tmp))[1] <= start) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
