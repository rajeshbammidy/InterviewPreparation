package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 *
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 *
 * Related Topics String Dynamic Programming TopicWiseSolutions.Strings.Backtracking 👍 9222 👎 298
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution131 {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, new ArrayList<>());
        return result;
    }

    private void backtrack(char[] toCharArray, int start, ArrayList<String> list) {
        if (start == toCharArray.length) {
            result.add(new ArrayList<>(list));
        }

        String temp = "";
        for (int i = start; i < toCharArray.length; i++) {
            temp += toCharArray[i];
            if (!isPalindrome(temp)) {
                continue;
            }
            list.add(temp);
            backtrack(toCharArray, i + 1, list);
            list.remove(list.size() - 1);

        }
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {

            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
