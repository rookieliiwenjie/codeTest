package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetGoodIndices {

    public static void main(String[] args) {
        GetGoodIndices getGoodIndices = new GetGoodIndices();
//        int{}{} variables = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
//        int target = 2;
        int[][] variables = {{30, 5, 43, 2},
                {15, 50, 35, 41},
                {45, 34, 41, 32},
                {14, 37, 33, 13},
                {6, 8, 1, 53},
                {37, 1, 12, 52},
                {42, 37, 2, 52},
                {9, 2, 15, 3},
                {31, 12, 21, 24}, {52, 24, 6, 12}, {51, 35, 21, 52}, {30, 18, 10, 2}, {27, 31, 50, 27}, {29, 25, 26, 32}, {15, 38, 43, 17}, {22, 12, 16, 43}, {48, 9, 15, 6}, {41, 26, 22, 21}, {41, 49, 52, 26}, {53, 38, 9, 33}};
        int target = 1;
        List<Integer> goodIndices = getGoodIndices.getGoodIndices(variables, target);
        double v1 = Math.pow(31, 12) % 10;
        System.out.println(Math.pow(31, 12));
        System.out.println(v1);
        double v = Math.pow(v1, 21) % 24;
        System.out.println(v);

        System.out.println(goodIndices.toString());
    }

    public List<Integer> getGoodIndices2(int[][] variables, int target) {
        List<Integer> arrIndex = new ArrayList<>();
        int index = 0;
        for (int[] arr : variables) {
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            int m = arr[3];
            double v1 = Math.pow(a, b) % 10;
            double v = Math.pow(v1, c) % m;
            System.out.println(index + "--- " + v);
            if (v == target) {
                arrIndex.add(index);
            }
            index++;
        }
        return arrIndex;
    }
    //(a b % 10) c %m
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> arrIndex = new ArrayList<>();
        int index = 0;
        for (int[] arr : variables) {
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            int m = arr[3];
            int v1 = powMod(a, b) %10;
            int v = powMod(v1, c) % m;
            System.out.println(index + "--- " + v);
            if (v == target) {
                arrIndex.add(index);
            }
            index++;
        }
        return arrIndex;
    }
//    public int powMod(int x,int y){
//        int res = 1;
//        for(int i = 0; i < y; i++){
//            res = (res * x);
//        }
//        return res;
//    }

    public int powMod(int x,int y){
        int flag = x > 0 ? 1 : (y / 2 == 0 ? 1 : -1);
        int res = 1;
        if (x == 0 || y == 0) {
            return res;
        }
        int mod = 1;
        while (y > 1) {
            if (y % 2 == 1) {
                mod = mod * x;
            }
            x = x * x;
            y = y / 2;
        }
        return x * flag * mod;
    }
}
