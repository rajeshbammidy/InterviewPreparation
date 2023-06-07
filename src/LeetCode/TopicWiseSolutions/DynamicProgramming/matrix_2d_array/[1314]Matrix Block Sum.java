package LeetCode.TopicWiseSolutions.DynamicProgramming.matrix_2d_array;

/**
 * Given a m x n matrix mat and an integer k, return a matrix answer where each
 * answer[i][j] is the sum of all elements mat[r][c] for:
 *
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k, and
 * (r, c) is a valid position in the matrix.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 *
 *
 * Example 2:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 *
 *
 * Related Topics Array Matrix Prefix Sum 👍 2031 👎 318
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int cumSum[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            cumSum[0][i] = mat[0][i];
        }
        /**
         * Row-wise sum
         */
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cumSum[i][j] = mat[i][j] + cumSum[i - 1][j];
            }
        }
        /**
         * Column-wise sum to build cumulative sum matrix
         */
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cumSum[i][j] += cumSum[i][j - 1];
            }
        }

        int ans[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int tr = i - k;
                int br = i + k;
                int lc = j - k;
                int rc = j + k;

                /**
                 * If bottomRow exceeds number of rows make it equal to m-1
                 */
                if (br >= m) {
                    br = (m - 1);
                }
                /**
                 * If right column exceeds number of columns make it equal to n-1
                 */
                if (rc >= n) {
                    rc = (n - 1);
                }
                if (lc < 0) lc = 0;
                if (tr < 0) tr = 0;
                /**
                 * cumSum[br][rc] holds the total sum from 0,0 to br,rc
                 */
                int bottomRightTotal = cumSum[br][rc];
                int topRightDelete = 0;
                if (tr - 1 >= 0 && rc < n) {
                    topRightDelete = cumSum[tr - 1][rc];
                }
                int bottomLeftToDelete = 0;
                if (br < m && lc - 1 >= 0) {
                    bottomLeftToDelete = cumSum[br][lc - 1];
                }
                int diagonalDelete = 0;
                if (tr - 1 >= 0 && lc - 1 >= 0) {
                    diagonalDelete = cumSum[tr - 1][lc - 1];
                }

                ans[i][j] = bottomRightTotal + diagonalDelete - topRightDelete - bottomLeftToDelete;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
