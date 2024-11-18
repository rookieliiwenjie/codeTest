package LeetCode.everyDay;

import java.util.Arrays;

public class NumFriendRequests {


    /**
     * * @param ages
     * * @return
     * ages[y] <= 0.5 * ages[x] + 7
     * ages[y] > ages[x]
     * ages[y] > 100 && ages[x] < 100
     * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）
     * 发送好友请求：
     */
    public int numFriendRequests(int[] ages) {
        int count = 0;
        Arrays.sort(ages);
        int legnt = ages.length - 1;
        int right = legnt;
        int left = 0;
        int equals = 0;
        while (left < ages.length) {
            while (ages[left]==ages[right]){

            }
            if (left >= right) {
                left++;
                right = legnt;
                continue;
            }
            if (ages[left] == ages[right]) {
                count += 2;
                right--;
                continue;
            }
            if (ages[left] > ages[right]) {
                right = legnt;
                left++;
                continue;
            }
            if ((ages[right] > 100 && ages[left] < 100) || ages[left] <= 0.5 * ages[right] + 7) {
                right--;
                continue;
            }
            count++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        int arges[] = {16, 16};
        NumFriendRequests numFriendRequests = new NumFriendRequests();
        int i = numFriendRequests.numFriendRequests(arges);
        System.out.println(i);
    }
}
