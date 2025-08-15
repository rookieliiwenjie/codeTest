package LeetCode.everyDay;
/**
 * 个题给我一下解题思路给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，
 * 请你返回 true ，否则请返回 false 。 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 */
public class CheckPowersOfThree {
    boolean resFlg = false;

    public static void main(String[] args) {
        CheckPowersOfThree checkPowersOfThree = new CheckPowersOfThree();
        checkPowersOfThree.checkPowersOfThree(91);
    }

    public boolean checkPowersOfThree(int n) {
        if (n == 3) {
            return true;
        }
        backtrack((double) n, 1);
        return resFlg;
    }

    public boolean checkPowersOfThree2(int n) {
        while (n>0) {
            if(n%3==2){
                return false;
            }
            n=n/3;
        }
        return true;
    }

    public boolean backtrack(double n, int i) {
        if (n == 0) {
            resFlg = true;
            return true;
        }
        if (n < 3) {
            return false;
        }
        boolean flage = backtrack(n - Math.pow(3, i), i + 1);
        backtrack(n - Math.pow(3, i), i);
        if (flage) {
            return true;
        }
        return false;
    }
}
