package LeetCode.Nov22;

import java.util.Stack;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate
 * removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It
 * can be proven that the answer is unique.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move.  The result of this move is that
 * the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "azxxzy"
 * Output: "ay"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics String Stack 👍 5039 👎 198
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : stack) stringBuilder.append(ch);
        return stringBuilder.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
