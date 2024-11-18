package LeetCode.everyDay;

import java.util.List;
import java.util.stream.Collectors;

public class MinChanges {
    public static void main(String[] args) {
        MinChanges minChanges = new MinChanges();
        int sum = minChanges.minChanges2(14, 13);
        System.out.println(sum);
    }

    public int minChanges2(int n, int k) {
        int ans = 0;
        while (n > 0 || k > 0) {
            if ((n & 1) == 0 && (k & 1) == 1) {
                return -1;
            }
            if ((n & 1) == 1 && (k & 1) == 0) {
                ans++;
            }
            n >>= 1;
            k >>= 1;
        }
        return ans;
    }

    /**
     *
     * 1. **`(n & k) == k`**:
     *    - 这个表达式检查 `k` 是否是 `n` 的子集。`&` 是按位与运算符，它会对 `n` 和 `k` 的每一位进行与操作。如果 `k` 的每一位都是 `n` 的子集，那么 `(n & k)` 的结果应该等于 `k`。
     *
     * 2. **`Integer.bitCount(n ^ k)`**:
     *    - 如果上面的条件为真，那么我们���算 `n` 和 `k` 之间的不同位数。`^` 是按位异或运算符，它会对 `n` 和 `k` 的每一位进行异或操作。异或��作的结果是，如果两位相同则为 `0`，不同则为 `1`。`Integer.bitCount` 方法会计算结果中 `1` 的个数，这表示 `n` 和 `k` 之间不同的位数。
     *
     * 3. **`-1`**:
     *    - 如果 `(n & k) != k`，则返回 `-1`，表示 `k` 不是 `n` 的子集，无法通过改变 `n` 的某些位来得到 `k`。
     *
     * 通过这种方式，这行代码可以计算出将 `n` 变为 `k` 所需的最小更改次数。如果 `k` 不是 `n` 的子集，则返回 `-1`。
     * @param n
     * @param k
     * @return
     *
     * `n & k` 是按位与运算符，它会对 `n` 和 `k` 的每一位进行与操作。具体来说：
     *
     * - 如果 `n` 和 `k` 的对应位都是 `1`，则结果位为 `1`。
     * - 否则，结果位为 `0`。
     *
     * 例如：
     * ```java
     * int n = 13; // 二进制: 1101
     * int k = 4;  // 二进制: 0100
     * int result = n & k; // 结果: 0100 (十进制: 4)
     * ```
     *
     * 在这个例子中，`n & k` 的结果是 `4`，因为只有 `n` 和 `k` 的第三位都是 `1`。
     *
     *
     *
     *
     * `n ^ k` 是按位异或运算符，它会对 `n` 和 `k` 的每一位进行异或操作。具体来说：
     *
     * - 如果 `n` 和 `k` 的对应位相同，则结果位为 `0`。
     * - 如果 `n` 和 `k` 的对应位不同，则结果位为 `1`。
     *
     * 例如：
     * ```java
     * int n = 13; // 二进制: 1101
     * int k = 4;  // 二进制: 0100
     * int result = n ^ k; // 结果: 1001 (十进制: 9)
     * ```
     *
     * 在这个例子中，`n ^ k` 的结果是 `9`，因为 `n` 和 `k` 的对应位不同的地方为 `1`。
     */
    public int minChanges3(int n, int k) {
        return (n & k) == k ? Integer.bitCount(n ^ k) : -1;
    }



    /**
     * 条件n任意一个值为 1 的位，并将其改为 0
     * 返回使得 n 等于 k 所需要的更改次数。
     */
    public int minChanges(int n, int k) {
        char[] nValue = Integer.toBinaryString(n).toCharArray();
        char[] kValue = Integer.toBinaryString(k).toCharArray();
        int nValueLenght = nValue.length - 1;
        int kValueLenght = kValue.length - 1;
        int sum = 0;
        while (nValueLenght >= 0 || kValueLenght >= 0) {
            if (nValueLenght < 0 && kValueLenght >= 0) {
                if (kValue[kValueLenght] == '1') {
                    return -1;
                }

            }
            if (nValueLenght >= 0 && kValueLenght < 0) {
                if (nValue[nValueLenght] == '1') {
                    sum++;
                }
            }
            if (kValueLenght >= 0 && nValueLenght >= 0) {
                if (kValue[kValueLenght] == '0' && nValue[nValueLenght] == '1') {
                    sum++;
                } else if (kValue[kValueLenght] == nValue[nValueLenght]) {

                } else if (kValue[kValueLenght] == '1' && nValue[nValueLenght] == '0') {
                    return -1;
                }
            }
            nValueLenght--;
            kValueLenght--;

        }
        return sum;
    }

}
