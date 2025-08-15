package LeetCode.everyDay;

public class CanAliceWin {

    public boolean canAliceWin(int[] nums) {
        int doubleNum = 0;
        int oneSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 10) {
                doubleNum += nums[i];
            } else {
                oneSum += nums[i];
            }
        }
        return doubleNum == oneSum ? false : true;
    }

}
