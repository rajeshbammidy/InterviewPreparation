package LeetCode.DynamicProgramming.lis_variants;

/**
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 * length is 4.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 2500
 * -10⁴ <= nums[i] <= 10⁴
 *
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 *
 * Related Topics Array Binary Search Dynamic Programming 👍 15935 👎 293
 */

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution300 {
    /**
     * O(n^2) approach:
     *
     * public int lengthOfLIS(int[] nums) {
     * int dp[] = new int[nums.length];
     * TopicWiseSolutions.Strings.Arrays.fill(dp, 1);
     * int maxLen = 1;
     * for (int i = 0; i < dp.length; i++) {
     * for (int j = 0; j < i; j++) {
     * if (nums[j] < nums[i]) {
     * dp[i] = TopicWiseSolutions.Strings.Math.max(dp[i], dp[j] + 1);
     * maxLen = TopicWiseSolutions.Strings.Math.max(dp[i], maxLen);
     * }
     * }
     * }
     * return maxLen;
     *
     * }
     */

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = Collections.binarySearch(dp, nums[i]);
            index = index < 0 ? Math.abs((index + 1)) : index;
            if (index >= dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(index, nums[i]);
            }

        }

        return dp.size();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
