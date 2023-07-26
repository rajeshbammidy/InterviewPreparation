package LeetCode.FEB23.leetcode.editor.en;

/**
 * A digit string is good if the digits (0-indexed) at even indices are even and
 * the digits at odd indices are prime (2, 3, 5, or 7).
 *
 *
 * For example, "2582" is good because the digits (2 and 8) at even positions are
 * even and the digits (5 and 2) at odd positions are prime. However, "3245" is
 * not good because 3 is at an even index but is not even.
 *
 *
 * Given an integer n, return the total number of good digit strings of length n.
 * Since the answer may be large, return it modulo 10⁹ + 7.
 *
 * A digit string is a string consisting of digits 0 through 9 that may contain
 * leading zeros.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 1
 * Output: 5
 * Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
 *
 *
 * Example 2:
 *
 *
 * Input: n = 4
 * Output: 400
 *
 *
 * Example 3:
 *
 *
 * Input: n = 50
 * Output: 564908303
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10¹⁵
 *
 *
 * Related Topics Math Recursion 👍 857 👎 328
 */

import java.util.*;

class CountGoodNumbers {
    public static void main(String args[]) {
        Solution solution = new CountGoodNumbers().new Solution();
        solution.countGoodNumbers(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int mod = (int) (1e9 + 7);

        private long recur(long x, long n) {
            if (n == 0) return 1;
            long temp = recur(x, n / (long) 2);
            long evenAns = (temp % mod * temp % mod) % mod;
            if ((n & 1) == 0) {
                return evenAns;
            }
            return (x % mod * evenAns % mod) % mod;
        }

        public int countGoodNumbers(long n) {
            if (n == 1) return 5;
            long numEven = (long) Math.ceil(n / 2.0);
            long numOdd = (n & (long) 1) == 0 ? numEven : n - numEven;
            long evenAns = recur(5, numEven);
            long oddAns = recur(4, numOdd);
            long ans = (evenAns % mod * oddAns % mod) % mod;
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
