package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rookie.li
 * @create 2020/11/10
 */
public class PrefixesDivBy5 {
    /**
     * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：
     * 从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
     * <p>
     * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
     * 示例 1：
     * 输入：[0,1,1]
     * 输出：[true,false,false]
     * 解释：
     * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
     * 示例 2：
     * 输入：[1,1,1]
     * 输出：[false,false,false]
     * 示例 3：
     * 输入：[0,1,1,1,1,1]
     * 输出：[true,false,false,false,true,false]
     * 输入：[1,1,1,0,1]
     * 输出：[false,false,false,false,false]
     * 提示：
     * 1 <= A.length <= 30000
     * A[i] 为 0 或 1
     */
    public static void main(String[] args) {
        int[] arr = {0, 1, 1};
        int x = 2 >> 1;
        System.out.println("x = " + x);
        List<Boolean> booleans = prefixesDivBy5(arr);
        System.out.println("booleans = " + booleans);
    }

    /**
     * 解法
     * 这道题我们要解决的问题是什么？去求一个数能不能被5整除，
     * 也就是number%5==0的问题。我们用num来表示上一个二进制数，
     * 初始状态index=0，没有上一个状态，因此num=0。有了上面的准备工作我们就可以遍历这个由0和1组成的数组了
     * ，每遍历一个元素，我们就将num左移一位（二进制数的左移可以看成num*2），然后加上当前位置A[index]的值，
     * 如果值不大的话，其实我们可以不用特意求余，但本问题的核心就在于会溢出，所以要对5求余数，再来判断。
     *
     * 总结
     * 迭代式利用求余数来判断的场景下，个人感觉就是一句话，对当前迭代式整体求余并不会影响下一次迭代式整体求余操作。
     *
     * 答疑
     * 估计像我这样的小白看完上面的过程，理解了90%，不清楚为什么要对5求余，这里有两个意思，
     * 一呢就是一个数看看能不能被5整除；第二个意思就是防止溢出，
     * 先看几个余数定理a=b%c=b%c%c;（a+b）%c=((a%c)+(b%c))%c,ab%c=((a%c)*(b%c))%c;
     * 再来举一个例子，比如有一个数num=3，
     * 左移一位再加上一个数A[index]=1,第一次的式子就为(3*2+1),再对5求余判断能否被5整除，
     * (2*3+1)%5=2，好了7这个数不能被整除，我们再对7左移一位再加上一个数A[index]=1，
     * 第二次的式子就为(7*2+1),再对5求余判断能否被5整除，(7*2+1)%5=0，能被整除，再一直执行下去
     * ；重点来了，第二次的式子为(preNum*2+1),其中preNum=(3*2+1)，
     * 同时(preNum*2+1)%5可以写成(((preNum%5)*(2%5))%5+1%5)%5，
     * 我们可以看出第二次的式子用到了上一次的preNum并且还对5求余了，那为何不直接对preNum进行求余呢，
     * 把preNum=(3*2+1)改写为preNum=(3*2+1)%5，之后preNum在第二次展开式子中还是会%5，b%c=b%c%c，
     * 也不会影响下一次运算，最主要的是这样做了之后preNum会在[0,4]之间，不会再溢出了
     * 。大家如果认真跟着例子走一遍，应该能理解了。
     * @param A
     * @return
     */
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> booleanList = new ArrayList<>();
        int i = 0;
        for (int a : A) {
            i = (i << 1 + a) % 5;
            booleanList.add(i == 0);
        }
        return booleanList;
    }
}
