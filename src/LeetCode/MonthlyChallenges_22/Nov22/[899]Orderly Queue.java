package LeetCode.MonthlyChallenges_22.Nov22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a string s and an integer k. You can choose one of the first k
 * letters of s and append it at the end of the string..
 * <p>
 * Return the lexicographically smallest string you could have after applying the
 * mentioned step any number of moves.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "cba", k = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1ˢᵗ character 'c' to the end, obtaining the
 * string "bac".
 * In the second move, we move the 1ˢᵗ character 'b' to the end, obtaining the
 * final result "acb".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "baaca", k = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1ˢᵗ character 'b' to the end, obtaining the
 * string "aacab".
 * In the second move, we move the 3ʳᵈ character 'c' to the end, obtaining the
 * final result "aaabc".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= k <= s.length <= 1000
 * s consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics TopicWiseSolutions.Strings.Math String TopicWiseSolutions.Strings.Sorting 👍 1212 👎 520
 */

/**
 * Approach:
 * If you sort in groups ie.. k>1 ultimately we always tried to pick the smallest possible and put it at
 * the back, which ultimately gives the sorted array
 * But in case of k=1, you dont have that privelge of group sort, you would have to pick the only available
 * first element therefore you would have to pick one at a time append to the last and compare.
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution899 {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char car[] = s.toCharArray();
            Arrays.sort(car);
            return String.valueOf(car);
        }
        Queue<Character> inputQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String ans = s;
        for (char ch : s.toCharArray()) {
            inputQueue.add(ch);
            sb.append(ch);
        }
        while (!inputQueue.isEmpty()) {
            char ch = inputQueue.poll();
            sb.deleteCharAt(0);
            sb.append(ch);
            if (sb.toString().compareTo(ans) < 0) {
                ans = sb.toString();
            }
        }
        System.out.println(ans);
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
