package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given a rectangular pizza represented as a rows x cols matrix containing the
 * following characters: 'A' (an apple) and '.' (empty cell) and given the integer k.
 * You have to cut the pizza into k pieces using k-1 cuts.
 *
 * For each cut you choose the direction: vertical or horizontal, then you choose
 * a cut position at the cell boundary and cut the pizza into two pieces. If you
 * cut the pizza vertically, give the left part of the pizza to a person. If you cut
 * the pizza horizontally, give the upper part of the pizza to a person. Give the
 * last piece of pizza to the last person.
 *
 * Return the number of ways of cutting the pizza such that each piece contains
 * at least one apple. Since the answer can be a huge number, return this modulo 10^9
 * + 7.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: pizza = ["A..","AAA","..."], k = 3
 * Output: 3
 * Explanation: The figure above shows the three ways to cut the pizza. Note that
 * pieces must contain at least one apple.
 *
 *
 * Example 2:
 *
 *
 * Input: pizza = ["A..","AA.","..."], k = 3
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: pizza = ["A..","A..","..."], k = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza consists of characters 'A' and '.' only.
 *
 *
 * Related Topics Array Dynamic Programming Memoization Matrix 👍 751 👎 43
 */

class NumberOfWaysOfCuttingAPizza {


    public static void main(String args[]) {
        Solution solution = new NumberOfWaysOfCuttingAPizza().new Solution();
        System.out.println(solution.ways(new String[]{"A..", "AAA", "..."}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = (int) (1e9 + 7);

        public int ways(String[] pizza, int k) {

            return (int) findWays(pizza, 0, 0, pizza.length - 1, pizza[0].length() - 1, k - 1);

        }

        private long findWays(String[] pizza, int startRow, int startCol, int endRow, int endCol, int cuts) {
            if (startRow > endRow || startCol > endCol) return 0;

            if (cuts == 0) {
                for (int i = startRow; i <= endRow; i++) {
                    for (int j = startCol; j <= endCol; j++) {
                        if (pizza[i].charAt(j) == 'A') return 1;

                    }
                }
                return 0;
            }

            long ans = 0;
            long horizCut = 0;
            long vertiCut = 0;
            for (int i = startRow; i <= endRow; i++) {
                if (isApplePresentInRow(pizza, i, startCol, endCol)) {
                    horizCut = findWays(pizza, i + 1, startCol, endRow, endCol, cuts - 1);
                    ans += horizCut;
                    ans %= MOD;
                }
            }

            for (int i = startCol; i <= endCol; i++) {
                if (isApplePresentInCol(pizza, startRow, i, endRow)) {
                    vertiCut = findWays(pizza, startRow, i + 1, endRow, endCol, cuts - 1);
                    ans += vertiCut;
                    ans %= MOD;
                }
            }
            return ans;
        }

        private boolean isApplePresentInCol(String[] pizza, int startRow, int col, int endRow) {
            for (int i = startRow; i <= endRow; i++) {
                if (pizza[startRow].charAt(col) == 'A') return true;

            }
            return false;
        }

        private boolean isApplePresentInRow(String[] pizza, int row, int col, int endCol) {
            for (int i = col; i <= endCol; i++) {
                if (pizza[row].charAt(i) == 'A') return true;

            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
