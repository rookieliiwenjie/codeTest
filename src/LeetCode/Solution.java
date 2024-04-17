package LeetCode;

import java.util.*;

/**
 * @author lwj32
 * @date 2021/5/24
 */
public class Solution {
    static int[] numsNow;

    public Solution(int[] nums) {
        numsNow = nums;
    }

    Random rand = new Random();

    /**
     * Resets the array to its original configuration and return it.
     */
    public static void main(String[] args) {
        int[] nums = {0, -12893, 128384};
        Solution solution = new Solution(nums);
        int[] shuffle = solution.shuffle();
        System.out.println("shuffle");
        for (int i = 0; i < shuffle.length; i++) {
            System.out.println(" = " + shuffle[i]);
        }
        System.out.println("reset = ");
        int[] reset = solution.reset();
        for (int i = 0; i < reset.length; i++) {
            System.out.println(" = " + reset[i]);
        }
        int[] shuffle2 = solution.shuffle();
        System.out.println("shuffle");
        for (int i = 0; i < shuffle.length; i++) {
            System.out.println(" = " + shuffle2[i]);
        }
    }

    public int[] reset() {
        return numsNow;


    }
    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < numsNow.length; i++) {
            asList.add(numsNow[i]);
        }
        return asList;
    }


    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();
        int num [] = new int [numsNow.length];
        for (int i = 0; i < num.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            num[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return num;
    }

    public static void swapAt(int bi, int range, int nums[]) {
        int temp = numsNow[bi];
        nums[bi] = numsNow[range];
    }
}