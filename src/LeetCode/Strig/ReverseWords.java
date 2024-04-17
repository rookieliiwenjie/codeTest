package LeetCode.Strig;


import LeetCode.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-13 17:04
 */
public class ReverseWords {
    /**
     * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
     * <p>
     * 说明：
     * <p>
     * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
     * 翻转后单词间应当仅用一个空格分隔。
     * 翻转后的字符串中不应包含额外的空格。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     * <p>
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
     * 示例 3：
     * <p>
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
     * 示例 4：
     * <p>
     * 输入：s = "  Bob    Loves  Alice   "
     * 输出："Alice Loves Bob"
     * 示例 5：
     * <p>
     * 输入：s = "Alice does not even like bob"
     * 输出："bob like even not does Alice"
     * <p>
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
     *
     * @param s 请尝试使用 O(1) 额外空间复杂度的原地解法。
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> strings = Arrays.asList(s.split(" "));
        String before = strings.get(strings.size() - 1);
        for (int i = strings.size() - 1; i >= 0; i--) {
            if (before.isEmpty()) {

            }
        }

        return String.join(" ", strings);

    }


    public String reverseWords2(String s) {
        s = s.trim();
        List<String> strings = Arrays.asList(s.split(" "));
        Collections.reverse(strings);
        return String.join(" ", strings);

    }


    public static String reverseWordsTwo(String s) {
        s = s.trim();
        List<String> strings = new ArrayList<>();
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                newString = newString + s.charAt(i);
            } else if (!newString.isEmpty()) {
                strings.add(newString);
                newString = "";
            }
        }
        if (!newString.isEmpty()) {
            strings.add(newString);
        }
        Collections.reverse(strings);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        threadPoolExecutor.
        return String.join(" ", strings);

    }

//    public static void main(String[] args) {
//        String s = reverseWordsTree("  the sky   is    blue  ");
//        System.out.println("s = " + s);
//    }

    public static String reverseWordsTree(String s) {
        List<String> strings = new ArrayList<>();
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!newString.isEmpty()) {
                    strings.add(newString);
                }
                newString = "";
            } else {
                newString = newString + s.charAt(i);
            }
        }
        if (!newString.isEmpty()) {
            strings.add(newString);
        }
        Collections.reverse(strings);
        return String.join(" ", strings);

    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 虚拟头结点 是这一类问题的一般做法
        ListNode vhead = new ListNode(-1);
        vhead.next = head;
        //前一个节点
        ListNode pre = vhead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //当前节点 2
        ListNode cur = pre.next;
        //下一个节点
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            //初始化next
            //3 = 2
            next = cur.next;
            //当前节点指向next的下一个节点\
            //3 = 4
            cur.next = next.next;
            //next指向pre的下一个节点
            //4 = 3
            next.next = pre.next;
            //pre指向next
            pre.next = next;
        }
        return vhead.next;
    }

    public static void main(String[] args) {
//        String s = reverseWordsTree("  the sky   is    blue  ");
//        System.out.println("s = " + s);
        ListNode listNode = new ListNode();
        listNode.setVal(1);
        ListNode listNode2 = new ListNode();
        listNode2.setVal(2);
        ListNode listNode3 = new ListNode();
        listNode3.setVal(3);
        ListNode listNode4 = new ListNode();
        listNode4.setVal(4);
        ListNode listNode5 = new ListNode();
        listNode5.setVal(5);
        ListNode listNode6 = new ListNode();
        listNode6.setVal(6);
        listNode5.next = listNode6;
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseBetween2(listNode,2,4);
        // copy(listNode);

    }
    public static ListNode reverseWordsFour(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummuNode = new ListNode(-1);//哨兵节点
        dummuNode.next = head;
        ListNode pre = dummuNode;
        for(int i = 0;i<left -1;i++){
            //pre移动left-1次，到达指定位置
            pre = pre.next;
        }
        //记录开始反转头节点 3
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0;i<right -left;i++){//以下代码需要自己动手画图，就很清楚了
           //  null = 4
            next = cur.next;//先变动next
            // 5=4
            cur.next = next.next;
            // 5 =3
            next.next = pre.next;
            //3 = 4
            pre.next = next;
        }

        return dummuNode.next;
    }
    public static ListNode copy(ListNode head){
        ListNode newNode = new ListNode();
        ListNode curr = head ;
        newNode.next = curr;
        while (curr!=null){
            curr=curr.next;
        }
        return newNode.next;
    }
    public static ListNode reverseWordsTwo(ListNode head,int left ,int right) {
        if(left==right){
            return head;
        }
        ListNode newLisNode = new ListNode();
        ListNode curr= head;
        newLisNode.next = curr;
        int num = 1;
        while (head != null) {
            ListNode pre = null;
            while (num>=left && num<=right){
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                num++;
            }
            if(pre!=null){
                curr.next = pre;
                pre = null;
            }else {
                curr = curr.next;
                head = head.next;
            }
            num++;
        }
        return newLisNode.next;

    }


    public static ListNode reverseListTwo(ListNode head,int left ,int right) {
        if(left==right){
            return head;
        }
        ListNode newLisNode = new ListNode();
        ListNode curr= head;
        newLisNode.next = curr;
        int num = 1;
        while (head != null) {
            ListNode pre = null;
            while (num>=left && num<=right){
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                num++;
            }
            if(pre!=null){
                curr.next = pre;
                pre = null;
            }else {
                curr = curr.next;
                head = head.next;
            }
            num++;
        }
        return newLisNode.next;

    }
}
