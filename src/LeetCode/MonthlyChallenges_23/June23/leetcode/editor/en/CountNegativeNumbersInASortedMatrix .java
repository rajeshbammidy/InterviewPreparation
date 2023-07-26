package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise
 * and column-wise, return the number of negative numbers in grid.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 *
 * Follow up: Could you find an
 * O(n + m) solution?
 *
 * Related Topics Array Binary Search Matrix 👍 3680 👎 99
 */

import java.util.*;

class CountNegativeNumbersInASortedMatrix {
    public static void main(String args[]) {
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int srow = 0;
            int scol = n - 1;
            int count = 0;
            while (srow < m && scol >= 0) {
                if (grid[srow][scol] < 0) {
                    count += (m - srow);
                    scol--;
                } else {
                    srow++;
                }
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
