package LeetCode.ArrayDemo;

import java.util.*;
import java.util.stream.Collectors;

public class FindSwapvalues {
    /**
     * 数学方法解决问题
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        List<Integer> num = new ArrayList<>();
        int array1sum = Arrays.stream(array1).sum();
        int array2sum = 0;
        Set<Integer> array2List = new HashSet<>();
        for (int i = 0; i < array2.length; i++) {
            array2List.add(array2[i]);
            array2sum += array2[i];
        }
        for (int i = 0; i < array1.length; i++) {
            int arr = (array2sum - array1sum + 2 * array1[i]);
            if (array2List.contains(arr / 2) && arr % 2 == 0) {
                num.add(array1[i]);
                num.add(arr / 2);
            }
        }
        return num.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] findSwapValuesPlus(int[] array1, int[] array2) {
        List<Integer> num = new ArrayList<>();
        int array1sum = Arrays.stream(array1).sum();
        int array2sum = 0;
        Set<Integer> array2List = new HashSet<>();
        for (int i = 0; i < array2.length; i++) {
            array2List.add(array2[i]);
            array2sum += array2[i];
        }
        int diff = array2sum - array1sum;
        // 如果不是偶数差值，那么直接返回空数组
        if (diff % 2 != 0) return new int[]{};
        diff = diff / 2;
        for (int i = 0; i < array1.length; i++) {
            if (array2List.contains(diff + array1[i])) {
                num.add(array1[i]);
                num.add(diff + array1[i]);
            }
        }
        return num.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] findSwapValues3(int[] array1, int[] array2) {
        // 记录两个数组的和
        int sum1 = 0, sum2 = 0;
        // 记录 array2 中的数都出现过哪些
        Set<Integer> container = new HashSet<>();
        for (int num : array1) sum1 += num;
        for (int num : array2) {
            container.add(num);
            sum2 += num;
        }
        // 求两个数组之差
        int diff = sum1 - sum2;
        // 如果不是偶数差值，那么直接返回空数组
        if (diff % 2 != 0) return new int[]{};
        diff /= 2;
        // 从 array2 中找到能和 array1 中 num 配对的数，如果找到了就直接返回，没找到就返回空数组。
        for (int num : array1) if (container.contains(num - diff)) return new int[]{num, num - diff};
        return new int[]{};
    }

    //二分升级版本
    public int[] findSwapValues2(int[] array1, int[] array2) {
        List<Integer> num = new ArrayList<>();
        int array1sum = Arrays.stream(array1).sum();
        int array2sum = Arrays.stream(array2).sum();

        int dif = array1sum - array2sum;
        if (dif % 2 != 0) return new int[]{};
        dif = dif / 2;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int left = 0;
        int right = array1.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array1[mid] == dif) {
                num.add(array1[mid]);
                num.add(array1[mid]);
                break;
            } else if (array1[mid] < dif) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return num.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 排序+双指针
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] findSwapValues4(int[] array1, int[] array2) {
        int array1sum = Arrays.stream(array1).sum();
        int array2sum = Arrays.stream(array2).sum();
        int dif = array2sum - array1sum;
        if (dif % 2 != 0) return new int[]{};
        dif = dif / 2;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int array1Index = 0;
        int array2Index = 0;
        while (array1Index < array1.length && array2Index < array2.length) {
            if (array2[array2Index] - array1[array1Index] == dif) {
                return new int[]{array1[array1Index], array2[array2Index]};
            } else if ((array2[array2Index] - array1[array1Index]) < dif) {
                array2Index++;
            } else if ((array2[array2Index] - array1[array1Index]) > dif) {
                array1Index++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        FindSwapvalues findSwapvalues = new FindSwapvalues();
//        int[] array1 = {4, 1, 2, 1, 1, 2};
//        int[] array2 = {3, 6, 3, 3};
//        int[] array1 = {1, 2, 3};
//        int[] array2 = {4, 5, 6};


        int[] array1 = {4, 1, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        int[] result = findSwapvalues.findSwapValues4(array1, array2);
        System.out.println("The swap values are: " + result);
    }
}
