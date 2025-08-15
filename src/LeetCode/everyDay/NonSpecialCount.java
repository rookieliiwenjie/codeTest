package LeetCode.everyDay;

import LeetCode.day06_2021_05_20.H2O;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NonSpecialCount {
    public static void main(String[] args) {
        NonSpecialCount nonSpecialCount = new NonSpecialCount();
        int i = nonSpecialCount.nonSpecialCount(4, 16);
        System.out.println(i);
    }

    HashMap<Integer, Boolean> hashMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public int nonSpecialCount(int l, int r) {
        int noSpecialCount = 0;
        for (int i = l; i <= r; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum++;
                }
                if (sum > 2) {
                    noSpecialCount++;
                    break;
                }
            }
            if (sum < 2) {
                noSpecialCount++;
            }
        }
        return noSpecialCount;
    }

    //埃氏筛
    public int nonSpecialCount3(int l, int r) {
        int n = (int) Math.sqrt(r);
        int[] arr = new int[n];
        int noSpecialCount = r - l + 1;
        for (int i = 2; i <= n; i++) {
            //gvty
        }
        return noSpecialCount;
    }

    public int nonSpecialCount2(int l, int r) {
        int noSpecialCount = r - l + 1;
        for (int i = r; i <= r; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum++;
                }
                if (sum > 2) {
                    noSpecialCount++;
                    break;
                }
            }
        }
        return noSpecialCount;
    }
}
