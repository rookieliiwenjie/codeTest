package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCompleteDayPairs {
    public static void main(String[] args) {
        CountCompleteDayPairs c = new CountCompleteDayPairs();
        int hours[] = {12, 12, 30, 24, 24};
//        int hours[] = {72,48,24,3};
//        int hours[] = {24, 24};
        int i = c.countCompleteDayPairs2(hours);
        System.out.println(i);
    }

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        int low = 0;
        int fast = low + 1;
        int lenght = hours.length;
        if (lenght < 2) {
            return count;
        }
        while (low < lenght - 1) {
            if (fast >= lenght) {
                low++;
                fast = low + 1;
                continue;
            }
            if ((hours[low] + hours[fast]) % 24 == 0) {
                count++;
            }
            fast++;
        }
        return count;
    }

    public int countCompleteDayPairs2(int[] hours) {
        int count = 0;
        int lenght = hours.length;
        if (lenght < 2) {
            return count;
        }
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> euqualAndGreater = new ArrayList<Integer>();
        for (int i = 0; i < lenght; i++) {
            if (hours[i] % 24 == 0) {
                euqualAndGreater.add(hours[i]);
            } else {
                lessThan.add(hours[i]);
            }
        }
        if (euqualAndGreater.size() > 0) {
            count = ((euqualAndGreater.size() - 1) * euqualAndGreater.size()) / 2;
        }

        for (int i = 0; i < lessThan.size() - 1; i++) {
            for (int j = i + 1; j < lessThan.size(); j++) {
                if ((lessThan.get(j) + lessThan.get(i)) % 24 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countCompleteDayPairs3(int[] hours) {
        int count = 0;
        int length = hours.length;
        if (length < 2) {
            return count;
        }
        int[] modCount = new int[24];
        for (int hour : hours) {
            modCount[hour % 24]++;
        }
        //这里很厉害
        count += (modCount[0] * (modCount[0] - 1)) / 2;
        for (int i = 1; i < 12; i++) {
            //这没看懂
            count += modCount[i] * modCount[24 - i];
        }
        //当为12的时候的数据
        count += (modCount[12] * (modCount[12] - 1)) / 2;
        return count;
    }


    public long countCompleteDayPairs4(int[] hours) {
        long count = 0;
        int length = hours.length;
        if (length < 2) {
            return count;
        }
        long[] modCount = new long[24];
        for (int hour : hours) {
            modCount[hour % 24]++;
        }
        for (int i = 1; i < 12; i++) {
            count += modCount[i] * modCount[24 - i];
        }
        count += modCount[0] * (modCount[0] - 1) / 2;
        count += modCount[12] * (modCount[12] - 1) / 2;
        return count;
    }

    public long countCompleteDayPairs5(int[] hours) {
        long ans = 0;
        int[] cnt = new int[24];
        for (int hour : hours) {
            ans += cnt[(24 - hour % 24) % 24];
            cnt[hour % 24]++;
        }
        return ans;
    }
}
