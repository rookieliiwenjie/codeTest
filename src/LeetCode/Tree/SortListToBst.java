package LeetCode.Tree;

import LeetCode.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 3:58 下午
 * @Description:
 */
public class SortListToBst {
    /**
     * 1.高度平衡如何解决---
     * 2、
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head){
        List<Integer>  list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        //因为左右平衡所以是不是左右都要是相同数量
        return myBuildTree(list.subList(0,list.size()/2),0,list.size()/2,list.subList(list.size()/2+1,list.size()),list.size()/2+1,list.size()-1);
    }
    public static  TreeNode myBuildTree(List<Integer> list,int leftIndex,int leftRightIndex ,List<Integer> right ,int rightLeftIndex,int rightRightIndex){
        if(leftIndex>leftRightIndex){
            return null;
        }
        TreeNode treeNode = new TreeNode(list.get(leftRightIndex));
        treeNode.left =myBuildTree(list.subList(0,list.size()/2),0,list.size()/2,right.subList(rightLeftIndex,right.size()/2),rightLeftIndex,right.size()-1);
        treeNode.right=myBuildTree(list.subList(0,list.size()/2),0,list.size()/2,right.subList(right.size()/2+1,list.size()),right.size()/2+1,right.size()-1);
        return treeNode;

    }


    /**
     * 中序遍历 升序的nums
     * 而且还是二叉搜索数
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int nums[]){
        TreeNode leftNode = new TreeNode();
        TreeNode rightNode = new TreeNode();
        TreeNode root = new TreeNode();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        myBuildTree2(list,0,nums.length-1);
        return root;
    }

    public static  TreeNode myBuildTree2(List<Integer> list,int leftIndex,int leftRightIndex){
        if(leftIndex>leftRightIndex){
            return null;
        }
        TreeNode treeNode = new TreeNode(list.get(leftRightIndex));
        return treeNode;

    }


}
