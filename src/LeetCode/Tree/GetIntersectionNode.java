package LeetCode.Tree;

import LeetCode.list.ListNode;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/30 7:47 下午
 * @Description:
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        while (headA!=null){
            hashMap.putIfAbsent(headA,1);
            headA = headA.next;
            while (headA==null){
                if(hashMap.containsKey(headB.val)){
                    return headB;
                }
                headB =headB.next;
            }
        }
        return null;
    }
}
