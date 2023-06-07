package LeetCode.TopicWiseSolutions.DynamicProgramming.lis_variants;

/**
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and
 * lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can
 * be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any
 * order.
 *
 *
 * Example 1:
 *
 *
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 *
 *
 * Example 2:
 *
 *
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 *
 *
 *
 * Constraints:
 *
 *
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti <= 1000
 *
 *
 * Related Topics Array Dynamic Programming TopicWiseSolutions.Greedy TopicWiseSolutions.Strings.Sorting 👍 2749 👎 109
 */

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution646 {
    /**
     * Approach: sort the array wrt to x and then y for same values of x.
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));
        int prevEnd = pairs[0][1];
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (prevEnd < pairs[i][0]) {
                count++;
                prevEnd = pairs[i][1];
            } else if (prevEnd > pairs[i][1]) {
                prevEnd = pairs[i][1];
            }

        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
