package simple._572;

import javax.swing.tree.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 */
public class Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preOrder(s, true);
        String tree2 = preOrder(t, true);
        if (tree1.contains(tree2)) {
            return true;
        } else {
            return false;
        }

//        return traverse(s, t);
    }

    private String preOrder(TreeNode node, boolean left) {
        if (node == null) {
            // 如果是左孩子节点为空
            if (left) {
                // 设置为 lnull
                return "lnull";
            } else {
                // 右孩子节点为空，设置为 rnull
                return "rnull";
            }
        }
        // 给每个节点前加上 # 号
        // 如果 preOrder 的第一个参数是 left，那么就是 true
        // 如果 preOrder 的第一个参数是 right，那么就是 false
        return "#" + node.val + " " + preOrder(node.left, true) + " " + preOrder(node.right, false);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    /**
     * 比较两个树是否相同
     *
     * @param t1
     * @param t2
     * @return
     */
    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // 如果节点值相同，且左孩子和右孩子的节点值也相同，则返回 true
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
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
