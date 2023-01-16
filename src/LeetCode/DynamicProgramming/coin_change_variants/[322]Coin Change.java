package LeetCode.DynamicProgramming.coin_change_variants;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * Example 1:
 *
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 *
 * Example 2:
 *
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Example 3:
 *
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2³¹ - 1
 * 0 <= amount <= 10⁴
 *
 *
 * Related Topics Array Dynamic Programming Breadth-First Search 👍 14896 👎 343
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {
    Integer dp[][];

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        System.out.println(Integer.MAX_VALUE);
        int value = findMinCoins(0, coins, amount);
        return value == Integer.MAX_VALUE - 1 ? -1 : value;

    }

    private int findMinCoins(int i, int[] coins, int amount) {
        if (i == coins.length && amount > 0) return Integer.MAX_VALUE - 1;
        if (amount == 0 || i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int min = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            min = Math.min(
                    1 + findMinCoins(i, coins, amount - coins[i]),
                    findMinCoins(i + 1, coins, amount)
            );
        } else {
            min = findMinCoins(i + 1, coins, amount);
        }
        dp[i][amount] = min;
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
