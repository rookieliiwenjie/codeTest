package com.company.LaoHan.LeetCodeTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwj32 on 2020/7/7.
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int [] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int [] arr2 = {0,1,2,3,4};
       /* for (int i :
             dailyTemperatures(arr)) {
            System.out.println("dailyTemperatures() = " + i);

        }*/
            System.out.println(outQueue(10,17));
            List<Integer> l1 = new ArrayList<>();
            l1.add(2);
            l1.add(4);
            l1.add(3);
            List<Integer> l2 = new ArrayList<>();
            l2.add(5);
            l2.add(6);
            l2.add(4);
        for (int x:addTwoNumbers(l1,l2)
             ) {
            System.out.println("x = " + x);
        }

    }
    public static List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
        List<Integer> list = new ArrayList<>();
        int x = 0;
        for(int i = 0;i<l1.size();i++){
            int sum = l1.get(i)+l2.get(i);
            if(sum>=10){
                list.add(sum%10);
                x=1;
                continue;
            }
            list.add(sum+x);
            x=0;
            
        }
        return list;
    }
    public static int outQueue(int num,int k){
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<num;i++){
            arrayList.add(i);
        }
        int begin = 0;

        while (arrayList.size()>1){
             begin = (begin+k-1)%arrayList.size();
            arrayList.remove(begin);

        }
        return arrayList.get(0);
    }
   /* public static  int[] dailyTemperatures(int[] T) {
        int [] newarr = new int[T.length];
            int left = 0;
            int right=0;
            while (left!=T.length-2&&right!=T.length-1){
                if(T[left]<T[right]){
                    left++;
                    right=left+1;
                    newarr[left]=right-left;
                    continue;
                }
                if(T[right]<T[left]){
                    right++;
                }
                if(right==T.length-1){
                    left++;
                    right=left+1;
                    newarr[left]=0;
                    continue;
                }
                right++;
            }
            return newarr;
    }*/
}
