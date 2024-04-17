package LeetCode;

import LeetCode.list.ListNode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/8 7:02 下午
 * @Description:
 */
public class IsPalindrome {
    private static ListNode frontPoniter;
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        ListNode head2 = new ListNode();
        head2.val =2;
        head.next = head2;
        ListNode head3 = new ListNode();
        head3.val =3;
        head2.next = head3;
        ListNode head4 = new ListNode();
        head3.next = head4;
        head4.val=4;
        ListNode head5 = new ListNode();
        head5.val=5;
        head4.next = head5;
        System.out.println("head5 = " + isPalindromeDiGui(head));
       // System.out.println("head5 = " + isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head){
//        ListNode pre = null;
//        ListNode cr = head;
//        int num = 0;
//        while (cr != null) {
//            ListNode next = cr.next;
//            cr.next = pre;
//            pre = cr;
//            cr = next;
//            num++;
//        }
        ListNode cr = new ListNode();
        cr = head;
        ListNode revoer = revoer(cr);
        System.out.println("revoer = " + revoer);
        int index = 0;
//        while (head != null && pre != null && index <= (num / 2)) {
//            if (head.val != pre.val) {
//                return false;
//            }
//            head = head.next;
//            pre = pre.next;
//            index++;
//        }
//        return index == (num / 2);
        return true;

    }

    public static ListNode revoer(ListNode head){
        ListNode pre = null;
        ListNode cr = head;
        int num = 0;
        while (cr != null) {
            ListNode next = cr.next;
            cr.next = pre;
            pre = cr;
            cr = next;
            num++;
        }
        return pre;

    }

    public static boolean isPalindromeDiGui(ListNode head){
        frontPoniter = head;
        return checkPai(head);
    }

    public static  boolean checkPai(ListNode curron){
        //当到了尾部返回true，就是false!checkPai(curron.next)可以开始比较了
        //只要右一个为false就为false了
        if(curron!=null){
            if(!checkPai(curron.next)){
                return false;
            }
            if(curron.val != frontPoniter.val){
                return false;
            }
            frontPoniter = frontPoniter.next;
        }
        return true;
    }

}
