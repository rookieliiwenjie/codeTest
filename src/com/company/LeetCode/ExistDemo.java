package com.company.LeetCode;

import com.company.LeetCode.Tree.TreeNode;
import com.company.LeetCode.list.ListNode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/9 2:27 下午
 * @Description:
 */
public class ExistDemo {
    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return true;
    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int[] newArr = new int[m * n];
        int index = 0;
        int iIndex = 0;
        int jIndex = 0;
//        while ((m * n) >= index) {
//            for (int i = iIndex; i <= m; i++) {
//                for (int j = jIndex; j <= n; j++) {
//                    newArr[index] = matrix[i][j];
//                    index++;
//                    if (i == m) {
//                        iIndex = n;
//                        jIndex =
//                    }
//                }
//            }
//        }

        return newArr;
    }

    /**
     * 这个转弯 模拟
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            //如果为负数 或者 大于行数那么 就进行转弯。
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }


    public int[] spiralOrder3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int clo = matrix[0].length;
        int di[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int lengnt = row * clo;
        int arr[] = new int[lengnt];
        boolean[][] flag = new boolean[row][clo];
        int indxe = 0;
        int rowIndex = 0;
        int cloIndex = 0;
        for (int i = 0; i < lengnt; i++) {
            arr[i] = matrix[rowIndex][cloIndex];
            flag[rowIndex][cloIndex] = true;
            int nextRow = rowIndex + di[indxe][0];
            int nextCol = cloIndex + di[indxe][1];
            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= clo || flag[nextRow][nextCol]) {
                indxe = (indxe + 1) % 4;
            }
            rowIndex += di[indxe][0];
            cloIndex += di[indxe][1];
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(2);
        head.next = two;
        two.next = three;
        recoverListNode(head);
    }

    public static ListNode recoverListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
