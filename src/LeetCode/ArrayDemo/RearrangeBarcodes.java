package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/14 11:20 下午
 * @Description:
 */
public class RearrangeBarcodes {
    public static void main(String[] args) {

    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length <= 1) {
            return barcodes;
        }
        int newArr[] = new int[barcodes.length];
        Arrays.sort(barcodes);
        int left = 0;
        int right = barcodes.length - 1;
        for (int i = 0; i < barcodes.length; ) {
            newArr[i] = barcodes[left];
            if ((i + 1) < barcodes.length) {
                newArr[i + 1] = barcodes[right];

            }
            left++;
            right--;
            i = i + 2;
        }
        return newArr;
    }


    public static int[] rearrangeBarcodes2(int[] barcodes) {
        if (barcodes.length <= 1) {
            return barcodes;
        }
        int newArr[] = new int[barcodes.length];
        int maxCount = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : barcodes) {
            maxCount = Math.max(maxCount, count.get(i));
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        return newArr;
    }

        public static int[] rearrangeBarcodes3(int[] barcodes) {
            int length = barcodes.length;
            if (length < 2) {
                return barcodes;
            }

            Map<Integer, Integer> counts = new HashMap<>();
            int maxCount = 0;
            for (int b : barcodes) {
                counts.put(b, counts.getOrDefault(b, 0) + 1);
                maxCount = Math.max(maxCount, counts.get(b));
            }

            int evenIndex = 0;
            int oddIndex = 1;
            int halfLength = length / 2;
            int[] res = new int[length];
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                int x = entry.getKey();
                int count = entry.getValue();
                while (count > 0 && count <= halfLength && oddIndex < length) {
                    res[oddIndex] = x;
                    count--;
                    oddIndex += 2;
                }
                while (count > 0) {
                    res[evenIndex] = x;
                    count--;
                    evenIndex += 2;
                }
            }
            return res;
        }

}
