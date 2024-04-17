package LeetCode.ArrayDemo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/17 7:56 下午
 * @Description:
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        //入栈
        int[] pushed = {1,0,2};
        //出栈
        int[] popped = {2,1,0};
        validateStackSequences(pushed, popped);
    }

    public static boolean validateStackSequences(int[] pushed
            , int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && popped[j] == deque.peek()) {
                deque.pop();
                j++;
            }
        }
        return deque.isEmpty();
    }
}
