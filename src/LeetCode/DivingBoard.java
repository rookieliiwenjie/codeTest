package LeetCode;

import java.util.*;

public class DivingBoard {
    public static void main(String[] args) {
//        int shorter = 1;
//        int longer = 2;
//        int k = 3;
        int shorter = 1;
        int longer = 1;
        int k = 10000;
        divingBoard(shorter, longer, k);
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            list.add(shorter * i + (longer * (k - i)));
        }
        int[] array = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        return array;
    }

    public static int[] divingBoard2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int arr[] = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            arr[i] = shorter * (k - i) + longer * i;
        }
        return arr;
    }
}
