package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/22 7:17 下午
 * @Description:
 */
public class FindMindifference {

    public static int findMinDifference(List<String> timePoints) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            for (int j = i + 1; j < timePoints.size(); j++) {
                min = Math.min(min, getde(timePoints.get(i), timePoints.get(j)));
            }
        }
        return min;

    }


    public static int findMinDifference2(List<String> timePoints) {
//        if (timePoints.size() > 24 * 60) {
//            return 0;
//        }
        int min = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int num = getTime(timePoints.get(i + 1)) - getTime(timePoints.get(i));
            min = Math.min(num, min);
        }
        int beginAndEnd = 24 * 60 - getTime(timePoints.get(timePoints.size() - 1)) + getTime(timePoints.get(0));
        return Math.min(min, beginAndEnd);
    }

    public static int findMinDifference4(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        int preTime = getTime(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int num = getTime(timePoints.get(i));
            min = Math.min(getTime(timePoints.get(i)) - preTime, min);
            preTime = num;
        }
        int beginAndEnd = 24 * 60 - getMinutes(timePoints.get(timePoints.size() - 1)) + getMinutes(timePoints.get(0));
        return Math.min(min, beginAndEnd);
    }

    public static int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

    /**
     * 1、环形如何处理这里是个问题呀
     * 2、是获取排序完再计算吗？
     *
     * @param time
     * @return
     */
    public static int getTime(String time) {
        return 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3, 5));
    }

    public int findMinDifference3(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < n; ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }


    public static int getde(String time, String time2) {
        //1计算 第一个数据
        int timeHour1 = Integer.parseInt(time.substring(0, 2));
        int time1Min = Integer.parseInt(time.substring(3, 5));
        int timeHour2 = Integer.parseInt(time2.substring(0, 2));
        int time2Min = Integer.parseInt(time2.substring(3, 5));
        int sum1 = 0;
        if (timeHour1 < timeHour2) {
            sum1 = (24 * 60 - (timeHour2 * 60 + time2Min)) + (timeHour1 * 60 + time1Min);

        } else {
            sum1 = (24 * 60 - (timeHour1 * 60 + time1Min)) + (timeHour2 * 60 + time2Min);
        }
        int sum2 = Math.abs((timeHour1 * 60 + time1Min) - (timeHour2 * 60 + time2Min));
        return Math.min(sum1, sum2);
    }


    public static void main(String[] args) {
//        int time = getde("23:59","00:00");
//
//        int time2 = getde("11:59","23:00");
        List<String> list = new ArrayList<>();
        list.add("01:39");
        list.add("10:26");
        list.add("21:43");
        int minDifference = findMinDifference2(list);
        System.out.println("time = " + minDifference);

    }
}
