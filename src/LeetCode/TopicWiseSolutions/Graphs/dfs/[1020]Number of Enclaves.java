package LeetCode.TopicWiseSolutions.Graphs.dfs;

import javafx.util.Pair;

import java.util.HashSet;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
 * represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-
 * directionally) land cell or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not
 * enclosed because its on the boundary.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 2108 👎 40
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * Intuition: Start traversing from the boundaries and mark all the connected 1 cells with some placeholder value say -1.This implies that these
     * 1's can be never be included in the answer since they are situated at the boundary.
     *
     * Now we can simply count the leftover ones.
     */
    private HashSet<Pair<Integer, Integer>> visited;

    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    visited = new HashSet<Pair<Integer, Integer>>();
                    backtrack(i, j, board);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) board[i][j] = ans++;
            }
        }
        return ans;
    }

    private void backtrack(int i, int j, int[][] board) {
        if (board[i][j] == 0) return;

        visited.add(new Pair<>(i, j));
        int dx[] = new int[]{-1, 0, 1, 0};
        int dy[] = new int[]{0, 1, 0, -1};

        board[i][j] = -1;
        for (int k = 0; k < dx.length; k++) {
            int row = dx[k] + i;
            int col = dy[k] + j;
            boolean isValidMove = isValid(row, col, board.length, board[0].length);
            if (isValidMove && !visited.contains(new Pair<>(row, col))) {
                backtrack(row, col, board);
            }

        }
    }

    private boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
