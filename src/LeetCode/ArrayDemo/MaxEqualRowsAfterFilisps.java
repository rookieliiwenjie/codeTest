package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/15 3:49 下午
 * @Description:
 */
public class MaxEqualRowsAfterFilisps {
    public static void main(String[] args) {
        int [][]ma = {{1,0,0},{0,1,1}};
        maxEqualRowsAfterFlips2(ma);
    }

    /**
     * 这个如何统计每位上的0和1是比较麻烦的，遇到相同的可以用字符串平均的
     * @param matrix
     * @return
     */
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return 0;
        }
        int row = matrix[0].length;
        int lie = matrix.length;
        //key为和 value为数量
        HashMap<String, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < lie; i++) {
            StringBuilder stringBuffer = new StringBuilder();
            StringBuilder stringBufferRecover = new StringBuilder();
            for (int j = 0; j < row; j++) {
                stringBuffer.append(matrix[i][j]);
                stringBufferRecover.append(matrix[i][j] == 0 ? 1 : 0);
            }
            Integer integer =  hashMap.get(stringBuffer.toString());
            if (hashMap.get(stringBuffer.toString()) != null) {
                integer = integer + 1;
                hashMap.put(stringBuffer.toString(), integer);
            } else {
                integer = 1;
                hashMap.put(stringBuffer.toString(), 1);
            }
            Integer reverInter = hashMap.get(stringBufferRecover.toString());
            if (reverInter != null) {
                reverInter = reverInter + 1;
                hashMap.put(stringBufferRecover.toString(), reverInter);
            } else {
                reverInter =  1;
                hashMap.put(stringBufferRecover.toString(), reverInter);
            }
            max = Math.max(max, Math.max(integer, reverInter));
        }
        return max;
    }

    public static int maxEqualRowsAfterFlips2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                // 如果 matrix[i][0] 为 1，则对该行元素进行翻转
                arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
    public int maxEqualRowsAfterFlips4(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        /**
         key:每一行(字符串形式);
         value:出现的次数
         */
        Map<String, Integer> map = new HashMap<>();//将每一行转成字符串形式存储到哈希表

        for(int i=0; i<m; ++i){ //遍历行

            char[] arr = new char[n]; //临时的字符数组，转成字符串用
            Arrays.fill(arr, '0'); //默认都为0

            for(int j=0; j<n; ++j){ //遍历列
                /**
                 异或 ^ 的性质：相同为0，相异为1
                 如果 matrix[i][0] 为 0：matrix[i][j] ^ 0 异或的结果还是 matrix[i][j]；
                 如果 matrix[i][0] 为 1：matrix[i][j] ^ 1 异或的结果还是 取反，即翻转；
                 +'0' 转成字符
                 */
                arr[j] = (char)('0' + (matrix[i][j] ^ matrix[i][0]));//如果 matrix[i][0] 为 1，则对该行元素进行翻转
            }

            String s = new String(arr); //转成字符串
            map.put(s, map.getOrDefault(s,0)+1);//将每一行转成字符串形式存储到哈希表
        }

        int res = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){//遍历哈希表
            res = Math.max(res, entry.getValue());//最多的本质相同的行的数量
        }
        return res;
    }
}
