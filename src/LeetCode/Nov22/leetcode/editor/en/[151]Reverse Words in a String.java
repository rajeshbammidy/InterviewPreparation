package LeetCode.Nov22.leetcode.editor.en;

import java.util.Stack;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * <p>
 * There is at least one word in s.
 * <p>
 * <p>
 * <p>
 * Follow-up: If the string data type is mutable in your language, can you solve
 * it in-place with O(1) extra space?
 * <p>
 * Related Topics Two Pointers String 👍 4849 👎 4375
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] strings = s.split("\\s");
        for (String str : strings) {
            if (!str.replaceAll(" ", "").isEmpty()) {
                stack.push(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }


        return stringBuilder.toString().trim();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
