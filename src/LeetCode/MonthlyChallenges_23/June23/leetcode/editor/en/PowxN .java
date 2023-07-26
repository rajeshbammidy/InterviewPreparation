package LeetCode.FEB23.leetcode.editor.en;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ).
 *
 *
 * Example 1:
 *
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 *
 * Example 2:
 *
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 *
 * Example 3:
 *
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2⁻² = 1/2² = 1/4 = 0.25
 *
 *
 *
 * Constraints:
 *
 *
 * -100.0 < x < 100.0
 * -2³¹ <= n <= 2³¹-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -10⁴ <= xⁿ <= 10⁴
 *
 *
 * Related Topics Math Recursion 👍 7319 👎 7549
 */

import java.util.*;

class PowxN {
    public static void main(String args[]) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double value = recur(x, Math.abs(n));
            if (n < 0) {
                return 1 / value;
            }
            return value;

        }

        private double recur(double x, int n) {
            if (n == 0) return 1.0;
            double temp = recur(x, n / 2);
            if ((n & 1) == 0) {
                return temp * temp;
            }
            return x * temp * temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
