package LeetCode.TopicWiseSolutions.DynamicProgramming.partition_subset; /**
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the sum of the elements in both subsets is equal or false
 * otherwise.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 *
 * Related Topics Array Dynamic Programming 👍 9588 👎 160
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        /**
         * If the sum is odd, return false;
         */
        if ((sum & 1) != 0) return false;
        int half = sum / 2;
        /**
         * Check if the sum/2 can be obtained using subset
         */
        return checkIfSubsetSumPossible(nums, half);

    }

    private boolean checkIfSubsetSumPossible(int[] nums, int sum) {
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
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
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
