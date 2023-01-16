package LeetCode.DynamicProgramming.lis_variants;

import java.util.*;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
 * represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of
 * one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one
 * inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 *
 * Example 1:
 *
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] =>
 * [5,4] => [6,7]).
 *
 *
 * Example 2:
 *
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= envelopes.length <= 10⁵
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 10⁵
 *
 *
 * Related Topics Array Binary Search Dynamic Programming Sorting 👍 4807 👎 115
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return -(o1[1] - o2[1]);
            } else {
                return o1[0] - o2[0];
            }
        }));
        System.out.println(Arrays.deepToString(envelopes));
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int index = Collections.binarySearch(dp, envelopes[i][1]);
            index = index < 0 ? Math.abs((index + 1)) : index;
            if (index >= dp.size()) {
                dp.add(envelopes[i][1]);
            } else {
                dp.set(index, envelopes[i][1]);
            }

        }
        return dp.size();

    }

    private boolean canFit(int[] envelope, int[] envelope1) {
        return envelope[0] < envelope1[0] && envelope[1] < envelope1[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
