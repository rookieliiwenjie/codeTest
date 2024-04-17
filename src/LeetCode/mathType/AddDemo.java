package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 10:42 上午
 * @Description:
 */
public class AddDemo {

    public static int add(int a, int b) {
        while (b != 0) {
            //&只有对应的两个二进位均为1时，结果位才为1 ，否则为0。
            int carry = (a & b) >> 1;
            //对应2进制位为相同时 返回0 否则为1
            a = a ^ b;
            b = carry;
        }
        return a;
    }


    public static int div(int a, int b) {

        // 考虑被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }

        long sum = 0;
        long num = 0;
        boolean flag = true;
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            flag = false;
        }
        if (b > 0) {
            b = -b;
        }
        if (a > 0) {
            a = -a;
        }
        while ((sum + b) >= a) {
            sum += b;
            num++;
        }

        return (int) (flag ? num : -num);
    }

    public static int add2(int a, int b) {

        while (a != 0) {
            int temp = a ^ b;//不计进位的加法
            b = (a & b) << 1;//对进位的处理
            a = temp;
        }
        return a;
    }

    public int divide(int a, int b) {
        // 考虑被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = !rev;
        }
        if (b > 0) {
            b = -b;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(b, mid, a);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        //add(7, 7); -2147483648
        System.out.println("args = " + div(-2147483648, 2));
//        System.out.println("args = " + div(-7,-3));
//        System.out.println("-7/-3 = " + -7 / -3);
    }
}
