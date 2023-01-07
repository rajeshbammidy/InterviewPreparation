package LeetCode.Nov22;

import java.util.Stack;

/**
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and
 * s[i + 1] where:
 * <p>
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case
 * or vice-versa.
 * <p>
 * <p>
 * To make the string good, you can choose two adjacent characters that make the
 * string bad and remove them. You can keep doing this until the string becomes
 * good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique
 * under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will
 * result "leEeetcode" to be reduced to "leetcode".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: We have many possible scenarios, and all lead to the same answer.
 * For example:
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "s"
 * Output: "s"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 * <p>
 * <p>
 * Related Topics String Stack 👍 1717 👎 77
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (Math.abs((int) (stack.peek()) - (int) (ch)) != 32) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : stack) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
