package simple._226;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

/**
 * Invert a binary tree.
 */

public class Invert_Binary_Tree {

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每次从队列中拿出一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            swap(tmp);
            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            // 如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树节点
        swap(root);
        // 递归当前节点的左子树
        invertTree2(root.right);
        // 递归当前节点的右子树
        invertTree2(root.left);
        return root;
    }

    /**
     * 交换左右子树节点
     *
     * @param root
     */
    public void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
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
