package LeetCode.QuestionAnwers;

import java.util.ArrayList;
import java.util.List;

public class YanghuiSanjiao {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> preList = null;
            if (i > 1) {
                preList = res.get(i - 1);
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(preList.get(j - 1) + preList.get(j));
                }

            }
            res.add(list);

        }
        return res;
    }
}
