package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/29 8:22 下午
 * @Description:
 */
public class ReconstructMatrix {
    /**
     * 重建矩阵
     *
     * @param upper  上 第一行 和
     * @param lower  较低 第二行和
     * @param colsum colsum 列的和
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int colsumLenght = colsum.length;
        int two = 0, sum = 0;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                two++;
            }
            sum += colsum[i];
        }
        //当two+1 时代表  对应列为1。那么相对来说 upper 和 lower 都要+1 所以如果小于的那么一定 没有成立的矩形
        if (upper + lower != sum || Math.min(upper, lower) < two) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        return list;
    }
}
