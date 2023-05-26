package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10⁵
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 *
 *
 * Related Topics String Sliding Window 👍 2124 👎 71
 */

import java.util.*;

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String args[]) {
        Solution solution = new MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
        solution.maxVowels("abciiidef",3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isVowel(char ch) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
            return false;
        }

        public int maxVowels(String s, int k) {
            int maxVowels = 0;
            char carray[] = s.toCharArray();
            int currentCount = 0;
            for (int i = 0; i < k; i++) {
                if (isVowel(carray[i])) currentCount++;
            }
            maxVowels = Math.max(maxVowels, currentCount);
            int prevIndex = 0;
            System.out.println(maxVowels);
            for (int i = k; i < carray.length; i++) {
                if (isVowel(carray[prevIndex])) {
                    currentCount--;
                    prevIndex++;
                } else {
                    prevIndex++;
                }


                if (isVowel(carray[i])) {
                    currentCount++;
                }
                maxVowels = Math.max(maxVowels, currentCount);
            }
            return maxVowels;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
