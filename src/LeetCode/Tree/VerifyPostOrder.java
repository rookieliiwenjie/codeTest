package LeetCode.Tree;

import java.util.StringTokenizer;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/12 4:16 下午
 * @Description:
 */
public class VerifyPostOrder {

    public static boolean verifyPostorder(int [] postorder){
        return isVerifyPostOrder(0,postorder.length-1,postorder);
    }

    public static boolean isVerifyPostOrder(int left, int right, int[] postOrderLeft){
        if(left>=right){
            return true;
        }
        int rootVal = postOrderLeft[right];
        int leftLenght = 0;
        int rightlenght =0;
        for (int i = left ;i<right ;i++) {
            if(rootVal>postOrderLeft[i]){
                leftLenght++;
            }else  if (rootVal< postOrderLeft[i]){
                rightlenght++;
            }
        }
        //((leftLenght+rightlenght) == (right-left)) 表示 没有遗漏或者等于的 数 因为是收缩二叉树
        return ((leftLenght+rightlenght) == (right-left)) && isVerifyPostOrder(left,leftLenght-1,postOrderLeft) && isVerifyPostOrder(leftLenght,right-1,postOrderLeft);
    }

    public static void main(String[] args) {
        StringTokenizer matnrArrays = new StringTokenizer("12,334 34343,1232 344343  "," ,");
        System.out.println("matnrArrays.countTokens()" + matnrArrays.countTokens());
        System.out.println(" matnrArrays.hasMoreTokens()"+matnrArrays.hasMoreTokens());
        System.out.println(" matnrArrays.hasMoreTokens()" +matnrArrays.hasMoreElements());

        while (matnrArrays.hasMoreElements()){
            System.out.println("matnrArrays.nextToken() = " + matnrArrays.nextToken());
          //  System.out.println("matnrArrays.nextElement() = " + matnrArrays.nextElement());
        }
//        int arr[]  = {1,2,5,10,6,9,4,3};
//        verifyPostorder(arr); int i = matnrArrays.countTokens();

    }
//    public boolean verifyPostorder(int[] postorder) {
//        return isVerifyPostOrder( 0, postorder.length - 1,postorder);
//    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
