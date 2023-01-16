package LeetCode.DynamicProgramming.leetcode.editor.en.state_machine;

/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the iᵗʰ day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-
 * 2 = 2.
 *
 *
 * Example 2:
 *
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-
 * 2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0
 * = 3.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 *
 * Related Topics Array Dynamic Programming 👍 6024 👎 194
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer dp[][][];

    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length][2][k + 1];
        return findMaxProfit(prices, 0, 1, k);
    }

    private int findMaxProfit(int[] prices, int index, int isBuy, int k) {

        if (k == 0 || index == prices.length) return 0;
        if (dp[index][isBuy][k] != null) return dp[index][isBuy][k];

        /**
         * If isBuy= true
         * You have two choices:
         * 1.Buy the stock and go next index,(if it all we are buying we anticipate the bigger peak from the right side)
         * 2.Skip the buy
         *
         *
         */
        if (isBuy == 1) {
            dp[index][isBuy][k] = Math.max(findMaxProfit(prices, index + 1, 0, k) - prices[index],
                    findMaxProfit(prices, index + 1, 1, k));
            return dp[index][isBuy][k];
        } else {
            /**
             * If isBuy= false
             * You have two choices:
             * 1.Sell the stock and go next index with k= k-1
             * 2.Skip the sell
             *
             *
             */
            dp[index][isBuy][k] = Math.max(
                    findMaxProfit(prices, index + 1, 1, k - 1) + prices[index],
                    findMaxProfit(prices, index + 1, 0, k));
            return dp[index][isBuy][k];

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
