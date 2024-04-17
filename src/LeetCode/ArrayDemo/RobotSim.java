package LeetCode.ArrayDemo;

import java.util.*;

public class RobotSim {

    /**
     * 映射后的数字为 kx + y ，我们想知道 k 为多少时不会发生碰撞。当碰撞时
     * kx1+y1=kx2+y2，解出来 k =(y2-y1)/
     * (x1-x2)，由于 x , y 的取值范围为
     * [-30000,30000]，那么 k 的取值范围为[-60000,60000]，这个范围内的值都可能碰撞，比如 k =60000时，(1,-30000）和(0,30000）算出来都是30000。
     */
    // 西向    北向，      东向     南

    //            if (command == -1) {
//                x = x + 1 > 3 ? 0 : x + 1;
//            } else if (command == -2) {
//                x = x - 1 < 0 ? 3 : x - 1;
//            }
//
    public static void main(String[] args) {
        int[] arr = {4, -1, 4, -2, 4};
        int[][] ob = {{2, 4}};
        System.out.println();
        des();
        System.out.println(robotSim2(arr,ob));
    }
public static void des(){
        return;
}
    public static int robotSim(int[] commands, int[][] obstacles) {

        Set<Integer> hashMap = new HashSet<>();

        for (int i = 0; i < obstacles.length; i++) {
            hashMap.add(obstacles[i][0] * 60001 + obstacles[i][1]);
        }
        int fangxiang[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int x = 1;
        int xx = 0, yy = 0, max = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -1) {
                x = x + 1 > 3 ? 0 : x + 1;
            } else if (command == -2) {
                x = x - 1 < 0 ? 3 : x - 1;
            } else {
                for (int j = 0; j < command; j++) {
                    if (hashMap.contains(((xx + fangxiang[x][0]) * 60001) + yy + fangxiang[x][1])) {
                        break;
                    }
                    xx += fangxiang[x][0];
                    yy += fangxiang[x][1];
                    max = Math.max(max, xx * xx + yy * yy);
                }
            }
        }
        return max;
    }


    public static int robotSim2(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int px = 0, py = 0, d = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (int c : commands) {
            if (c < 0) {
                d += c == -1 ? 1 : -1;
                d %= 4;
                if (d < 0) {
                    d += 4;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])) {
                        break;
                    }
                    px += dirs[d][0];
                    py += dirs[d][1];
                    res = Math.max(res, px * px + py * py);
                }
            }
        }
        return res;
    }
}
