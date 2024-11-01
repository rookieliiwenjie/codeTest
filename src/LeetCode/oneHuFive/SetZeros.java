package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetZeros {
    public static void main(String[] args) {
//        int[][] matrix =
//                {{0, 1, 2, 1},
//                        {3, 4, 5, 2},
//                        {1, 3, 1, 5}};
        int[][] matrix =
                {{0},{1}};
        SetZeros setZeros = new SetZeros();
        //  setZeros.setZeroes(matrix);
        setZeros.setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    /**
     * 比较low的版本
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
//        Set<Integer> listm = new HashSet<>();
//        Set<Integer> listn = new HashSet<>();
        boolean[] listm = new boolean[matrix.length];
        boolean[] listn = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    listm[i] = true;
                    listn[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (listn[j] || listm[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 两种标记法
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        //处理第一行 第一列是否有0
        boolean mFlag = false;
        boolean nFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nFlag = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                mFlag = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (mFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (nFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
