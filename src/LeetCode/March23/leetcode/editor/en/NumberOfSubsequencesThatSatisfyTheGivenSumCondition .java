package LeetCode.FEB23.leetcode.editor.en;

/**
 * You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the
 * minimum and maximum element on it is less or equal to target. Since the answer
 * may be too large, return it modulo 10⁹ + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [3,5,6,7], target = 9
 * Output: 4
 * Explanation: There are 4 subsequences that satisfy the condition.
 * [3] -> Min value + max value <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [3,3,6,8], target = 10
 * Output: 6
 * Explanation: There are 6 subsequences that satisfy the condition. (nums can
 * have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [2,3,3,4,6,7], target = 12
 * Output: 61
 * Explanation: There are 63 non-empty subsequences, two of them do not satisfy
 * the condition ([6,7], [7]).
 * Number of valid subsequences (63 - 2 = 61).
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁶
 * 1 <= target <= 10⁶
 *
 *
 * Related Topics Array Two Pointers Binary Search TopicWiseSolutions.Strings.Sorting 👍 2096 👎 188
 */

import java.util.*;

class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static void main(String args[]) {
        Solution solution = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            int i = 0;
            int j = nums.length - 1;
            int[] pows = new int[j + 1];
            pows[0] = 1;
            int mod = (int) (1e9 + 7);
            for (int k = 1; k <= j; ++k)
                pows[k] = pows[k - 1] * 2 % mod;
            long count = 0;
            long power2 = 2;
            while (i <= j) {
                if (nums[i] + nums[j] > target) {
                    j--;
                } else {
                    long value = pows[j-i];
                    count = (count % mod + value % mod) % mod;
                    i++;
                }

            }
            return (int) count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
