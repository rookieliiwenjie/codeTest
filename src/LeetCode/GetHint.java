package LeetCode;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * <p>
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * <p>
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-11-08 11:23
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int AFlag = 0;
        int[] sNum = new int[10];
        int[] gNum = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                AFlag++;
            } else {
                sNum[secret.charAt(i) - '0']++;
                gNum[guess.charAt(i) - '0']++;
            }
        }
        int BFlag = 0;
        for (int i = 0; i < sNum.length; i++) {
            BFlag += Math.min(sNum[i], gNum[i]);
        }
        return AFlag + "A" + BFlag + "B";


    }
}
