package LeetCode.everyDay;

public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
//        int[][] img = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
//        int[][] img = { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 10 }, { 11, 12, 13 }, { 14, 15, 16 } };
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] ints = imageSmoother.ImageSmoother(img);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public int[][] ImageSmoother(int img[][]) {
        //0=x 1=y
        // 左，左上，上 ， 右上 ， 右 ， 右下，下，左下
        int[][] index = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {0, 1}, {1, 1}, {1, 0}, {-1, 1}};
        int m = img.length;
        int n = img[0].length;
        int[][] arr = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int sumNum = img[x][y];
                int numCount = 1;
                for (int i = 0; i < index.length; i++) {
                    int xindex = x + index[i][1];
                    int yIndex = y + index[i][0];
                    if (xindex >= 0 && xindex < m && yIndex >= 0 && yIndex < n) {
                        sumNum += img[xindex][yIndex];
                        numCount++;
                    }
                }
                arr[x][y] = sumNum / numCount;
            }
        }
        return arr;
    }
}