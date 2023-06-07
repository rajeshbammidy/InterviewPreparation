package LeetCode.TopicWiseSolutions.DynamicProgramming.lcs_variants;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of
 * the remaining characters.
 *
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 *
 *
 * Example 1:
 *
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 *
 * Example 2:
 *
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 *
 * Example 3:
 *
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 *
 * Related Topics String Dynamic Programming 👍 9851 👎 114
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1143 {
    static Integer dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1);

    }

    private int lcs(String text1, String text2, int i, int j) {

        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int maxLen = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            maxLen = 1 + lcs(text1, text2, i - 1, j - 1);
        } else {
            maxLen = Math.max(lcs(text1, text2, i - 1, j), lcs(text1, text2, i, j - 1));
        }
        dp[i][j] = maxLen;
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
