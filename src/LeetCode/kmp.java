package LeetCode;/*
package LeetCode;

*/
/**
 * Created by lwj32 on 2020/12/14.
 *//*

public class kmp {
    public static void main(String[] args) {

    }

    public static int[] nextArr(int arr[]) {

        int j = -1;
        int arrLenght = arr.length;
        int nextArr[] = new int[arrLenght];
        nextArr[0] = -1;
        for (int i = 1; i < arrLenght; ++i) {
            if (j == -1 || arr[i] == arr[j]) {
                j++;
                nextArr[i] = j;
            }else {
                j = nextArr[i];
            }
        }
    }
}
*/
