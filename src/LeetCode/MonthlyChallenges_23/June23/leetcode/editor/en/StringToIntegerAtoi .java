package LeetCode.FEB23.leetcode.editor.en;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
 * digits were read, then the integer is 0. Change the sign as necessary (from step
 * 2).
 * If the integer is out of the 32-bit signed integer range [-2³¹, 2³¹ - 1], then
 * clamp the integer so that it remains in the range. Specifically, integers less
 * than -2³¹ should be clamped to -2³¹, and integers greater than 2³¹ - 1 should be
 * clamped to 2³¹ - 1.
 * Return the integer as the final result.
 *
 *
 * Note:
 *
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of
 * the string after the digits.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * The parsed integer is 42.
 * Since 42 is in the range [-2³¹, 2³¹ - 1], the final result is 42.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * ^
 * Step 3: "   -42" ("42" is read in)
 * ^
 * The parsed integer is -42.
 * Since -42 is in the range [-2³¹, 2³¹ - 1], the final result is -42.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading
 * whitespace)
 * ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-'
 * nor '+')
 * ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next
 * character is a non-digit)
 * ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-2³¹, 2³¹ - 1], the final result is 4193.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
 * '+', '-', and '.'.
 *
 *
 * Related Topics String 👍 3324 👎 10252
 */

import java.util.*;

class StringToIntegerAtoi {
    public static void main(String args[]) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi("   -42"));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            long num = 0;
            long sign = 1;
            boolean isDigitRead = false;
            boolean signOccured = false;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    if (!isDigitRead) {
                        if (signOccured) {
                            if (s.charAt(i - 1) == ' ' || s.charAt(i - 1) == '.' || Character.isLetter(s.charAt(i - 1))) {
                                return 0;
                            }
                        }
                        num = sign * (ch - '0');
                        isDigitRead = true;
                        continue;
                    }
                    num = (long) (num * 1e1 * sign) + (ch - '0');
                    num *= sign;

                    if (num > Integer.MAX_VALUE) {
                        num = Integer.MAX_VALUE;
                    } else if (num < Integer.MIN_VALUE) {
                        num = Integer.MIN_VALUE;
                    }
                } else if ((ch == '-' || ch == '+') && !isDigitRead) {
                    if (i > 0 && s.charAt(i - 1) != ' ') {
                        return (int) num;
                    }
                    signOccured = true;
                    sign = ch == '-' ? -1 : 1;
                } else {
                    if (ch == ' ' && !isDigitRead) continue;
                    return (int) num;
                }
            }

            return (int) num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
