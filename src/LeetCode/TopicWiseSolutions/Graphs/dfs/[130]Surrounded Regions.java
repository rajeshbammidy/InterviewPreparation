package LeetCode.TopicWiseSolutions.Graphs.dfs;

import javafx.util.Pair;

import java.util.HashSet;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
 * "X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]
 * ]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 *
 *
 * Example 2:
 *
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 6470 👎 1423
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution130 {
    private HashSet<Pair<Integer, Integer>> visited;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    visited = new HashSet<Pair<Integer, Integer>>();
                    backtrack(i, j, board);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }

    }

    private void backtrack(int i, int j, char[][] board) {
        if (board[i][j] == 'X') return;

        visited.add(new Pair<>(i, j));
        int dx[] = new int[]{-1, 0, 1, 0};
        int dy[] = new int[]{0, 1, 0, -1};

        boolean isPossible = false;
        board[i][j] = '-';
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
