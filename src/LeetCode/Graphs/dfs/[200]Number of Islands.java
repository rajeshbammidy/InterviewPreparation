package LeetCode.Graphs.dfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0
 * 's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 18619 👎 415
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                    islands++;
                }

            }
        }
        return islands;

    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int dirx[] = {0, 1, 0, -1};
        int diry[] = {-1, 0, 1, 0};

        for (int k = 0; k < dirx.length; k++) {
            int row = i + dirx[k];
            int col = j + diry[k];
            if (isValid(row, col, m, n) && grid[row][col] == '1') {
                grid[row][col] = '0';
                dfs(grid, row, col);
            }

        }
    }

    private boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
