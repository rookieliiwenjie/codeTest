package LeetCode.everyDay;

import java.util.HashMap;
import java.util.TreeMap;

public class ATM {
    public ATM() {
        money = new long[]{20, 50, 100, 200, 500};
        curronMoney = new int[]{0, 0, 0, 0, 0};

    }

    int[] curronMoney;
    private long[] money; // 每张钞票面额
    //key 面值 大小 value 还有多少

    //存钱 取钱
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            curronMoney[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int res[] = new int[5];
        for (int i = 4; i >= 0; i--) {
            int count = (int) (amount / money[i]);
            if (curronMoney[i] <= 0 || amount < money[i] || count <= 0) {
                continue;
            }
            res[i] =  Math.min(count, curronMoney[i]);
            amount = (int) (amount - money[i] * res[i]);
        }
        if (amount != 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            curronMoney[i] -= res[i];
        }
        return res;
    }
}
