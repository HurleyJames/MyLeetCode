package medium._785;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 */

public class Is_Graph_Bipartite {

    public static boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int n = graph.length;
        // 设置 color 数组，0 表示未着色，1 黑，2 红
        int[] colors = new int[n];
        // 将 color 数组中的所有元素的值设置为 0，表示未着色
        Arrays.fill(colors, 0);
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, i, colors, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int[][] graph, int i, int[] colors, int preColor) {
        // 如果未被染色
        if (colors[i] == 0) {
            // 与相邻节点进行相反的染色
            colors[i] = (preColor == 1) ? 2 : 1;
            for (int j = 0; j < graph[i].length; j++) {
                // 如果不能够再往下递推
                if (!dfs(graph, graph[i][j], colors, colors[i])) {
                    return false;
                }
            }
            return true;
        } else {
            // 已染色
            // 如果颜色和邻接点颜色一致
            if (colors[i] == preColor) {
                return false;
            } else {
                return true;
            }
        }
    }
}
