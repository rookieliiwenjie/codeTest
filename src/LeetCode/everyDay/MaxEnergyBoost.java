package LeetCode.everyDay;

public class MaxEnergyBoost {
    public static void main(String[] args) {
        MaxEnergyBoost maxEnergyBoost = new MaxEnergyBoost();
        // int energyDrinkA[] = { 1, 3, 1 };
        // int energyDrinkB[] = { 3, 1, 1 };
        // int energyDrinkA[] = { 4, 1, 1 };
        // int energyDrinkB[] = { 1, 1, 3 };
        int energyDrinkA[] = { 3, 3, 3 };
        int energyDrinkB[] = { 3, 4, 6 };
        long l = maxEnergyBoost.maxEnergyBoost(energyDrinkA, energyDrinkB);
        System.out.println(l);
    }

    public long maxEnergyBoost(int energyDrinkA[], int[] energyDrinkB) {

        long maxEnergy = 0L;
        int energyLenght = energyDrinkA.length;
        int flag = 0;
        // 0是a 如果是b就是1
        int i = 0;
        while (i < energyLenght) {
            int mid = i + 1;
            int right = i + 2;
            if (right < energyLenght && mid < energyLenght) {
                if ((energyDrinkA[i] + energyDrinkA[mid] + energyDrinkA[right]) < (energyDrinkA[i]
                        + energyDrinkB[right])) {
                    i = right;
                    maxEnergy += energyDrinkA[i] + energyDrinkB[right];
                    continue;
                }
                if ((energyDrinkB[i] + energyDrinkB[mid] + energyDrinkB[right]) < (energyDrinkB[i]
                        + energyDrinkA[right])) {
                    i = right;
                    maxEnergy += energyDrinkB[i] + energyDrinkA[right];
                    continue;
                }
            }
            if (flag == 0) {
                maxEnergy += energyDrinkA[i];
            } else {
                maxEnergy += energyDrinkB[i];
            }
            i++;
        }
        return maxEnergy;
    }
}
