package LeetCode.FEB23.leetcode.editor.en;

/**
 * Alice and Bob continue their games with piles of stones. There are a number of
 * piles arranged in a row, and each pile has a positive integer number of stones
 * piles[i]. The objective of the game is to end with the most stones.
 *
 * Alice and Bob take turns, with Alice starting first. Initially, M = 1.
 *
 * On each player's turn, that player can take all the stones in the first X
 * remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X).
 *
 * The game continues until all the stones have been taken.
 *
 * Assuming Alice and Bob play optimally, return the maximum number of stones
 * Alice can get.
 *
 *
 * Example 1:
 *
 *
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alice takes one pile at the beginning, Bob takes two piles,
 * then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If
 * Alice takes two piles at the beginning, then Bob can take all three piles left. In
 * this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's
 * larger.
 *
 *
 * Example 2:
 *
 *
 * Input: piles = [1,2,3,4,5,100]
 * Output: 104
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10⁴
 *
 *
 * Related Topics Array Math Dynamic Programming Game Theory 👍 1891 👎 383
 */

import java.util.*;

class StoneGameIi {
    public static void main(String args[]) {
        Solution solution = new StoneGameIi().new Solution();

        System.out.println(solution.stoneGameII(new int[]{845, 5599, 1684, 8193, 2670, 8627, 7365, 7170, 1670, 9526, 30, 5708, 1115, 8295, 1903, 8440, 1594, 9319, 156, 7049, 7088, 2516, 302, 9315, 696, 3140, 2616}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<String, Integer> map;

        public int stoneGameII(int[] piles) {
            map = new HashMap<String, Integer>();
            int value = (int) recur(piles, 0, 1, true);
            return value;

        }

        private int recur(int piles[], int index, int M, boolean isAlice) {
            if (index >= piles.length) {
                return 0;
            }
            String key = (isAlice ? 1 : 0) + "-" + index + "-" + M;
            if (map.get(key) != null) return map.get(key);

            if (isAlice) {
                int sum = 0;
                int localM = 2 * M;
                int maxAns = 0;
                for (int i = 0; i < localM; i++) {
                    if ((index + i) >= piles.length) break;
                    sum += piles[index + i];
                    maxAns = Math.max(maxAns, sum + recur(piles, index + i + 1, Math.max(M, i + 1), !isAlice));
                }
                map.put(key, maxAns);
                return maxAns;
            } else {
                int localM = 2 * M;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < localM; i++) {
                    if ((index + i) >= piles.length) break;
                    min = Math.min(min, recur(piles, index + i + 1, Math.max(M, i + 1), !isAlice));
                }
                map.put(key, min);
                return min;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
