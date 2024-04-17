package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/13 10:38 上午
 * @Description:
 */
public class MinFallingPathSum {


    public static int minFallingPathSum2(int[][] matrix) {
        //移动位置
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int digui = digui(0, i, matrix);
            min = Math.min(min, digui);
        }
        return min;
    }

    //向下 / 向左下 向右下
    static int[][] indexArr = {{1, 0}, {1, -1}, {1, 1}};

    //过不了时间限制
    public static int minFallingPathSum(int[][] matrix) {
        //移动位置
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, digui(0, i, matrix));
        }
        return min;
    }

    public static int digui(int x, int y, int[][] matrix) {
        //记录当前位置
        int num = matrix[x][y];
        int min = Integer.MAX_VALUE;
        //最后一行不处理直接返回
        if (x == matrix.length - 1) {
            return num;
        }
        for (int i = 0; i < indexArr.length; i++) {
            int nxex = x + indexArr[i][0];
            int nexty = y + indexArr[i][1];
            if (nxex >= 0 && nexty >= 0 && nexty < matrix.length && nxex < matrix.length) {
                //下一层的和
                int nextNum = digui(nxex, nexty, matrix);
                //在同一个循环里 判断最小的数。
                min = Math.min(min, nextNum + num);
            }
        }
        return min;
    }
    public static int integerBreak(int n) {
        if(n == 1)return 0;
        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 0;
        for(int i = 2; i <= n; i++){
            int maxmultip = 0;
            for(int j = 1; j < i; j++){
                System.out.println("(i-j) = " + (i-j));
                maxmultip = Math.max(maxmultip,Math.max(j*(i - j),j*(arr[i - j])));
            }
            arr[i] = maxmultip;
        }
        return arr[n];
    }

    public static void main(String[] args) {
//        int[][] matrix = {{2, 1, 3},
//                {6, 5, 4},
//                {7, 8, 9}};
//        int[][] matrix = {{-19, 57}, {-40, -5}};
//        System.out.println("minFallingPathSum(matrix) = " + minFallingPathSum(matrix));
        System.out.println("integerBreak(17) = " + integerBreak(17));
          int yushu = 17%3;
        System.out.println("yushu = " + yushu);
          int shang = 17/3;
        System.out.println("shang = " + shang);
        if(yushu==1){
            System.out.println("shang = " + Math.pow(3,shang-1)*4);
        }else if(yushu==0){
            System.out.println(" = " + Math.pow(3,shang));
        }else {
            System.out.println(" = " +Math.pow(3,shang)*2);
        }
    }


    //灵府的做法
    private int[][] matrix;

    public int minFallingPathSum3(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++)
            ans = Math.min(ans, dfs(n - 1, c));
        return ans;
    }

    private int dfs(int r, int c) {
        if (c < 0 || c >= matrix.length) return Integer.MAX_VALUE; // 出界
        if (r == 0) return matrix[0][c]; // 到达第一行
        return Math.min(Math.min(dfs(r - 1, c - 1), dfs(r - 1, c)), dfs(r - 1, c + 1)) + matrix[r][c];
    }


}
