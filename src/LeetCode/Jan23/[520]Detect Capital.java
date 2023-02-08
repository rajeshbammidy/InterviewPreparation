package LeetCode.Jan23;

/**
 * We define the usage of capitals in a word to be right when one of the following
 * cases holds:
 *
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 *
 *
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 * Example 1:
 * Input: word = "USA"
 * Output: true
 *
 * Example 2:
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 *
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 *
 *
 * Related Topics String 👍 2089 👎 397
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution520 {
    public boolean isCapital(char ch) {
        return ch >= 65 && ch <= 90;
    }

    public boolean detectCapitalUse(String word) {
        boolean isFirstCapital = false;
        boolean isSecondCapital = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (i == 0 && isCapital(ch)) {
                isFirstCapital = true;
                continue;
            } else if (i == 1 && isCapital(ch)) {
                if(!isFirstCapital)return false;
                isSecondCapital = true;
                continue;
            }
            if (isFirstCapital && isSecondCapital && !isCapital(ch)) return false;
            if (!isSecondCapital && isCapital(ch)) return false;

        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
