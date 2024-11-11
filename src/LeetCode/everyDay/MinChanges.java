package LeetCode.everyDay;

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
