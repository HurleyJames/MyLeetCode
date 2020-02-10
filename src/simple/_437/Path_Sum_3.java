package simple._437;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

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

        // 方法二
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        // 设置路径和符号条件即res+1的前提（0 = pathSum - sum）
//        map.put(0, 1);
//        return path(root, map, sum, 0);
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

    public int path(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }

        // 将当前所在节点的值加到走过的路径值的和中
        pathSum += root.val;
        // getOrDefault方法是返回指定键(Object key)所映射的值，若无则返回默认defaultValue
        // 累加到当前节点为止有多少条路径等于pathSum的个数
        res += map.getOrDefault(pathSum - sum, 0);
        // 计数到当前节点为止有多少条自上而下的节点路径等于pathSum，并将其存入map
        // = 更新pathSum对应的路径数，若先前有和值为pathSum的路径则取出其条数
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        // 往左子树以及右子树依次统计
        // 再加上res->到当前节点为止可能出现的和值符合pathSum的路径数（统计范围为头节点到当前节点）
        res = path(root.left, map, sum, pathSum) + path(root.right, map, sum, pathSum);
        // 在返回前，将到当前节点为止的和值pathSum的数量-1，防止影响后面其它未走完路径的统计
        // 因为路径只能从上至下，所以节点返回条件为下一节点为空，即为最后节点或者最后节点返回后遍历完依次往上递归返回
        // 返回就意味着pathSum到当前节点已自上而下的累加遍历完
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
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
