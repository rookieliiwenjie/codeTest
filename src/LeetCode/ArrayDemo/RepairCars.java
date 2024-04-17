package LeetCode.ArrayDemo;

import java.util.Arrays;

public class RepairCars {
    /**
     * r * n * n + (cars-r2)*n*n + (cars-r2-r1)*n*n
     * n为车数量
     *
     * @param ranks
     * @param cars
     * @return
     */
    public long repairCars(int[] ranks, int cars) {
        long sum = 0;
        Arrays.stream(ranks).sorted();
        return sum;

    }
}
