package LeetCode.zhan;

import java.util.Arrays;

class TripleInOne {
    int stackSize;
    int arr[];
    int size = 0;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        this.arr = new int[stackSize];
        Arrays.fill(this.arr, -1);
    }

    public void push(int stackNum, int value) {
        if (size == stackSize) {
            return;
        }
        int arr[] = new int[stackSize];
        int startIndex = stackNum;
        for (int i = stackNum; i <stackSize; i++) {
            arr[startIndex] = arr[i];
        }
        arr[stackNum] = value;
        size++;
    }

    public int pop(int stackNum) {
        if (size <= 0 || stackNum >= stackSize) {
            return -1;
        }
        int res = arr[stackNum];
        arr[stackNum] = -1;
        size--;
        return res;

    }

    public int peek(int stackNum) {
        if (stackNum < stackSize) {
            return arr[stackNum];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        if (size <= 0 || stackNum >= stackSize) {
            return true;
        }
        return stackNum != -1;
    }

}