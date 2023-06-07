package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some
 * bits of a and b to make ( a OR b == c ). (bitwise OR operation). Flip operation
 * consists of change any single bit 1 to 0 or change the bit 0 to 1 in their
 * binary representation.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 *
 * Example 2:
 *
 *
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 *
 *
 * Related Topics Bit Manipulation 👍 902 👎 61
 */

import java.util.*;

class MinimumFlipsToMakeAOrBEqualToC {
    public static void main(String args[]) {
        Solution solution = new MinimumFlipsToMakeAOrBEqualToC().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int a, int b, int c) {
            int count = 0;
            int maxNumber = Arrays.asList(a, b, c).stream().max(Integer::compare).get();
            int bits = (int) ((Math.log(maxNumber) / Math.log(2)) + 1);
            int i = 1;
            while (i <= bits) {
                int cth = (c & (1 << (i - 1))) >> (i - 1);
                int bth = (b & (1 << (i - 1))) >> (i - 1);
                int ath = (a & (1 << (i - 1))) >> (i - 1);
                int result = (bth | ath);
                if (cth == 0 && (ath == 1 && bth == 1)) count += 2;
                else if (cth != result) {
                    count++;
                }
                i++;
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
