package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/10 9:11 下午
 * @Description:
 */
public class VerifyPostorder {
    public static void main(String[] args) {

    }

    public static boolean verifyPostorder(int[] postorder) {

        return isPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 左右根
     * 左比根小 ，右比根大， 左比右小
     *
     * @param postorder
     */
    public static boolean isPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int p = start;
        while (postorder[p] < postorder[end]) {
            p++;
        }
        //记录左右支数
        int m = p;
        while (postorder[p] > postorder[end]) {
            p++;
        }
        return (p == end) && isPostorder(postorder, start, m) && isPostorder(postorder, m, p - 1);
    }

    /**
     * 单调栈
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder2(int[] postorder) {
//        St
        return false;
    }


}
