package LeetCode.Graphs.leetcode.editor.en.dfs;

import javafx.util.Pair;

import java.util.HashSet;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4-
 * directionally connected group of 0s and a closed island is an island totally (
 * all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,
 * 1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (
 * group of 1s).
 *
 * Example 2:
 *
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 2689 👎 69
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                        dfs(grid, i, j);
                    }
                }
            }
        }
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    dfs(grid, i, j);
                    islands++;
                }

            }
        }
        return islands;

    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int dirx[] = {0, 1, 0, -1};
        int diry[] = {-1, 0, 1, 0};

        for (int k = 0; k < dirx.length; k++) {
            int row = i + dirx[k];
            int col = j + diry[k];
            if (isValid(row, col, m, n) && grid[row][col] == 0) {
                grid[row][col] = 1;
                dfs(grid, row, col);
            }

        }
    }

    private boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
