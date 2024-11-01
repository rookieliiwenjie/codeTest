package LeetCode.everyDay;

import com.company.Main;

public class DistanceTraveled {
    public static void main(String[] args) {
        DistanceTraveled distanceTraveled = new DistanceTraveled();
        distanceTraveled.distanceTraveled(1, 2);
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int maxTravel = 0;
        while (mainTank - 5 >= 0) {
            mainTank = mainTank - 5;
            if (additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
            maxTravel += 5 * 10;
        }
        maxTravel += mainTank * 10;
        return maxTravel;
    }

    /**
     * 数学方法
     *
     * @param mainTank
     * @param additionalTank
     * @return
     */
    public int distanceTraveled2(int mainTank, int additionalTank) {
        //公式 = mainTank - n*4 >= 5 = maintank -5 /4 = n
        return 10 * (mainTank + Math.max((mainTank - 1) / 4, additionalTank));
    }
}
