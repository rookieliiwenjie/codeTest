package LeetCode.ArrayDemo;

import java.util.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/23 9:49 上午
 * @Description: 标签影响
 */
public class LargestValsFromLables {
    public static void main(String[] args) {
//        int[] vlua = {5, 4, 3, 2, 1};
//        int[] lable = {1, 1, 2, 2, 3};
//        int num = 3;
//        int uss = 1;
//        int[] vlua = {5, 4, 3, 2, 1};
//        int[] lable = {1, 3, 3, 3, 2};
//        int num = 3;
//        int uss = 2;
//        int[] vlua = {2, 6, 1, 2, 6};
//        int[] lable = {2, 2, 2, 1, 1};
//        int num = 1;
//        int uss = 1;
        int[] vlua = {2, 6, 3, 6, 5};
        int[] lable = {1, 1, 2, 1, 1};
        int num = 3;
        int uss = 1;

        System.out.println("largestValsFromLables2(vlua,l) = " + largestValsFromLabels(vlua, lable, num, uss));
    }

    public static int largestValsFromLables2(int[] values, int[] labels, int numWanted, int useLimit) {
        //记录标签数量
        int n = values.length;
        int[][] newValueAndLable = new int[n][2];
        for (int i = 0; i < n; i++) {
            newValueAndLable[i][0] = values[i];
            newValueAndLable[i][1] = labels[i];
        }
        int arr[] = newValueAndLable[0];
        int arr1[] = newValueAndLable[2];
        Arrays.sort(newValueAndLable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int choose = 0;
        int sum = 0;
        HashMap<Integer, Integer> chooseHash = new HashMap<>();
        for (int j = 0; j < n && choose < numWanted; j++) {
            int label = newValueAndLable[j][1];
            if (chooseHash.getOrDefault(label, 0) >= useLimit) {
                continue;
            }
            choose++;
            chooseHash.put(label, chooseHash.getOrDefault(label, 0) + 1);
            sum += newValueAndLable[j][0];
        }
        return sum;
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        //排序后的索引
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        //秒不可言呀
        Arrays.sort(id, (a, b) -> values[b] - values[a]);
        int ans = 0, choose = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < n && choose < numWanted; ++i) {
            int label = labels[id[i]];
            if (cnt.getOrDefault(label, 0) == useLimit) {
                continue;
            }
            ++choose;
            ans += values[id[i]];
            cnt.put(label, cnt.getOrDefault(label, 0) + 1);
        }
        return ans;
    }

    /**
     * @param values    值
     * @param labels    标签
     * @param numWanted 子集长度
     * @param useLimit  标签相同的数量
     *                  <p>
     *                  1、如何高效算出
     * @return
     */
    public static int largestValsFromLables(int[] values, int[] labels, int numWanted, int useLimit) {
        //记录标签数量
        HashMap<Integer, Integer> lableNum = new HashMap<>(numWanted);
        int[][] arr = new int[numWanted][useLimit];
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            int key = labels[i];
            if (size < numWanted && (lableNum.get(key) == null || lableNum.get(key) < useLimit)) {
                arr[size][0] = value;
                arr[size][1] = i;
                size++;
                lableNum.put(key, lableNum.getOrDefault(key, 0) + 1);
            } else {
                int min = value;
                for (int j = 0; j <= size; j++) {
                    if (arr[j][0] < value) {
                        min = arr[j][0];
                    }
                }
            }
        }
        int sum = 0;
        return sum;
    }


}
