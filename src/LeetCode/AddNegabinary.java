package LeetCode;

import LeetCode.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/18 6:42 下午
 * @Description:
 */
public class AddNegabinary {
    /**
     * -2 进制碰到-2 进1
     * 1-2 进-1
     *
     *
     * 如果 x=−1x = -1x=−1，此时第 iii 位的结果应该是什么呢？可以发现，由于：
     *
     * −(−2)i=(−2)i+1+(−2)i -(-2)^i = (-2)^{i+1} + (-2)^i
     * −(−2)
     * i
     *  =(−2)
     * i+1
     *  +(−2)
     * i
     *
     * 等式左侧表示第 iii 位为 −1-1−1 的值，右侧表示第 iii 和 i+1i+1i+1 位为 111 的值。因此，第 iii 位的结果应当为 111，同时需要进位，将 carry\textit{carry}carry 置 111（注意这里不是 −1-1−1）。最终，carry\textit{carry}carry 的范围为 {−1,0,1}\{-1, 0, 1\}{−1,0,1}，会多出 x=3x=3x=3 的情况，但它与 x=2x=2x=2 的情况是一致的。
     * @param arr1
     * @param arr2
     * @return
     */
    public int [] addNegabinary(int [] arr1,int []arr2){

        List<Integer> ans  = new ArrayList<>();
        int remainder = 0;
        int i = arr1.length-1;
        int j = arr2.length-1;
        while (i>=0||j>=0|| remainder!=0){
            if(i>=0){
                remainder += arr1[i];
            }
            if(j>=0){
                remainder+= arr2[j];
            }

            if(remainder>=2){
                ans.add(remainder-2);
                remainder = -1;
            }else if(remainder>=1){
                ans.add(remainder);
                remainder = 0;
            }else {
                ans.add(1);
                remainder=1;
            }
            i--;
            j--;

        }
        //删除前导数
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }

        int [] arr = new int[ans.size()];
        for (int k = 0, y = ans.size()-1; k < ans.size(); k++,y--) {
            arr[k] = ans.get(y);
        }
        return arr;

    }


    public static ListNode recover(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



















    public int[] addNegabinary2(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) {
                x += arr1[i];
            }
            if (j >= 0) {
                x += arr2[j];
            }
            if (x >= 2) {
                ans.add(x - 2);
                //-w
                carry = -1;
            } else if (x >= 0) {
                ans.add(x);
                carry = 0;
            } else {
                ans.add(1);
                carry = 1;
            }
            --i;
            --j;
        }

        //这里的ans是逆序 最后一个是最高位 去除前导0
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        int[] arr = new int[ans.size()];
        for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
            arr[i] = ans.get(j);
        }
        return arr;
    }
}
