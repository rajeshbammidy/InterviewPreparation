package LeetCode.Jan23.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer array nums, find a subarray that has the largest product, and
 * return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 2 * 10⁴
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 *
 *
 * Related Topics Array Dynamic Programming 👍 14774 👎 439
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution152 {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            int temp = max;
            max = Math.max(Math.max(max * x, min * x), x);
            min = Math.min(Math.min(temp * x, min * x), x);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
