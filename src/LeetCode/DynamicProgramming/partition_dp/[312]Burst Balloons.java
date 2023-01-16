package LeetCode.DynamicProgramming.partition_dp;

import java.util.ArrayList;

/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with
 * a number on it represented by an array nums. You are asked to burst all the
 * balloons.
 *
 * If you burst the iᵗʰ balloon, you will get nums[i - 1] * nums[i] * nums[i + 1]
 * coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if
 * there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 *
 * Example 2:
 *
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 *
 *
 * Constraints:
 *
 *
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 *
 *
 * Related Topics Array Dynamic Programming 👍 7282 👎 186
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution312 {
    /**
     * Detailed Approach:
     * If we try to solve this question using MCM approach, then we cannot solve sub problems individually since the current element at k
     * depends on one adjacent balloon  between i to k-1 and also one adjacent balloon between k+1 to j
     *
     * So instead of bursting the balloon at the start, lets try to burst the balloon at k last, so that  it is independent of balloons between
     * i to k-1 and k+1 to j, If the balloon is bursting at last means that it has no adjacent balloons in the left and right,so we would have to
     * multiply with 1 on left,1 right.
     */
    static Integer dp[][];

    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        /**
         * Add 1 to the start and end to handle base cases.
         */
        list.add(1);
        for (int x : nums) list.add(x);
        list.add(1);
        dp = new Integer[list.size()][list.size()];
        /**
         * We are taking start i as 1 and end as j = len-2,since we have added 1 to last of list
         */
        return findMaxCoins(list, 1, list.size() - 2);

    }

    private int findMaxCoins(ArrayList<Integer> list, int i, int j) {
        if (i > j) return 0;
        /**
         * If there is only one element you just have to worry about the i-1,j+1
         */
        if (i == j) {
            int value = list.get(i);
            if (i - 1 >= 0) {
                value *= list.get(i - 1);
            }
            if (j + 1 < list.size()) {
                value *= list.get(j + 1);
            }
            return value;
        }

        if (dp[i][j] != null) return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int value = list.get(k);
            if (i - 1 >= 0) {
                value *= list.get(i - 1);
            }
            if (j + 1 < list.size()) {
                value *= list.get(j + 1);
            }
            value += findMaxCoins(list, i, k - 1) + findMaxCoins(list, k + 1, j);
            maxCoins = Math.max(value, maxCoins);

        }
        dp[i][j] = maxCoins;
        return maxCoins;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
