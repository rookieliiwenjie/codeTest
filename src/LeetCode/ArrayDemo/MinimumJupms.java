package LeetCode.ArrayDemo;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumJupms {
    /**
     * na - mb = x
     * 同時往前走，na - mb = x  x !=forbidden中的數
     * n+m 的最小數;
     *
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        List<Integer> forbiddenList = Arrays.stream(forbidden).boxed().collect(Collectors.toList());
        int yuShu = a % x;
        int shang = a / x;
        if (a == b) {
            if (a > x || yuShu != 0) {
                return -1;
            }
            int num = shang;
            while (num > 0) {
                if (forbiddenList.contains(shang * x)) {
                    return -1;
                }
                num--;
            }
            return shang;
        } else if (a < b) {

        } else if (a > b) {

        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumJupms minimumJupms = new MinimumJupms();
        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3;
        int b = 15;
        int x = 9;
        System.out.println(minimumJupms.minimumJumps(forbidden, a, b, x));
    }
}
