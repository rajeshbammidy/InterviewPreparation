package LeetCode.MonthlyChallenges_23.Jan23;

/**
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [5], k = 9
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 3 * 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * 2 <= k <= 10⁴
 *
 *
 * Related Topics Array Hash Table Prefix Sum 👍 5199 👎 199
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count[] = new int[k];
        int sum = 0;
        for (int x : nums) {
            sum = (sum % k + (x % k + k) % k) % k;
            sum = sum % k;
            count[sum]++;
        }
        int total = count[0];
        for (int i = 0; i < count.length; i++) {
            total += ((count[i] * (count[i] - 1)) / 2);
        }
        return total;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
