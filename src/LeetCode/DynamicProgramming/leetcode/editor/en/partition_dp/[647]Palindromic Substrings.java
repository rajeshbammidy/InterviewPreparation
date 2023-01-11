package LeetCode.DynamicProgramming.leetcode.editor.en.partition_dp;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 *
 * Related Topics String Dynamic Programming 👍 8516 👎 185
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution647 {
    /**
     * Since they didn't ask any max or min substrings we don't have to use MCM here.
     * Since they asked for substrings, we can simply expand at each i, to check if it is palindrome.
     */
    static int count;

    public int countSubstrings(String str) {

        count = 0;
        for (int i = 0; i < str.length(); i++) {
            /**
             * Expand for the odd length palindrome string
             */
            expandPalindrome(str, i, i);
            /**
             * Expand for the even length palindrome string
             */
            expandPalindrome(str, i, i + 1);

        }
        return count;
    }

    private void expandPalindrome(String str, int i, int j) {
        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
            } else {
                break;
            }
            i--;
            j++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
