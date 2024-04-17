package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/5 3:13 下午
 * @Description:
 */
public class KItemsWithMaximumSum {
    public static void main(String[] args) {
        System.out.println("args = " + kItemsWithMaximumSum(6, 6, 6, 13));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        return (k - numOnes) < 0 ? k :
                (k - numZeros - numOnes) < 0 ? numOnes :
                        (k - numNegOnes - numOnes - numZeros) < 0 ? numOnes + ((k - numZeros - numOnes) * -1) : numOnes + numNegOnes * -1;
    }

    public int kItemsWithMaximumSum2(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
