package LeetCode.TopicWiseSolutions.DynamicProgramming.state_machine;

/**
 * You are given an array prices where prices[i] is the price of a given stock on
 * the iᵗʰ day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions
 * as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 *
 * Example 2:
 *
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 5 * 10⁴
 * 1 <= prices[i] < 5 * 10⁴
 * 0 <= fee < 5 * 10⁴
 *
 *
 * Related Topics Array Dynamic Programming TopicWiseSolutions.Greedy 👍 4967 👎 122
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution714 {
    Integer dp[][];
    static int transFee;

    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        transFee = fee;
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
             * 1.Sell the stock and go next index with index=index+1
             * 2.Skip the sell
             *
             *
             */
            dp[index][isBuy] = Math.max(
                    findMaxProfit(prices, index + 1, 1) + prices[index] - transFee,
                    findMaxProfit(prices, index + 1, 0));
            return dp[index][isBuy];

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
