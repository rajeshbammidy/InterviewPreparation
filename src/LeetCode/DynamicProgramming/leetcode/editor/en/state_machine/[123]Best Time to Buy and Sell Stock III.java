package LeetCode.DynamicProgramming.leetcode.editor.en.state_machine;

import java.util.PriorityQueue;

/**
 * You are given an array prices where prices[i] is the price of a given stock on
 * the iᵗʰ day.
 *
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-
 * 0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 *
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-
 * 1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying
 * again.
 *
 *
 * Example 3:
 *
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 *
 *
 * Related Topics Array Dynamic Programming 👍 7589 👎 145
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution123 {
    Integer dp[][][];

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return findMaxProfit(prices, 0, 1, 2);

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
