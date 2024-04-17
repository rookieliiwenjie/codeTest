package LeetCode.ArrayDemo;

import java.util.*;

public class SmallestK {
    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        int arr[] = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        smallestK.smallestK(arr, k);
    }

    public int[] smallestK(int[] arr, int k) {
        int smallArr[] = new int[k];
        if (k == 0) {
            return smallArr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : arr) {
            if (priorityQueue.isEmpty() || priorityQueue.size() < 4) {
                priorityQueue.offer(num);
            } else {
                if (priorityQueue.peek() > num) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            smallArr[i] = priorityQueue.poll();
            i++;
        }
        return smallArr;
    }

    public int[] smallestK2(int[] arr, int k) {
        int smallArr[] = new int[k];
        if (k == 0) {
            return smallArr;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            smallArr[i] = arr[i];
        }
        return smallArr;
    }
}
