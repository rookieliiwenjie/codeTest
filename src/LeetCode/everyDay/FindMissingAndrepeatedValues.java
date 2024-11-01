package LeetCode.everyDay;

public class FindMissingAndrepeatedValues {

    public static void main(String[] args) {
        FindMissingAndrepeatedValues findMissingAndrepeatedValues = new FindMissingAndrepeatedValues();
       // int girt[][] = {{1, 3}, {2, 2}};
        int girt[][] = {{9,1,7},{8,9,2},{3,4,6}};
        findMissingAndrepeatedValues.findMissingAndRepeatedValues(girt);
    }

    /**
     * 普通版本
     *
     * @param grid
     * @return
     */
    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int n = grid.length;
        int[] num = new int[(n * n) + 1];
        int reslut[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int resNum = grid[i][j];
                if (num[resNum] != 0) {
                    reslut[0] = resNum;
                } else {
                    num[resNum] = resNum;
                }
            }
        }
        for (int i = 1; i < (n * n) + 1; i++) {
            if (num[i] == 0) {
                reslut[1] = i;
            }
        }
        return reslut;
    }

    /**
     * 异或
     *
     * @param grid
     * @return
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;
        int lenght = (n * n) + 1;
        int nSum = 0;
        for (int i = 1; i < lenght; i++) {
            nSum += i;
        }
        int sum = 0;
        int xAll = 0;
        for (int row[] : grid) {
            for (int num : row) {
                xAll ^= num;
                sum += num;
            }
        }
        System.out.println(xAll);
        result[0] = xAll;
        result[1] = nSum - (sum - xAll);
        return result;
    }

    /**
     * 数学
     */
    public int[] findMissingAndRepeatedValues3(int[][] grid) {
        int[] result = new int[2];
        return result;
    }
}
