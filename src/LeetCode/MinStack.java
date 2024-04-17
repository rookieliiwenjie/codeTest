package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-18 23:23
 */
public class MinStack {
    Deque<Integer> minStack = new LinkedList<>();
    Deque<Integer> stack = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
        Integer min = minStack.peekLast();
        if (min == null) {
            minStack.add(x);
        } else {
            if (min > x) {
                minStack.add(x);
            } else {
                minStack.add(min);
            }
        }

    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        Integer peekLast = stack.peekLast();
        return peekLast;
    }

    public int min() {
        Integer min = minStack.peekLast();
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(" minStack.min() " + minStack.min());
        minStack.pop();
        System.out.println("minStack.top()" + minStack.top());
        System.out.println("minStack.min()" + minStack.min());


    }
}
