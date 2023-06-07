package LeetCode.TopicWiseSolutions.DynamicProgramming.coin_change_variants;

/**
 * Given an integer n, return the least number of perfect square numbers that sum
 * to n.
 *
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
 * are perfect squares while 3 and 11 are not.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10⁴
 *
 *
 * Related Topics TopicWiseSolutions.Strings.Math Dynamic Programming Breadth-First Search 👍 8913 👎 388
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution279 {
    public int numSquares(int n) {
        if (n <= 3) return n;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }

        }
        return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
