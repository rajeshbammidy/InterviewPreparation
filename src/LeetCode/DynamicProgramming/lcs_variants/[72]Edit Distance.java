package LeetCode.DynamicProgramming.lcs_variants;

/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 *
 * Example 1:
 *
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 *
 * Example 2:
 *
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 *
 * Related Topics String Dynamic Programming 👍 10725 👎 124
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution72 {
    static Integer dp[][];

    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return findMinChanges(word1, word2, 0, 0);

    }

    private int findMinChanges(String word1, String word2, int i, int j) {

        if (i >= word1.length() && j >= word2.length()) return 0;

        if (i == word1.length()) {
            return word2.length() - j;
        }
        /**
         * You will reach this case when you replace all the characters of word1 wrt word2,once you are done replacing you should
         * delete the rest of word1
         */
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != null) return dp[i][j];
        int minValue = Integer.MAX_VALUE;

        /**
         * If the char at i equals to char at j proceed further
         */
        if (word1.charAt(i) == word2.charAt(j)) {
            minValue = findMinChanges(word1, word2, i + 1, j + 1);
            dp[i][j] = minValue;
            return dp[i][j];
        }
        /**
         * Find the min changes  with replace,delete,insert
         */
        int replacedMin = 1 + findMinChanges(word1, word2, i + 1, j + 1);
        int deletedMin = 1 + findMinChanges(word1, word2, i + 1, j);
        int insertedMin = 1 + findMinChanges(word1, word2, i, j + 1);
        /**
         * Find minimum among all the above operations and memoize it
         */
        minValue = Math.min(Math.min(replacedMin, Math.min(deletedMin, insertedMin)), minValue);

        dp[i][j] = minValue;
        return dp[i][j];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
