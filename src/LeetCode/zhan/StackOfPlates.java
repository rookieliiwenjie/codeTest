package LeetCode.zhan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，
 * 盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，
 * 模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()
 * 返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class StackOfPlates {
    public static void main(String[] args) {
        /**
         * ["StackOfPlates", "pop", "pop", "popAt", "popAt",
         * "pop", "push", "push", "push", "push", "pop",
         * "push", "push", "popAt", "pop", "popAt", "push",
         * "popAt", "pop", "push", "pop", "pop", "pop", "popAt", "push", "pop", "popAt", "pop", "push", "popAt", "popAt", "push", "popAt", "popAt", "push", "pop", "popAt", "popAt", "popAt", "pop", "popAt", "popAt", "push", "popAt", "push", "push", "pop", "popAt", "popAt", "push", "popAt", "push", "pop", "pop", "push", "push", "push", "popAt", "popAt",
         * "pop", "popAt", "pop", "pop", "push", "push"]
         */
        StackOfPlates stackOfPlates = new StackOfPlates(1);
        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.popAt(3);
        stackOfPlates.push(1);
        stackOfPlates.push(2);

    }

    int stackSize = 0;
    List<Deque<Integer>> stack;
    int index = 0;

    public StackOfPlates(int cap) {
        this.stackSize = cap;
        this.stack = new ArrayList<>();
        this.stack.add(new ArrayDeque<>());
    }

    public void push(int val) {
        Deque<Integer> index = stack.get(this.index);
        if (index == null) {
            index = new ArrayDeque<>();
            stack.add(index);
        } else {
            if (index.size() >= stackSize) {
                this.index++;
                index = new ArrayDeque<>();
                stack.add(index);
            }
            index.addFirst(val);
        }

    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Deque<Integer> index = stack.get(this.index);
        if (index == null || index.isEmpty()) {
            return -1;
        }
        return index.pollFirst();
    }

    public int popAt(int index) {
        if (this.stack.size() <= index || index >= 0) {
            return -1;
        }
        Deque<Integer> stack = this.stack.get(index);
        if (stack == null) {
            return -1;
        }
        int poll = stack.pollFirst();
        if (stack.isEmpty()) {
            this.stack.remove(index);
            this.index--;
        }
        return poll;
    }
}
