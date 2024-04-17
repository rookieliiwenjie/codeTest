package LeetCode.ArrayDemo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 8:44 下午
 * @Description:
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        //int arr[] = {5, 10, -5};
        //int arr[] = {8, -8};
        // int arr[] = {10, 2, -5};
//        int arr[] = {10, 2, -5};
        int arr[] = {-2, -2, 1, 2};
        asteroidCollision(arr);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int right = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (right < asteroids.length) {
            int weight = asteroids[right];
            if (weight < 0) {
                boolean flag = false;
                while (!deque.isEmpty() && deque.peek() > 0) {
                    if ((weight + deque.peek()) < 0) {
                        deque.pop();
                    } else if (weight + deque.peek() == 0) {
                        deque.pop();
                        flag = true;
                        break;
                    } else if ((weight + deque.peek()) > 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    deque.push(weight);
                }
            } else {
                deque.push(asteroids[right]);
            }
            right++;
        }
        int arr[] = new int[deque.size()];
        for (int i = deque.size() - 1; i >= 0; i--) {
            arr[i] = deque.pop();
        }
        return arr;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶小行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static int[] asteroidCollisionPlus(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int ands : asteroids) {
            boolean flag = true;
            while (flag && ands < 0 && !deque.isEmpty() && deque.peek() > 0) {
                //这里很妙，这里一句就解决了 等于 和 删除的问题
                flag = deque.peek() < -ands;
                if (deque.peek() <= -ands) {
                    deque.pop();
                }
            }
            if (flag) {
                deque.push(ands);
            }
        }
        int arr[] = new int[deque.size()];
        for (int i = deque.size() - 1; i >= 0; i--) {
            arr[i] = deque.pop();
        }
        return arr;
    }
}
