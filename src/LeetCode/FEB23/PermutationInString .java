package LeetCode.FEB23;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or
 * false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 *
 * Example 2:
 *
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s1.length, s2.length <= 10⁴
 * s1 and s2 consist of lowercase English letters.
 *
 *
 * Related Topics Hash Table Two Pointers String Sliding Window 👍 8948 👎 283
 */

import java.util.*;

class PermutationInString {
    public static void main(String args[]) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("abcdxabcde", "abcdeabcdx");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            int charFreq[] = new int[26];
            Arrays.fill(charFreq, -1);
            for (char ch : s1.toCharArray()) {
                int index = ch - 'a';
                if (charFreq[index] == -1) charFreq[index] = 0;
                charFreq[index] += 1;
            }
            int totalLen = 0;
            for (int i = 0; i < charFreq.length; i++) {
                if (charFreq[i] > 0) totalLen++;
            }

            int currenLen = 0;
            int currFreq[] = charFreq.clone();
            char char2Array[] = s2.toCharArray();
            for (int i = 0; i < char2Array.length; i++) {
                int j = i;
                currenLen = 0;
                currFreq = charFreq.clone();
                while (j < char2Array.length) {
                    int index = char2Array[j] - 'a';
                    if (currFreq[index] == -1 || currFreq[index] == 0) break;
                    currFreq[index] -= 1;
                    if (currFreq[index] == 0) currenLen++;
                    if (currenLen == totalLen) return true;
                    j++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
