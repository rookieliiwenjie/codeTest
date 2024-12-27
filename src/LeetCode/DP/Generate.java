package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(3));

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(1);
            res.add(oneList);
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> pre = res.get(i - 2);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }


}
