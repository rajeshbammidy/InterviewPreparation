package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 *
 * 1 <= a.length, b.length <= 10⁴
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 *
 * Related Topics TopicWiseSolutions.Strings.Math String Bit Manipulation Simulation 👍 7518 👎 741
 */

class AddBinary {
    public static void main(String args[]) {
        Solution solution = new AddBinary().new Solution();
        solution.addBinary("1010", "1011");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            String res = "";
            int carry = 0;
            while (i >= 0 && j >= 0) {
                int an = Character.getNumericValue(a.charAt(i--));
                int bn = Character.getNumericValue(b.charAt(j--));
                int sum = an + bn + carry;

                if (sum == 2) {
                    carry = 1;
                    res = "0" + res;
                } else if (sum == 3) {
                    carry = 1;
                    res = "1" + res;
                } else {
                    carry = 0;
                    res = sum + res;
                }

            }
            while (i >= 0) {
                int an = Character.getNumericValue(a.charAt(i--));
                int sum = an + carry;
                if (sum == 2) {
                    carry = 1;
                    res = "0" + res;
                } else if (sum == 3) {
                    carry = 1;
                    res = "1" + res;
                } else {
                    carry = 0;
                    res = sum + res;
                }
            }

            while (j >= 0) {
                int bn = Character.getNumericValue(b.charAt(j--));
                int sum = carry + bn;
                if (sum == 2) {
                    carry = 1;
                    res = "0" + res;
                } else if (sum == 3) {
                    carry = 1;
                    res = "1" + res;
                } else {
                    carry = 0;
                    res = sum + res;
                }
            }
            if (carry > 0) res = 1 + res;
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
