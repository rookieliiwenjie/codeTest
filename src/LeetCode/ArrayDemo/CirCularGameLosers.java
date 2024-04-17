package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

public class CirCularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        int arr[] = new int[n];
        int sum = 0;
        int count = 1;
        int arrI = 0;
        while (arr[arrI] == 0) {
            arr[arrI] = 1;
            sum += count * k;
            arrI = (sum % n);
            count++;
        }
        List<Integer> arra = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arra.add(i+1);
            }
        }
        int newArr[] = new int[arra.size()];
        for (int i = 0; i < arra.size(); i++) {
            newArr[i] = arra.get(i);
        }
        return newArr;
    }
    public int[] circularGameLosers2(int n, int k) {
        boolean[] visit = new boolean[n];
        for (int i = k, j = 0; !visit[j]; i += k) {
            visit[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                list.add(i + 1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] ints = new CirCularGameLosers().circularGameLosers(5, 2);
        int[] ints = new CirCularGameLosers().circularGameLosers(4, 4);
        System.out.println(ints);
    }
}
