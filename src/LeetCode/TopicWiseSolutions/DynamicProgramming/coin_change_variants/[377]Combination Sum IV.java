package LeetCode.TopicWiseSolutions.DynamicProgramming.coin_change_variants;

/**
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 *
 *
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to allow
 * negative numbers?
 *
 * Related Topics Array Dynamic Programming 👍 5402 👎 556
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution377 {
    Integer dp[];

    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        return getCombinations(nums, target);

    }

    private int getCombinations(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (dp[target] != null) {
            return dp[target];
        }
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            int inc = 0;
            if (nums[j] <= target) {
                inc = getCombinations(nums, target - nums[j]);
            }
            sum += inc;
        }
        dp[target] = sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
