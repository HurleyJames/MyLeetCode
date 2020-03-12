package simple._463;


/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 * <p>
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class Island_Perimeter {

    public int islandPerimeter(int[][] grid) {
        // 如果该矩阵为空
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 陆地的数量
        int land = 0;
        // 重叠的数量
        int overlap = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 规定数组元素为1时是陆地
                if (grid[i][j] == 1) {
                    land++;
                    // 分别找上下左右是否是陆地，如果是陆地就意味着有重合
                    // 纵向
                    // 因为判断下边，所以i要小于grid.length-1，不然就已经是最下边的元素了
                    if (i < grid.length - 1 && grid[i][j] == grid[i + 1][j]) {
                        overlap++;
                    }
                    // 横向
                    // 因为判断右边，所以j要小于grid[i].length-1，不然就已经是最右边的元素了
                    if (j < grid[i].length - 1 && grid[i][j] == grid[i][j + 1]) {
                        overlap++;
                    }
                }
            }
        }
        return 4 * land - 2 * overlap;
    }
}

















