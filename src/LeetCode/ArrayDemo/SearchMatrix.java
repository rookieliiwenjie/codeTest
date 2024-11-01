package LeetCode.ArrayDemo;

/**
 * @author rookie.li
 */
public class SearchMatrix {


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        //这里也可以二分优化
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                if (target == matrix[i][n - 1]) {
                    flag = true;
                } else {
                    //这里可以二分优化
                    for (int j = 0; j < n; j++) {
                        if (target == matrix[i][j]) {
                            flag = true;
                            break;
                        }
                    }
                }
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
//        int [][]  arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 13;
        int[][] arr = {{1}};
        int target = 1;
        searchMatrix5(arr,target);
    }
    public static boolean searchMatrix5(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        //这里也可以二分优化
        int low = 0;
        int high = m - 1;
        while (low < high) {
            int mid = ((high - low) / 2) + low;
            if (matrix[mid][n-1] < target) {
                low = mid+1;
            } else if(matrix[mid][n-1]==target){
               return true;
            }else if(matrix[mid][n-1] > target){
                high = mid;
            }
        }
        int lowIndex = 0;
        int hightIndex = n-1;
        while (lowIndex <= hightIndex) {
            int mid = ((hightIndex - lowIndex) / 2) + lowIndex;
            if (matrix[high][mid] == target) {
                return true;
            }else if(matrix[high][mid]<target){
                lowIndex=mid+1;
            } else {
                hightIndex = mid - 1;
            }
        }
        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public static int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
