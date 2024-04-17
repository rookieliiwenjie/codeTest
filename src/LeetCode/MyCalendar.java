package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/7 3:54 下午
 * @Description:
 */
public class MyCalendar {
    int start;
    int end;
    List<MyCalendar> myCalendars = new ArrayList<>();

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public MyCalendar() {

    }

    public MyCalendar(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean book(int start, int end) {
        if (myCalendars != null && myCalendars.size() > 0) {
            for (MyCalendar myCalendar : myCalendars) {
//                if ((start >= myCalendar.getStart() && start < myCalendar.getEnd())) {
//                    return false;
//                }
//                if ((start <= myCalendar.getStart() && end > myCalendar.getStart())) {
//                    return false;
//                }
//                if ((end > myCalendar.getStart() && end < myCalendar.getEnd())) {
//                    return false;
//                }
//
//                if ((end > myCalendar.getEnd() && start < myCalendar.getEnd())) {
//                    return false;
//                }
                //myCalendar.getStart()<end 一定
                if (myCalendar.getStart() < end && start < myCalendar.getEnd()) {
                    return false;
                }
            }
        }
        myCalendars.add(new MyCalendar(start, end));
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println("myCalendar = " + myCalendar.book(47, 50));
        System.out.println("myCalendar = " + myCalendar.book(33, 41));
        System.out.println("myCalendar = " + myCalendar.book(39, 45));
        System.out.println("myCalendar = " + myCalendar.book(33, 42));
        System.out.println("myCalendar = " + myCalendar.book(25, 32));
        System.out.println("myCalendar = " + myCalendar.book(26, 35));
        System.out.println("myCalendar = " + myCalendar.book(19, 25));
        System.out.println("myCalendar = " + myCalendar.book(3, 8));
        System.out.println("myCalendar = " + myCalendar.book(8, 13));
        System.out.println("myCalendar = " + myCalendar.book(18, 27));


//
//        System.out.println("myCalendar = " + myCalendar.book(37, 50));
//        System.out.println("myCalendar = " + myCalendar.book(33, 50));
//        System.out.println("myCalendar = " + myCalendar.book(4, 17));
//        System.out.println("myCalendar = " + myCalendar.book(35, 48));
//        System.out.println("myCalendar = " + myCalendar.book(8, 25));
    }
}
