package LeetCode.DynamicProgramming.leetcode.editor.en.state_machine;

/**
 * You are given an array prices where prices[i] is the price of a given stock on
 * the iᵗʰ day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions
 * as you like (i.e., buy one and sell one share of the stock multiple times) with
 * the following restrictions:
 *
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 *
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 *
 * Example 2:
 *
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 *
 * Related Topics Array Dynamic Programming 👍 7883 👎 270
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution309 {
    Integer dp[][];

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return findMaxProfit(prices, 0, 1);
    }

    private int findMaxProfit(int[] prices, int index, int isBuy) {

        if (index >= prices.length) return 0;
        if (dp[index][isBuy] != null) return dp[index][isBuy];

        /**
         * If isBuy= true
         * You have two choices:
         * 1.Buy the stock and go next index,(if it all we are buying we anticipate the bigger peak from the right side)
         * 2.Skip the buy
         *
         *
         */
        if (isBuy == 1) {
            dp[index][isBuy] = Math.max(findMaxProfit(prices, index + 1, 0) - prices[index],
                    findMaxProfit(prices, index + 1, 1));
            return dp[index][isBuy];
        } else {
            /**
             * If isBuy= false
             * You have two choices:
             * 1.Sell the stock and go next index with index=index+2 (since there is a cool down period)
             * 2.Skip the sell
             *
             *
             */
            dp[index][isBuy] = Math.max(
                    findMaxProfit(prices, index + 2, 1) + prices[index],
                    findMaxProfit(prices, index + 1, 0));
            return dp[index][isBuy];

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
