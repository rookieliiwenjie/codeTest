package LeetCode.oneHuFive;

import com.company.Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MinStack {
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> minList = new ArrayList<>();
    int min = Integer.MAX_VALUE;


    public MinStack() {

    }

    public void push(int val) {
        arrayList.add(val);
        if (min < val) {
            minList.add(min);
        } else {
            minList.add(val);
            min = val;
        }
    }

    public void pop() {
        arrayList.remove(arrayList.size() - 1);
        minList.remove(minList.size() - 1);
        min = minList.size() > 0 ? minList.get(minList.size() - 1) : Integer.MAX_VALUE;
    }

    public int top() {
        return arrayList.get(arrayList.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);

        minStack.top();
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
