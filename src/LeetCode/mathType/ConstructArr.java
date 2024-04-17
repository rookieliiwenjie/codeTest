package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/17 3:22 下午
 * @Description:
 */
public class ConstructArr {
    public static void main(String[] args) {

    }

    public int[] constructArr(int[] a) {
        /**
         * 解题思路
         *  第一步
         *  arr[0] = 1
         *  arr[1] = arr[0] * a[0]
         *  arr[2] = arr[1] * a[1] = a[0] * a[1]
         *  arr[3] = arr[2] * a[2] = a[0] * a[1] * a[2];
         *
         *  第二步
         *  temp = 1;
         *  arr[3] = temp * arr[3]  temp = a[3] * temp
         *  arr[2] = temp * arr[2] = a[3] * a[1] * a[0] temp = a[3] * a[2]
         *  arr[1] = temp * arr[1] = a[3] * a[2] * a[0] temp = a[3]*a[2] * a[1]
         *  arr[0] = temp * arr[0] = a[3]*a[2] * a[1] * arr[0](1)   temp =  temp = a[3]*a[2] * a[1] * a[0]
         */
        if(a==null || a.length==0 ){
            return new int[0];
        }
        int[] arr = new int[a.length];
        arr[0] = 1;
        for (int i = 1; i < a.length; i++) {
            arr[i] = arr[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            arr[i] = arr[i] * temp;
            temp *= a[i];
        }
        return arr;

    }

    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
