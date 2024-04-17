package LeetCode.everyDay;

public class FindChampion {
    public static void main(String[] args) {
        FindChampion findChampion = new FindChampion();
        int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(findChampion.findChampion(grid));
    }

    public int findChampion(int[][] grid) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int countIn = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && i != j) {
                    countIn++;
                }
            }
            if (countIn > count) {
                count = countIn;
                max = i;
            }

        }
        return max;
    }

    /**
     * 冠军只有一个
     * 每一个m就是一个队对其他队的胜负情况
     * 而且是顺序的不可环的，所有我们只需要找到 sum（nums[i][循环n]） = n-1就可以
     * @param grid
     * @return
     */
    public int findChampion2(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int line[] = grid[i];
            int sum = 0;
            for (int j = 0; j < line.length; j++) {
                sum += line[j];
            }
            if(sum==line.length-1){
                return i;
            }

        }
        return -1;
    }
}
