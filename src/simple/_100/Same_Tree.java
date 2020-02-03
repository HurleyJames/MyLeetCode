package simple._100;

import javax.swing.tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */

public class Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 递推
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

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

