package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left
 * to right. The trees are represented by an integer array fruits where fruits[i]
 * is the type of fruit the iᵗʰ tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 *
 *
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked fruits
 * must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 *
 *
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 *
 *
 * Example 1:
 *
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 *
 * Example 2:
 *
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 *
 *
 * Example 3:
 *
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= fruits.length <= 10⁵
 * 0 <= fruits[i] < fruits.length
 *
 *
 * Related Topics Array Hash Table Sliding Window 👍 3470 👎 257
 */

import java.util.*;

class FruitIntoBaskets {
    public static void main(String args[]) {
        Solution solution = new FruitIntoBaskets().new Solution();
        System.out.println(solution.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int prevInDifferent[] = new int[fruits.length];
            for (int i = 1; i < fruits.length; i++) {
                if (fruits[i] == fruits[i - 1]) {
                    prevInDifferent[i] = prevInDifferent[i - 1];
                } else {
                    prevInDifferent[i] = i - 1;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            int maxAns = 0;
            int curAns = 0;
            for (int i = 0; i < fruits.length; i++) {
                int key = fruits[i];
                if (set.contains(key)) {
                    curAns++;
                } else {
                    if (set.size() == 2) {
                        curAns = i - prevInDifferent[i - 1] - 1;
                        set.remove(fruits[prevInDifferent[i - 1]]);
                    }
                    set.add(key);
                    curAns++;
                }
                maxAns = Math.max(curAns, maxAns);

            }

            return maxAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
