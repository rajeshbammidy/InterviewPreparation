package LeetCode.FEB23.leetcode.editor.en;

/**
 * You are given a list of strings of the same length words and a string target.
 *
 * Your task is to form target using the given words under the following rules:
 *
 *
 * target should be formed from left to right.
 * To form the iᵗʰ character (0-indexed) of target, you can choose the kᵗʰ
 * character of the jᵗʰ string in words if target[i] = words[j][k].
 * Once you use the kᵗʰ character of the jᵗʰ string of words, you can no longer
 * use the xᵗʰ character of any string in words where x <= k. In other words, all
 * characters to the left of or at index k become unusuable for every string.
 * Repeat the process until you form the string target.
 *
 *
 * Notice that you can use multiple characters from the same string in words
 * provided the conditions above are met.
 *
 * Return the number of ways to form target from words. Since the answer may be
 * too large, return it modulo 10⁹ + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: words = ["acca","bbbb","caca"], target = "aba"
 * Output: 6
 * Explanation: There are 6 ways to form target.
 * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
 * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
 * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
 * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
 * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
 * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
 *
 *
 * Example 2:
 *
 *
 * Input: words = ["abba","baab"], target = "bab"
 * Output: 4
 * Explanation: There are 4 ways to form target.
 * "bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
 * "bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
 * "bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
 * "bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * All strings in words have the same length.
 * 1 <= target.length <= 1000
 * words[i] and target contain only lowercase English letters.
 *
 *
 * Related Topics Array String Dynamic Programming 👍 1220 👎 67
 */

import javax.print.DocFlavor;
import java.util.*;

class NumberOfWaysToFormATargetStringGivenADictionary {
    public static void main(String args[]) {
        Solution solution = new NumberOfWaysToFormATargetStringGivenADictionary().new Solution();
        System.out.println(solution.numWays(new String[]{"acca", "bbbb", "caca"}, "aba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashMap<Integer, HashMap<Character, Integer>> map;
        static final int MOD = (int) (1e9 + 7);
        Long dp[][];

        public int numWays(String[] words, String target) {
            map = new HashMap<>();
            dp = new Long[1001][1001];

            /**
             * Count the occurrences of a character at the index
             */
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    map.putIfAbsent(j, new HashMap<>());
                    if (map.get(j).get(words[i].charAt(j)) == null) {
                        map.get(j).put(words[i].charAt(j), 0);
                    }
                    map.get(j).put(words[i].charAt(j), map.get(j).get(words[i].charAt(j)) + 1);
                }
            }
            return (int) solve(words, target, 0, 0);

        }

        private long solve(String[] words, String target, int i, int k) {
            if (k >= target.length()) {
                return 1;
            }
            if (i >= words[0].length()) return 0;

            if (dp[i][k] != null) return dp[i][k];
            long count = map.get(i).get(target.charAt(k)) == null ? 0 : map.get(i).get(target.charAt(k));
            //Skip the current element at the string and move to the next index
            dp[i][k] = solve(words, target, i + 1, k);
            dp[i][k] = (dp[i][k] % MOD + (count % MOD * solve(words, target, i + 1, k + 1) % MOD) % MOD) % MOD;

            return dp[i][k];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
