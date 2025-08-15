package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MyCalendar {
    /**
     * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
     * <p>
     * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
     * <p>
     * 日程可以用一对整数 startTime 和 endTime 表示，这里的时间是半开区间，即 [startTime, endTime),
     * 实数 x 的范围为，  startTime <= x < endTime 。
     * <p>
     * 实现 MyCalendar 类：
     * <p>
     * MyCalendar() 初始化日历对象。
     * boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致重复预订，
     * 返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：
     * ["MyCalendar", "book", "book", "book"]
     * [[], [10, 20], [15, 25], [20, 30]]
     * 输出：
     * [null, true, false, true]
     */
    public MyCalendar() {

    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        //[[],[37,50],[33,50],[4,17],[35,48],[8,25]]
//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(15, 25));
//        System.out.println(myCalendar.book(20, 30));
        System.out.println(myCalendar.book(37, 50));
        System.out.println(myCalendar.book(33, 50));
        System.out.println(myCalendar.book(4, 17));
        System.out.println(myCalendar.book(35, 48));
        System.out.println(myCalendar.book(8, 25));

    }

    List<int[]> books = new ArrayList<>();

    public boolean book(int startTime, int endTime) {
        if (books.isEmpty()) {
            books.add(new int[]{startTime, endTime});
            return true;
        }
        boolean res = true;
        for (int[] book : books) {
            if ((startTime >= book[0] && endTime <= book[1]) || (startTime < book[1] && startTime >= book[0]) ||
                    (endTime > book[0] && endTime < book[1])) {
                return false;
            }
            if (book[0] >= startTime && endTime > book[1]) {
                return false;
            }
            if (startTime < book[0] && endTime >= book[1]) {
                return false;
            }
        }
        if (res) {
            books.add(new int[]{startTime, endTime});
        }
        return res;
    }


    public boolean book2(int startTime, int endTime) {
        if (books.isEmpty()) {
            books.add(new int[]{startTime, endTime});
            return true;
        }
        for (int[] book : books) {
            if (startTime < book[1] && endTime > book[0]) {
                return false;
            }
        }
        books.add(new int[]{startTime, endTime});
        return true;
    }

    TreeSet<int[]> bookSet = new TreeSet<>((a, b) -> a[0] - b[0]);

    //map方法
    public boolean book3(int startTime, int endTime) {
        if (books.isEmpty()) {
            books.add(new int[]{startTime, endTime});
            return true;
        }
        int[] temp = {endTime, 0};
        int arr[] = bookSet.ceiling(temp);
        int pre[] = arr == null ? bookSet.last() : bookSet.lower(arr);
        if (arr==bookSet.first() || bookSet.lower(temp)[1]<=startTime){
            bookSet.add(new int[]{startTime, endTime});
            return true;
        }
        return false;
    }
}
