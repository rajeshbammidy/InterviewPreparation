package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be
 * truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers
 * within the 32-bit signed integer range: [−2³¹, 2³¹ − 1]. For this problem, if
 * the quotient is strictly greater than 2³¹ - 1, then return 2³¹ - 1, and if the
 * quotient is strictly less than -2³¹, then return -2³¹.
 *
 *
 * Example 1:
 *
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 *
 *
 * Example 2:
 *
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 *
 *
 *
 * Constraints:
 *
 *
 * -2³¹ <= dividend, divisor <= 2³¹ - 1
 * divisor != 0
 *
 *
 * Related Topics Math Bit Manipulation 👍 4318 👎 13411
 */

import java.util.*;

class DivideTwoIntegers {
    public static void main(String args[]) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-2147483648, -1));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Note that int range in Java is -2^31 to (2^31 - )
         */
        public int divide(int dividend, int divisor) {
            int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
            long divid = Math.abs((long) dividend);
            long divis = Math.abs((long) divisor);

            long quotient = 0;
            /**
             * divisor * quotient <= dividend
             */
            for (int i = 31; i >= 0; i--) {
                if ((divis * (1L << i)) <= divid) {
                    divid -= (divis * (1L << i));
                    quotient += ((1L << i));
                }
            }
            if (sign == 1) {
                return quotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quotient;
            } else {
                quotient *= -1;
                return quotient < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) quotient;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
