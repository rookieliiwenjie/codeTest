package LeetCode.everyDay;

public class CountTestedDevices {

    public static void main(String[] args) {
        CountTestedDevices countTestedDevices = new CountTestedDevices();
        int arr[] = {1, 1, 2, 1, 3};
        countTestedDevices.countTestedDevices(arr);
    }

    /**
     * 查分算法
     * @param batteryPercentages
     * @return
     */
    public int countTestedDevices(int[] batteryPercentages) {
        int sum = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - sum > 0) {
                sum++;
            }
        }
        return sum;
    }
}
