package com.company.LaoHan.LeetCodeTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lwj32 on 2020/7/14.
 */
public class Offer {
    public static void main(String[] args) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        lists.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        lists.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        lists.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list4);
        System.out.println("minimumTotal(lists) = " + minimumTotal(lists));
    }
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        int x = 0;
        int repeat = 0;
        while (x<nums.length){
            if(!hashSet.add(nums[x])){
                repeat = nums[x];
                break;
            }
            x++;
        }
        return repeat;
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = triangle.get(0).get(0);
        for(int i = 1;i<triangle.size();i++){
            int secondeMin =triangle.get(i).get(0);
            for (int j = 1; j <triangle.get(i).size() ; j++) {
               secondeMin = Math.min(secondeMin,triangle.get(i).get(j));
            }
            min=min+secondeMin;
        }
        return min;
    }
}
