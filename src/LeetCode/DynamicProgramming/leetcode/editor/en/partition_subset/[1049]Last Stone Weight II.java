package LeetCode.DynamicProgramming.leetcode.editor.en.partition_subset;

import java.util.Arrays;

/**
 * You are given an array of integers stones where stones[i] is the weight of the
 * iᵗʰ stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones
 * and smash them together. Suppose the stones have weights x and y with x <= y.
 * The result of this smash is:
 *
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has
 * new weight y - x.
 *
 *
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones
 * left, return 0.
 *
 *
 * Example 1:
 *
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the
 * optimal value.
 *
 *
 * Example 2:
 *
 *
 * Input: stones = [31,26,33,21,40]
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 *
 * Related Topics Array Dynamic Programming 👍 2561 👎 89
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1049 {
    /**
     * Declare the dp array globally
     */
    static boolean dp[][];

    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        /**
         * Find the totalSum of elements in the stones array
         */
        for (int x : stones) totalSum += x;
        /**
         * Since we would have to check if subset till half of the total sum.
         * Remember the equation (2*s1-totalSum)
         */
        int half = totalSum / 2;
        dp = new boolean[stones.length + 1][half + 1];

        findSubsetSumPossible(stones, half);
        /**
         * Find min difference from the following eq:(2 * s1 - totalSum)
         */
        int minDiff = Integer.MAX_VALUE;
        int m = dp.length;
        for (int i = 0; i <= half; i++) {
            if (dp[m - 1][i])
                minDiff = Math.min(minDiff, Math.abs(2 * i - totalSum));
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;


    }

    private void findSubsetSumPossible(int[] nums, int sum) {
        int m = dp.length;
        int n = dp[0].length;
        Arrays.fill(dp[0], false);
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
