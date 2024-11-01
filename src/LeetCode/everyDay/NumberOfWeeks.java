package LeetCode.everyDay;

import java.util.Arrays;

public class NumberOfWeeks {
    public static void main(String[] args) {
        NumberOfWeeks numberOfWeeks = new NumberOfWeeks();
//        int mil[] = {1, 2, 3};
       // int mil[] = {5, 2, 1};
//        int mil[] = {9,3,6,8,2,1}; //6 + 12

//        int mil[] = {1, 2, 3, 6, 8, 9}; //16+//
        int mil[] = {5, 5, 7, 7, 7, 9};//10+21+9//2,2,2,4 // 2,1,1,2
        //5,5,7,7,2 = 14
        //2,5,5,7,7 = 14
        //2,5,5 = 14+14=28
        //39 +1
        //10  9
        //17    16
        long l = numberOfWeeks.numberOfWeeks(mil);
        System.out.println(l);
    }

    ;

    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int right = milestones.length - 1;
        int left = right - 1;
        int maxWeek = 0;
        while (left >= 0 && right >= 0) {
            if (milestones[left] <= 0 || right == left) {
                left--;
                continue;
            }
            if (milestones[right] <= 0) {
                right--;
                continue;
            }
            if (milestones[left] > 0 && milestones[right] > 0) {
                milestones[left]--;
                milestones[right]--;
                maxWeek += 2;
            }
        }
        return (left >= 0 && milestones[left] > 0) || (right >= 0 && milestones[right] > 0) ? maxWeek + 1 : maxWeek;
    }

    public long numberOfWeeks2(int[] milestones) {
        Arrays.sort(milestones);
        int right = milestones.length - 1;
        int left = right - 1;
        int maxWeek = 0;
        while (left >= 0 && right >= 0) {
            if (milestones[left] <= 0 || right == left) {
                left--;
                continue;
            }
            if (milestones[right] <= 0) {
                right--;
                continue;
            }
            if (milestones[left] > 0 && milestones[right] > 0) {
                milestones[left]--;
                milestones[right]--;
                maxWeek += 2;
            }
        }
        return (left >= 0 && milestones[left] > 0) || (right >= 0 && milestones[right] > 0) ? maxWeek + 1 : maxWeek;
    }

}
