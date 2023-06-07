package LeetCode.TopicWiseSolutions.Graphs.dfs;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (
 * representing land) connected 4-directionally (horizontal or vertical.) You may assume
 * all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,
 * 1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,
 * 0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-
 * directionally.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 8521 👎 191
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution695 {
    static int maxArea = 0;
    static int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        maxArea = 0;
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(count, maxArea);
                }

            }
        }
        return maxArea;

    }

    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        count++;
        int dirX[] = {0, -1, 0, 1};
        int dirY[] = {-1, 0, 1, 0};

        for (int k = 0; k < dirX.length; k++) {
            int nextRow = dirX[k] + i;
            int nextCol = dirY[k] + j;
            if (isValid(nextRow, nextCol, grid.length, grid[0].length) && grid[nextRow][nextCol] == 1) {
                dfs(grid, nextRow, nextCol);
            }

        }
    }

    private boolean isValid(int nextRow, int nextCol, int m, int n) {
        return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
