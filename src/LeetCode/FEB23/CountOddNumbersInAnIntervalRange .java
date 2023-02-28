package LeetCode.FEB23;

/**
 * Given two non-negative integers low and high. Return the count of odd numbers
 * between low and high (inclusive).
 *
 *
 * Example 1:
 *
 *
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 *
 * Example 2:
 *
 *
 * Input: low = 8, high = 10
 * Output: 1
 * Explanation: The odd numbers between 8 and 10 are [9].
 *
 *
 * Constraints:
 *
 *
 * 0 <= low <= high <= 10^9
 *
 *
 * Related Topics Math 👍 1498 👎 95
 */

class CountOddNumbersInAnIntervalRange {
    public static void main(String args[]) {
        Solution solution = new CountOddNumbersInAnIntervalRange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countOdds(int low, int high) {
            int mid = (high - low) / 2;
            if ((low & 1) != 0 || (high & 1) != 0) {
                mid += 1;
            }
            return mid;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
