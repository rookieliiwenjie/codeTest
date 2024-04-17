package LeetCode;

import java.util.ArrayList;

/**
 * @Author rookie.li
 * @create 2020/10/30
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(3);
        arrayList.add(7);
        int x = 100>>1;
        System.out.println("x = " + x);

        //System.out.println("arrayList = " +  maxArea(arrayList));

    }

    public static int maxArea(ArrayList<Integer> hight) {
        int maxArea = 0;
        Object[] ints = hight.toArray();
        int left = 0;
        int right = ints.length - 1;
        while (left < right) {
            if ((int) left > (int) right) {
                right--;
            } else {
                left++;
            }
            int max = Math.min((Integer) ints[left], (Integer) ints[right]);
            maxArea = Math.max(maxArea, ((int)max * ((int)right - (int) left)));
        }
        return maxArea;

    }
}
