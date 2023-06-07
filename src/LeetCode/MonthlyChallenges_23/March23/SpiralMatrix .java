package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 *
 * Related Topics Array Matrix Simulation 👍 11760 👎 1063
 */

import java.util.*;

class SpiralMatrix {
    public static void main(String args[]) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> list = new ArrayList<>();
            int startRow = 0;
            int startCol = 0;
            int endCol = matrix[0].length - 1;
            int endRow = matrix.length - 1;

            while (startRow <= endRow && startCol <= endCol) {
                //startFirstRow
                for (int i = startCol; i <= endCol; i++) {
                    list.add(matrix[startRow][i]);

                }
                    if(startRow==endRow)return list;
                //endColumn
                for (int i = startRow + 1; i <= endRow; i++) {
                    list.add(matrix[i][endCol]);

                }
                    if(startCol==endCol)return list;

                //lastRow
                for (int i = endCol - 1; i >= startCol; i--) {
                    list.add(matrix[endRow][i]);

                }


                //firstCol
                for (int i = endRow - 1; i > startRow; i--) {
                    list.add(matrix[i][startCol]);

                }
                System.out.println(list);
                startRow++;
                startCol++;
                endRow--;
                endCol--;

            }

            return list;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
