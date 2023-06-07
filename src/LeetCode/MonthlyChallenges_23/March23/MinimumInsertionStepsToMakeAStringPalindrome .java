package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given a string s. In one step you can insert any character at any index of the
 * string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we do not need any
 * insertions.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 *
 *
 * Example 3:
 *
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *
 *
 * Related Topics String Dynamic Programming 👍 3880 👎 55
 */

class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String args[]) {
        Solution solution = new MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Integer dp[][];

        public int minInsertions(String s) {

            String str1 = s;
            dp = new Integer[str1.length()][str1.length()];
            String str2 = new StringBuilder(s).reverse().toString();
            int lcs = solve(str1, str2, 0, 0);
            return str1.length() - lcs;

        }

        private int solve(String str1, String str2, int i, int j) {
            if (str1.length() == i || str2.length() == j) return 0;
            if (dp[i][j] != null) return dp[i][j];

            int left = 0;
            int right = 0;
            if (str1.charAt(i) == str2.charAt(j)) {
                left = 1 + solve(str1, str2, i + 1, j + 1);

            } else {

                left = solve(str1, str2, i + 1, j);
                right = solve(str1, str2, i, j + 1);

            }
            dp[i][j] = Math.max(left, right);

            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
