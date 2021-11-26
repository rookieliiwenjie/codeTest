package com.company.LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 * <p>
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-10-13 16:51
 */
public class FizzBuzz {
    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        System.out.println("strings = " + strings);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> fizzBuzz = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzz.add("FizzBuzz");
            } else if (i % 3 == 0 ) {
                fizzBuzz.add("Fizz");
            } else if (i % 5 == 0) {
                fizzBuzz.add("Buzz");
            } else {
                fizzBuzz.add(String.valueOf(i));
            }
        }
        return fizzBuzz;
    }
}
