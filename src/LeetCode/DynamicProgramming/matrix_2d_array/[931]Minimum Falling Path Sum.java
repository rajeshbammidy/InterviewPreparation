package LeetCode.DynamicProgramming.matrix_2d_array;

import java.util.Arrays;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling
 * path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row
 * + 1, col), or (row + 1, col + 1).
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 *
 *
 *
 * Constraints:
 *
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 *
 * Related Topics Array Dynamic Programming Matrix 👍 4346 👎 118
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        dp[0] = matrix[0].clone();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[i][j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int middle = Integer.MAX_VALUE;

                if (j - 1 >= 0) {
                    left = current + dp[i - 1][j - 1];
                }
                if (j + 1 < n) {
                    right = current + dp[i - 1][j + 1];
                }
                middle = current + dp[i - 1][j];

                dp[i][j] = Math.min(Math.min(left, right), middle);

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m - 1][i], min);
        }
        return min;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
