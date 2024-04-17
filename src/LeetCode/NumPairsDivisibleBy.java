package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/7 9:50 下午
 * @Description:
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * 解题思路 组合数学。
 */
public class NumPairsDivisibleBy {

    public static int numPairsDivisibleBy60(int[] time) {
        int max = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i+1; j < time.length; j++) {
                if((time[i]+time[j]) %60 ==0){
                    max = max +1;
                }
            }
        }
        return max;
    }

    public static int numPairsDivisibleBy602(int[] time) {
        int max = 0;
        int[] arr = new int[60];
        for (int t : time) {
            int y = t%60;
            //先找出来
         //   max += arr[(60 - t % 60) % 60];

//            举例，如果 time[i]=1\textit{time}[i]=1time[i]=1，那么需要知道左边有多少个模 606060 余数是 595959 的数。
//            举例，如果 time[i]=62\textit{time}[i]=62time[i]=62，那么需要知道左边有多少个模 606060 余数是 585858 的数。
//            一般地，对于 time[i]\textit{time}[i]time[i]，需要知道左边有多少个模 606060 余数是 60−time[i] mod 6060-\textit{time}[i]\bmod 6060−time[i]mod60 的数。
//            特别地，如果 time[i]\textit{time}[i]time[i] 模 606060 的余数是 000，那么需要知道左边有多少个模 606060 余数也是 000 的数。
//            这两种情况可以合并为：累加左边 (60−time[i] mod 60) mod 60(60-\textit{time}[i]\bmod 60)\bmod 60(60−time[i]mod60)mod60 的出现次数。
//
//            作者：灵茶山艾府
//            链接：https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/solutions/2259343/liang-shu-zhi-he-de-ben-zhi-shi-shi-yao-bd0r1/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            max += arr[(60-y)%60];
            arr[y]++;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr [] = {60,60,60};
        System.out.println("args = " + numPairsDivisibleBy602(arr));
    }
}
