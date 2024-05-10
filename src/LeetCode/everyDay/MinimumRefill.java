package LeetCode.everyDay;

public class MinimumRefill {
    public static void main(String[] args) {
        MinimumRefill minimumRefill = new MinimumRefill();
//        int plants[] = {2, 2, 3, 3};
//        int capaA = 3;
//        int B = 4;
        int plants[] = {5};
        int capaA = 10;
        int B = 8;
        System.out.println(5/2);
        int i = minimumRefill.minimumRefill(plants, capaA, B);
        System.out.println(i);
    }

    /**
     * @param plants
     * @param capacityA
     * @param capacityB
     * @return
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;
        int capaA = capacityA;
        int capaB = capacityB;
        int minSum = 0;
        while (left < right) {
            if (capacityA < plants[left] || capacityB < plants[right]) {
                if (capacityA < plants[left]) {
                    capacityA = capaA;
                    minSum++;
                }
                if (capacityB < plants[right]) {
                    capacityB = capaB;
                    minSum++;
                }
                continue;
            }
            capacityA -= plants[left];
            capacityB -= plants[right];
            left++;
            right--;
        }
        if (plants.length % 2 != 0) {
            int index = (plants.length / 2);
            if (capacityA >= capacityB) {
                minSum += plants[index] > capacityA ? 1 : 0;
            } else {
                minSum += plants[index] > capacityB ? 1 : 0;
            }
        }
        return minSum;
    }
}
