package LeetCode.MonthlyChallenges_22.Nov22;

/**
 * You are given a positive integer num consisting only of digits 6 and 9.
 * <p>
 * Return the maximum number you can get by changing at most one digit (6 becomes
 * 9, and 9 becomes 6).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= num <= 10⁴
 * num consists of only 6 and 9 digits.
 * <p>
 * <p>
 * Related Topics TopicWiseSolutions.Strings.Math TopicWiseSolutions.Greedy 👍 1931 👎 172
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1323 {
    public int maximum69Number(int num) {
        int ans = num;
        String str = Integer.toString(num);
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(i) == '6') {
                    int nValue = Integer.parseInt("9" + str.substring(i + 1));
                    if (nValue > ans) {
                        ans = nValue;
                    }
                }

            } else {
                if (str.charAt(i) == '6') {
                    int nValue = Integer.parseInt(str.substring(0, i) + "9" + str.substring(i + 1));
                    if (nValue > ans) {
                        ans = nValue;
                    }
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
