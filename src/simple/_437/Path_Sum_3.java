package simple._437;

import javax.swing.tree.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class Path_Sum_3 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 找出根节点的所有路径，再找出以根节点的左孩子和右孩子开始的所有路径
        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int path(TreeNode root, int sum) {

        int pathSum = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            pathSum++;
        }

        pathSum = pathSum + path(root.left, sum - root.val);
        pathSum = pathSum + path(root.right, sum - root.val);

        return pathSum;

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
