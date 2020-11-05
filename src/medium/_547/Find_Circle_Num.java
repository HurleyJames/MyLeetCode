package medium._547;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个N*N的矩阵M，表示班级中学生之间的的朋友关系。如果M[i][j]=1，表示已知第i个和第j个学生互为朋友关系，否则不是。
 * 输出所有学生中的已知的朋友圈关系。
 * 例如：
 * 输入：[[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出：2
 * 即第3个人与前两个人并不是朋友，具有自己的朋友圈，而前两个人处于同一个朋友圈
 */
public class Find_Circle_Num {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可寻找朋友总数
     *
     * @param M int整型二维数组
     * @return int整型
     */
    public int findCircleNum1(int[][] M) {
        // write code here
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param M
     * @param visited
     * @param i
     */
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param M
     * @return
     */
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            // 如果未被遍历到
            if (visited[i] == 0) {
                if (visited[i] == 0) {
                    // 加入到队列中
                    queue.add(i);
                    // 如果队列不为空
                    while (!queue.isEmpty()) {
                        int s = queue.remove();
                        visited[s] = 1;
                        for (int j = 0; j < M.length; j++) {
                            if (M[s][j] == 1 && visited[j] == 0) {
                                queue.add(j);
                            }
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    // TODO
    // 并查集的方法
}
