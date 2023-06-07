package LeetCode.MonthlyChallenges_23.March23;

/**
 * A program was supposed to print an array of integers. The program forgot to
 * print whitespaces and the array is printed as a string of digits s and all we know
 * is that all integers in the array were in the range [1, k] and there are no
 * leading zeros in the array.
 *
 * Given the string s and the integer k, return the number of the possible arrays
 * that can be printed as s using the mentioned program. Since the answer may be
 * very large, return it modulo 10⁹ + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "1000", k = 10000
 * Output: 1
 * Explanation: The only possible array is [1000]
 *
 *
 * Example 2:
 *
 *
 * Input: s = "1000", k = 10
 * Output: 0
 * Explanation: There cannot be an array that was printed this way and has all
 * integer >= 1 and <= 10.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "1317", k = 2000
 * Output: 8
 * Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7
 * ],[1,3,17],[1,3,1,7]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10⁵
 * s consists of only digits and does not contain leading zeros.
 * 1 <= k <= 10⁹
 *
 *
 * Related Topics String Dynamic Programming 👍 1278 👎 43
 */

class RestoreTheArray {
    public static void main(String args[]) {
        Solution solution = new RestoreTheArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Integer dp[];
        final int MOD = (int) (1e9 + 7);

        public int numberOfArrays(String s, int k) {
            dp = new Integer[s.length()];
            char array[] = s.toCharArray();
            return solve(array, k, 0);

        }

        private int solve(char[] array, int k, int i) {
            if (i == array.length) return 1;

            if (dp[i] != null) return dp[i];
            long num = 0;
            long ans = 0;
            for (int j = i; j < array.length; j++) {
                num = num * 10 + (array[j] - '0');
                if (num == 0 || num > k) {
                    break;
                }
                ans = (ans % MOD + solve(array, k, j + 1) % MOD) % MOD;
            }
            dp[i] = (int) ans;
            return dp[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
