package LeetCode.DynamicProgramming.leetcode.editor.en.matrix_2d_array;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 *
 * Implement the NumMatrix class:
 *
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix
 * matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the
 * elements of matrix inside the rectangle defined by its upper left corner (row1,
 * col1) and lower right corner (row2, col2).
 *
 *
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3,
 * 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 * Output
 * [null, 8, 11, 12]
 *
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0,
 * 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -10⁴ <= matrix[i][j] <= 10⁴
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * At most 10⁴ calls will be made to sumRegion.
 *
 *
 * Related Topics Array Design Matrix Prefix Sum 👍 4179 👎 315
 */

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int cumSum[][];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        cumSum = new int[m][n];
        for (int i = 0; i < n; i++) {
            cumSum[0][i] = matrix[0][i];
        }
        /**
         * Row-wise sum
         */
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cumSum[i][j] = matrix[i][j] + cumSum[i - 1][j];
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

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int m = cumSum.length;
        int n = cumSum[0].length;

        /**
         * topRow and RightColumn gives you the same of all elements till [row1 - 1,col2]
         */
        int tr = row1 - 1;
        int rc = col2;

        /**
         * bottomRow and leftColumn gives you the same of all elements till [row2, col1 - 1]
         */

        int br = row2;
        int lc = col1 - 1;

        int bottomRightTotal = cumSum[br][rc];
        int topRightDelete = 0;
        if (tr >= 0 && rc < n) {
            topRightDelete = cumSum[tr][rc];
        }
        int bottomLeftToDelete = 0;
        if (br < m && lc >= 0) {
            bottomLeftToDelete = cumSum[br][lc];
        }
        int diagonalDelete = 0;
        if (tr >= 0 && lc >= 0) {
            diagonalDelete = cumSum[tr][lc];
        }
        return bottomRightTotal + diagonalDelete - topRightDelete - bottomLeftToDelete;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)