package simple._112;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 */

public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        // 为叶子节点时
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
