package LeetCode.ArrayDemo;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class FindMaxValueOfEquation {
    /**
     * y1+y2 + |x1-x2| x1<x2
     * -x1+y1 + y2+x2
     * -x1+y1 + y2+x2
     * <p>
     * [x1-x2]<=k
     * 1<2
     *
     * @param points
     * @param k
     * @return
     */
    public static void main(String[] args) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
//        priorityQueue.offer(12);
//        priorityQueue.offer(11);
//        priorityQueue.offer(14);
//        priorityQueue.offer(9);
//        while (!priorityQueue.isEmpty()) {
//            System.out.println(priorityQueue.poll());
//        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(12);
        arrayDeque.offer(11);
        arrayDeque.offer(14);
        arrayDeque.offer(9);
        while (!arrayDeque.isEmpty() ) {
            System.out.println(arrayDeque.pollFirst());
        }
//        for (int i = 0; i < 20; i++) {
//            while (!arrayDeque.isEmpty() && arrayDeque.peekFirst() < i) {
//                System.out.println(arrayDeque.pollFirst());
//            }
//            arrayDeque.offer(i);
//        }

    }

    /**
     * 最大堆
     *
     * @param points
     * @param k
     * @return
     */
    public static int findMaxValueOfEquation2(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < points.length; i++) {
            while (!priorityQueue.isEmpty() && Math.abs(priorityQueue.peek()[1] - points[i][0]) > k) {
                priorityQueue.poll();
            }
            if (!priorityQueue.isEmpty()) {
                max = Math.max(points[i][1] + points[i][0] - priorityQueue.peek()[0], max);
            }
            priorityQueue.offer(new int[]{points[i][0] - points[i][1], points[i][0]});

        }
        return max;
    }

    public static int findMaxValueOfEquation3(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        ArrayDeque<int[]> arrayQueue = new ArrayDeque<>();
        for (int i = 0; i < points.length; i++) {
            while (!arrayQueue.isEmpty() && Math.abs(arrayQueue.peekFirst()[0] - points[i][0]) > k) {
                arrayQueue.pollFirst();
            }
            if(!arrayQueue.isEmpty()){
                max = Math.max(max,points[i][1] + points[i][0] - arrayQueue.peek()[0]);

            }
            //3，4
            while (!arrayQueue.isEmpty() && arrayQueue.peekLast()[1] <= (points[i][1] - points[i][0])) {
                arrayQueue.pollLast();
            }
            arrayQueue.offer(new int[]{points[i][0], points[i][1] - points[i][0]});

        }
        return max;
    }

    /**
     * -x1+y1 + y2+x2
     *
     * @param points
     * @param k
     * @return
     */
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        int curronInext = 0;
        int choseIndex = 0;
        for (int i = 1; i < points.length; i++) {
            int[] arr = points[i];
            int[] curronArr = points[curronInext];
            if (choseIndex == 0) {
                if (Math.abs(curronArr[0] - arr[0]) <= 0) {
                    continue;
                }
                max = Math.max(curronArr[1] + arr[1] + Math.abs(curronArr[0] - arr[0]), max);
                choseIndex = i;
                continue;
            }
            if (Math.abs(curronArr[0] - arr[0]) > k) {
                curronInext++;
                while (curronInext < 1) {
//                    int arrCu = points.
//                            curronInext++;
                }
            }
            int[] choseArr = points[choseIndex];
            if (max < (curronArr[1] + arr[1] + Math.abs(curronArr[0] - arr[0]))) {
                max = curronArr[1] + arr[1] + Math.abs(curronArr[0] - arr[0]);
                choseIndex = i;
                continue;
            }
            if (curronArr[1] < arr[1]) {
                max = Math.max(curronArr[1] + arr[1] + Math.abs(curronArr[0] - arr[0]), max);
                curronInext = i;
            }
        }
        return max;
    }
}
