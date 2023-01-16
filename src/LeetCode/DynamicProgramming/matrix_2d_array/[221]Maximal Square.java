package LeetCode.DynamicProgramming.matrix_2d_array;

import java.util.Arrays;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1
 * "],["1","0","0","1","0"]]
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 *
 *
 * Related Topics Array Dynamic Programming Matrix 👍 8429 👎 179
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            if (dp[0][i] == 1) max = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            if (dp[i][0] == 1) max = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max * max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
