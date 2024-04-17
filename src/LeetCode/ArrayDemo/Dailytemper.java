package LeetCode.ArrayDemo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 7:37 下午
 * @Description:
 */


public class Dailytemper {
    public static void main(String[] args) {
        int arr[] = {73, 100, 99, 78, 77, 79, 77, 73};
        dailyTem3(arr);
    }

    public static int[] dailyTem(int[] temperatures) {
//        int arr[][] = new int[temperatures.length][temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            arr[i][0] =
//                    arr[i][1] =
//        }
        return null;
    }

    public static int[] dailyTem2(int[] temperatures) {
//        Integer arr[] = new Integer[temperatures.length];
//        Arrays.sort(arr, (a, b) -> temperatures[b] - temperatures[a]);
//        int[] re = new int[temperatures.length];
        int n = temperatures.length;
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    re[i] = j - i;
                    break;
                }
            }
        }
        return re;
    }


    public static int[] dailyTem3(int[] temperatures) {
//        Integer arr[] = new Integer[temperatures.length];
//        Arrays.sort(arr, (a, b) -> temperatures[b] - temperatures[a]);
//        int[] re = new int[temperatures.length];
        int n = temperatures.length;
        //为何使用栈，因为使用栈有个好处那就是前进后出来，这样计算下标的时候一定是距离最近的。
        Deque<Integer> stack = new ArrayDeque<>();
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            int tem = temperatures[i];
            while (!stack.isEmpty() && tem > temperatures[stack.peek()]) {
                //这里很妙，因为删除栈顶以后，倒数第二个开始后补，那么倒数第二个和 当前做比较，同上开始计算对应下标差距天数
                Integer index = stack.pop();
                re[index] = i - index;
            }
            stack.push(i);
        }
        return re;
    }
}
