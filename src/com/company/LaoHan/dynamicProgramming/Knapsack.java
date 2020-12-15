package com.company.LaoHan.dynamicProgramming;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lwj32 on 2020/7/16.
 */
public class Knapsack {
    public static void main(String args[]) {
        /*List<Things> things = new ArrayList<>();
        Things things1 = new Things();
        things1.setPrice(1500);
        things1.setWeight(1);
        things.add(things1);
        Things things2 = new Things();
        things2.setPrice(3000);
        things2.setWeight(2);
        things.add(things2);
        Things things3 = new Things();
        things3.setPrice(2000);
        things3.setWeight(3);
        things.add(things3);
        System.out.println("maxPrice = " + maxPrice(1, things));*/
        LocalDateTime nowTime= LocalDateTime.now();
        System.out.println("localTime = " + nowTime);
      /*  int [] nums = {1,2,3};
        System.out.println("subarraySum() = " + subarraySum(nums,3));*/
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int right = 0;
        int left = 0;
        int num = 0;
        while (left < nums.length) {
            if(right>nums.length-1){
                left++;
                right = left;
                num = 0;
                continue;
            }
            num += nums[right];
            if (num == k) {
                right++;
                count++;
            } else {
                right++;
            }



        }
        return count;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count ++;
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

    }
    private static int maxPrice(int bagSize, List<Things> things) {
        int max = 0;
        for (int i = 0; i < things.size(); i++) {
            //每一次的重量
            int weight = things.get(i).getWeight();
            //每一次的价值
            int eachMax = things.get(i).getPrice();

            for (int j = 0; j < things.size(); j++) {

                if (weight + things.get(j).getWeight() <= bagSize && i != j) {

                    if (max < eachMax + things.get(j).getPrice()) {
                        max = eachMax + things.get(j).getPrice();
                        weight += things.get(j).getWeight();
                    }

                }
                continue;
            }
        }
        return max;
    }

    private static int maxPrice2(int bagSize, int[][] arrThings) {
       /* int max = 0;
        int [][] arr = new int [arrThings.length*arrThings[0].length][arrThings.length*arrThings[0].length];
        int [][]
        return max;*/
        return 0;
    }


}
