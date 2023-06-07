package LeetCode.MonthlyChallenges_23.March23;

/**
 * There is a group of n members, and a list of various crimes they could commit.
 * The iᵗʰ crime generates a profit[i] and requires group[i] members to participate
 * in it. If a member participates in one crime, that member can't participate in
 * another crime.
 *
 * Let's call a profitable scheme any subset of these crimes that generates at
 * least minProfit profit, and the total number of members participating in that
 * subset of crimes is at most n.
 *
 * Return the number of schemes that can be chosen. Since the answer may be very
 * large, return it modulo 10⁹ + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * Output: 2
 * Explanation: To make a profit of at least 3, the group could either commit
 * crimes 0 and 1, or just crime 1.
 * In total, there are 2 schemes.
 *
 * Example 2:
 *
 *
 * Input: n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * Output: 7
 * Explanation: To make a profit of at least 5, the group could commit any crimes,
 * as long as they commit one.
 * There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 *
 *
 * Related Topics Array Dynamic Programming 👍 1501 👎 103
 */

class ProfitableSchemes {
    public static void main(String args[]) {
        Solution solution = new ProfitableSchemes().new Solution();
        solution.profitableSchemes(1, 1, new int[]{1, 1, 1, 1, 2, 2, 1, 2, 1, 1}, new int[]{0, 1, 0, 0, 1, 1, 1, 0, 2, 2});
    }
//leetcode submit region begin(Prohibit modification and deletion)

    static class Node {
        int group;
        int profit;

        public Node(int group, int profit) {
            this.group = group;
            this.profit = profit;
        }
    }

    static int MOD = (int) (1e9 + 7);

    class Solution {

        Long dp[][][];


        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            dp = new Long[n + 1][10001][minProfit + 1];
            int x = (int) reucr(n, minProfit, group, profit, 0, 0, 0);
            System.out.println(x);
            return x;


        }

        private long reucr(int n, int minProfit, int[] group, int[] profit, int index, int currentProfit, int currentFolks) {

            String key = index + "-" + currentProfit + "-" + currentFolks;
            if (index >= profit.length) {
                if (currentFolks <= n && currentProfit >= minProfit) {
                    return 1;
                }
                return 0;
            }
            if (dp[index][currentFolks][currentProfit] != null) {
                return dp[index][currentFolks][currentProfit];
            }
            if (currentFolks > n) {
                return 0;
            }

            long left = reucr(n, minProfit, group, profit, index + 1, Math.min(currentProfit + profit[index], minProfit), currentFolks + group[index]);
            long right = reucr(n, minProfit, group, profit, index + 1, currentProfit, currentFolks);

            dp[index][currentFolks][currentProfit] = (left % MOD + right % MOD) % MOD;


            return dp[index][currentFolks][currentProfit];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
