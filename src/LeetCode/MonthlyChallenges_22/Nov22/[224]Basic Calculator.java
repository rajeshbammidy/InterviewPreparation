package LeetCode.MonthlyChallenges_22.Nov22;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator
 * to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings
 * as mathematical expressions, such as eval().
 *
 *
 * Example 1:
 *
 *
 * Input: s = "1 + 1"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 *
 * Example 3:
 *
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 3 * 10⁵
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 *
 *
 * Related Topics TopicWiseSolutions.Strings.Math String Stack TopicWiseSolutions.Strings.Recursion 👍 4799 👎 364
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Integer.parseInt(s.charAt(i) + "");
                    i++;
                }
                sum = sum + sign * num;
                i--;

            } else {
                if (s.charAt(i) == '+') {
                    sign = 1;
                } else if (s.charAt(i) == '-') {
                    sign = -1;
                } else if (s.charAt(i) == '(') {
                    stack.push(sum);
                    stack.push(sign);
                    sum = 0;
                    sign = 1;
                } else if (s.charAt(i) == ')') {
                    sum = sum * stack.pop();
                    sum += stack.pop();
                }

            }

        }


        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
