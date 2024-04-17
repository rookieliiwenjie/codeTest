package LeetCode.Tree;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 2:50 下午
 * @Description:
 */
public class BuildTree {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    /**
     * 先 中
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public static TreeNode build(int[] preorder, int preLeftIndex, int preRightIndex, int[] inorder, int inLeftIndex, int inRightIndex) {
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[preLeftIndex];
        int inRootIndex = hashMap.get(root.val);
        int leftLeght =inRootIndex - inLeftIndex ;
        root.left = build(preorder, preLeftIndex + 1, preLeftIndex + leftLeght, inorder, inLeftIndex, inRightIndex - 1);
        root.right = build(preorder, preLeftIndex + leftLeght + 1, preRightIndex, inorder, inRootIndex + 1, inRightIndex);
        return root;
    }
}
