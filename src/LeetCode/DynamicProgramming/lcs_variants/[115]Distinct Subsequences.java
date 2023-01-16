package LeetCode.DynamicProgramming.lcs_variants;

/**
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 *
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 *
 *
 * Example 2:
 *
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 *
 *
 * Related Topics String Dynamic Programming 👍 4798 👎 191
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution115 {
    static Integer dp[][];

    public int numDistinct(String s, String t) {
        /**
         * Initialize the dp array
         */
        dp = new Integer[s.length()][t.length()];
        return findDistinctSubsequences(s, t, 0, 0);

    }

    private int findDistinctSubsequences(String s, String t, int i, int j) {


        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int value = 0;
        /**
         * If the char at i equals to char at j then increment i+1,j+1
         */
        if (s.charAt(i) == t.charAt(j)) {
            value = findDistinctSubsequences(s, t, i + 1, j + 1);
        }
        /**
         * Since we have to check the occurrences of t in s,increment i+1 to see if it occurs
         */
        int maxValue = value + findDistinctSubsequences(s, t, i + 1, j);
        dp[i][j] = maxValue;
        return maxValue;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
