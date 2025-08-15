package LeetCode.list;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
 * skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为
 * [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例2：
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 * 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
 * [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为
 * 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160
 * 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-09-27 11:18
 */
public class GetIntersectionNode {
    /**
     * listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(0);
        ListNode listNodeA1 = new ListNode(9);
        listNodeA.next = listNodeA1;
        ListNode listNode2 = new ListNode(1);
        listNodeA1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNodeBpre = new ListNode(3);

        ListNode listNodeB = new ListNode(3);
        listNodeBpre.next = listNodeB;
        ListNode listNodeB1 = new ListNode(2);
        listNodeB.next = listNodeB1;
        ListNode listNodeB2 = new ListNode(4);
        listNodeB1.next = listNodeB2;
        getIntersectionNodeTwo(listNodeA, listNodeBpre);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNode = null;
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                if (listNode != null) {
                    listNode.next = headA;

                } else {
                    listNode = headA;
                }
            }
            headA = headA.next;
            headB = headB.next;
        }
        return listNode;
    }

    public static ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        /**
         * 每步操作需要同时更新指针 pA 和 pB。
         * 如果指针 pA 不为空，则将指针 pA 移到下一个节点；如果指针 pB 不为空
         * ，则将指针 pB 移到下一个节点。
         * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，
         * 则将指针 pB 移到链表headA 的头节点。
         * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
         *
         */
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNodeThree(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pb = headB;
        while (pA != pb) {
            pA = pA == null ? headB : pA.next;
            pb = pb == null ? headA : pb.next;

        }
        return pA;

    }
    public static ListNode getIntersectionNodeFour(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pb = headB;
        while (pA != pb) {
            pA = pA == null ? headB : pA.next;
            pb = pb == null ? headA : pb.next;

        }
        return pA;

    }
}
