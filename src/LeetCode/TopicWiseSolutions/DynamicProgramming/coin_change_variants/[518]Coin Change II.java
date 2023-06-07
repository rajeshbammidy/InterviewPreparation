package LeetCode.TopicWiseSolutions.DynamicProgramming.coin_change_variants;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 * Example 1:
 *
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *
 * Example 2:
 *
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 *
 * Example 3:
 *
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 *
 *
 * Related Topics Array Dynamic Programming 👍 6642 👎 120
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution518 {
    Integer dp[][];

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        int numOfWays = getNumberOfWays(0, coins, amount);
        return numOfWays;

    }

    private int getNumberOfWays(int i, int[] coins, int amount) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];

        int waysIncludingCurrentIndex = 0;
        int waysExcludingCurrentIndex = 0;
        /**
         *  Include the current element any number of times
         */
        if (coins[i] <= amount)
            waysIncludingCurrentIndex = getNumberOfWays(i, coins, amount - coins[i]);
        /**
         * Do not include the current element
         */
        waysExcludingCurrentIndex = getNumberOfWays(i + 1, coins, amount);

        int total = waysIncludingCurrentIndex + waysExcludingCurrentIndex;
        dp[i][amount] = total;
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
