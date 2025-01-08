package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * backtrack
 */
public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[2 * n], 0, res);
        return res;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            String s =  String.valueOf(current);
            System.out.print(s+",");
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int left = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == '(') {
                left++;
            } else {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis1(3);
        System.out.println("generateParenthesis");
        System.out.println("generateParenthesis");
        generateParenthesis.generateParenthesis(3);
    }
    //回溯法
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
        }
        if (open < max) {
            cur.append('(');
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    //按照括号长度递归
    public List<String> generateParenthesis3(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

}
