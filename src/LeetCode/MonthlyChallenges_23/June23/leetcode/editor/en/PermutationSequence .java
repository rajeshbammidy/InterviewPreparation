package LeetCode.FEB23.leetcode.editor.en;

/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following
 * sequence for n = 3:
 *
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 *
 * Given n and k, return the kᵗʰ permutation sequence.
 *
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Example 3:
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 *
 * Related Topics Math Recursion 👍 5714 👎 442
 */

import java.util.*;

class PermutationSequence {
    public static void main(String args[]) {
        Solution solution = new PermutationSequence().new Solution();
        solution.getPermutation(4, 17);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            int dp[] = new int[n];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                list.add(i);
                if (i != n) {
                    dp[i] = i * dp[i - 1];
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            k -= 1;
            while (list.size() != 1) {
                int elementsToPermute = list.size() - 1;
                int permuteFact = dp[elementsToPermute];
                int elementIndex = k / permuteFact;
                stringBuilder.append(list.get(elementIndex));
                list.remove(elementIndex);
                k = k % permuteFact;
            }
            stringBuilder.append(list.get(0));
            return stringBuilder.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
