package LeetCode.ArrayDemo;

public class MaxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int l = 0;
        //计算开头为0的距离
        while (l < seats.length && seats[l] == 0) {
            l++;
        }
        max = l;
        while (l < seats.length) {
            //计算两个1的距离
            int r = l + 1;
            while (r < seats.length && seats[r] == 0) {
                r++;
            }
            if (r == seats.length) {
                max = Math.max(max, r - l - 1);
            } else {
                max = Math.max(max, (r - l) / 2);
            }
            l = r;
        }
        return max;

    }

    public static void main(String[] args) {
        MaxDistToClosest maxDistToClosest = new MaxDistToClosest();
         int seats[] = {1, 0, 0, 0, 1, 0, 1};
//        int seats[] = {1, 0, 0, 0};
//        int seats[] = { 0, 1};
//        int seats[] = {1, 0, 0, 1};
        int i = maxDistToClosest.maxDistToClosest(seats);
        System.out.println(i);
    }

    public int maxDistToClosest2(int[] seats) {
        int length = seats.length;
        int max = 0;
        int left = -1;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                if ((left != -1 && flag)) {
                    max = Math.max(max, (i - left) / 2);
                    flag = false;
                    left = i;
                } else {
                    left = i;
                }
            } else {
                //第一个为0的情况
                if (left == -1) {
                    max = Math.max(max, i + 1);
                }
                flag = true;
            }
        }
        //结尾处理
        if (flag && seats[length - 1] == 0) {
            max = Math.max(max, length - left - 1);
        }
        return max;
    }
}
