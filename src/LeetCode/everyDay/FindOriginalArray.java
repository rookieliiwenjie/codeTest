package LeetCode.everyDay;

import java.util.Arrays;
import java.util.HashMap;

public class FindOriginalArray {
    public static void main(String[] args) {
//        int nums[] = {6, 2, 3, 4, 4, 8, 8, 1};
        //  int nums[] = {1, 3, 4, 2, 6, 8};
        int nums[] = {6, 3, 0, 1};
        int[] originalArray = findOriginalArray(nums);
        System.out.println(originalArray.toString());
    }

    public static int[] findOriginalArray(int changed[]) {
        int nullArr[] = new int[0];
        if (changed.length % 2 != 0) {
            return nullArr;
        }
        Arrays.sort(changed);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            hashMap.put(changed[i], hashMap.getOrDefault(changed[i], 0) + 1);
        }
        int num = 0;
        int newLenght = changed.length / 2;
        int[] origin = new int[newLenght];
        for (int i = 0; i < changed.length; i++) {
            if (hashMap.get(changed[i]) == 0) {
                continue;
            }
            hashMap.put(changed[i], hashMap.get(changed[i]) - 1);
            if (hashMap.getOrDefault(changed[i] * 2, 0) == 0) {
                return new int[0];
            }
            hashMap.put(changed[i] * 2, hashMap.get(changed[i] * 2) - 1);
            origin[num++] = changed[i];

        }
        return origin;

    }

    public static int[] findOriginalArray4(int changed[]) {
        int nullArr[] = new int[0];
        if (changed.length % 2 != 0) {
            return nullArr;
        }
        Arrays.sort(changed);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            hashMap.put(changed[i], hashMap.getOrDefault(changed[i], 0) + 1);
        }
        int num = 0;
        int[] origin = new int[changed.length / 2];
        for (int i = 0; i < changed.length && num < changed.length / 2; i++) {
            int i1 = changed[i] * 2;
            if (hashMap.containsKey(i1) && hashMap.get(i1) > 0) {
                hashMap.put(changed[i], hashMap.get(i1) - 1);
                origin[num] = changed[i];
                num++;
            }
        }
        return (num == (changed.length - 1)) ? origin : nullArr;

    }


    public static int[] findOriginalArray2(int changed[]) {
        int nullArr[] = new int[0];
        if (changed.length % 2 != 0) {
            return nullArr;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            hashMap.put(changed[i], hashMap.getOrDefault(changed[i], 0) + 1);
        }
        for (int i = 0; i >= 0; i--) {
            if (changed[i] % 2 == 0) {
                int i1 = changed[i] / 2;
                if (hashMap.containsKey(i1)) {
                    hashMap.put(changed[i], hashMap.get(changed[i]) - 1);
//                    hashMap.put(i1, hashMap.get(i1) - 1);
                }
            }
        }
        int[] origin = new int[changed.length / 2];
        return origin;
    }


    public static int[] findOriginalArray3(int changed[]) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            hashMap.put(changed[i], hashMap.getOrDefault(changed[i], 0) + 1);
        }
        int num = 0;
        int newLenght = changed.length / 2;
        int[] origin = new int[newLenght];
        for (int change : changed) {
            if (hashMap.get(change) == 0) {
                continue;
            }
            hashMap.put(change, hashMap.get(change) - 1);
            if (hashMap.getOrDefault(change * 2, 0) == 0) {
                return new int[0];
            }
            hashMap.put(change * 2, hashMap.get(change * 2) - 1);
            origin[num++] = change;
        }
        return origin;

    }
    //消消乐解法
}
