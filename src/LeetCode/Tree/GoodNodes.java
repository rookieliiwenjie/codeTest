package LeetCode.Tree;

public class GoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode lefet = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(5);
        root.setLeft(lefet);
        root.setRight(right);
        lefet.setLeft(left1);
        right.setLeft(right1);
        right.setRight(left2);
//        TreeNode root = new TreeNode(3);
//        TreeNode lefet = new TreeNode(3);
//        TreeNode left1 = new TreeNode(4);
//        TreeNode  right= new TreeNode(2);
//        root.setLeft(lefet);
//        root.setRight(right);
//        lefet.setLeft(left1);

//        TreeNode root = new TreeNode(9);
//        TreeNode right = new TreeNode(3);
//        TreeNode left1 = new TreeNode(6);
//        right.left = left1;
//        root.right= right;
        GoodNodes goodNodes = new GoodNodes();
        System.out.println(goodNodes.goodNodes(root));
    }

    public int goodNodes2(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int pathMax) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= pathMax) {
            res++;
            pathMax = root.val;
        }
        res += dfs(root.left, pathMax) + dfs(root.right, pathMax);
        return res;
    }

    public int sum = 1;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getNodes(root, Integer.MIN_VALUE);
        return sum;
    }

    public int getNodes3(TreeNode node, Integer max) {
        if (node == null) {
            return 0;
        }
        if (node.val >= max) {
            return 1 + getNodes3(node.left, node.val) + getNodes3(node.right, node.val);
        }
        return getNodes3(node.left, max) + getNodes3(node.right, max);
    }

    public void getNodes(TreeNode node, int max) {

        max = Math.max(node.val, max);
        if (node.left != null) {
            if (node.left.val >= max) {
                sum++;
                getNodes(node.left, node.left.val);
            } else {
                getNodes(node.left, max);
            }
        }
        if (node.right != null) {
            if (node.right.val >= max) {
                sum++;
                getNodes(node.right, node.right.val);
            } else {
                getNodes(node.right, max);
            }
        }
    }
}
