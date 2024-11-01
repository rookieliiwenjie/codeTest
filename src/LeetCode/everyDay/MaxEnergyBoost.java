package LeetCode.everyDay;

public class MaxEnergyBoost {
    public static void main(String[] args) {

    }

    public long maxEnergyBoost(int energyDrinkA[], int[] energyDrinkB) {

        long maxEnergy = 0L;
        int energyLenght = energyDrinkA.length;
        // 0是a 如果是b就是1
        int flag = 0;
        int i = 0;
        while (i < energyLenght) {
            int mid = i + 1;
            int right = i + 2;
            if (energyDrinkA[i] + energyDrinkA[mid] < energyDrinkB[right]) {
                
            }
            if (index < energyLenght) {

            }
            i++;
        }
        return maxEnergy;
    }
}
