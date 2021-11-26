package com.company.LeetCode.ArrayDemo;

import com.company.SingleonDemo.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-06 17:06
 */
public class ThirdMax {
    public static void main(String[] args) {
        int nums[] = new int[]{2, 1};
        int i = thirdMax(nums);
        System.out.println("i = " + i);
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        TreeSet<Integer> hashSet = new TreeSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (hashSet.size() >= 3) {
                break;
            }
            hashSet.add(nums[i]);
        }
        return hashSet.size() == 3 ? hashSet.first() : hashSet.last();
    }
}
