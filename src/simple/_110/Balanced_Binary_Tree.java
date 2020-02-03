package simple._110;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

public class Balanced_Binary_Tree {

    boolean bool = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return bool;
    }

    /**
     * 对二叉树进行深度优先遍历 DFS
     *
     * @param root
     * @return
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        if (Math.abs(right - left) > 1) {
            bool = false;
        }
        // 返回 root 节点的左右子树最大的一个值（因为有些子树可能没有左节点，所以需要返回左右节点的最大值）
        return Math.max(left, right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            x = val;
        }
    }
}
