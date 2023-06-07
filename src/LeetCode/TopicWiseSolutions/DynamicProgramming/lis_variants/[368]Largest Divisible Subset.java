package LeetCode.TopicWiseSolutions.DynamicProgramming.lis_variants; /**
 * Given a set of distinct positive integers nums, return the largest subset
 * answer such that every pair (answer[i], answer[j]) of elements in this subset
 * satisfies:
 *
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 *
 *
 * If there are multiple solutions, return any of them.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 10⁹
 * All the integers in nums are unique.
 *
 *
 * Related Topics Array TopicWiseSolutions.Strings.Math Dynamic Programming TopicWiseSolutions.Strings.Sorting 👍 3982 👎 165
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        HashMap<Integer, Integer> parentToChildMap = new HashMap<>();
        int maxDivisibleSubsetLength = 0;
        int maxDivisibleSubsetLengthIndex = -1;
        /**
         * We have to sort it, the reason being if there are three numbers say a,b,c a%b,b%c doesnt holds true for a%c, so sort the numbers to get rid of this issue
         *
         */
        Arrays.sort(nums);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parentToChildMap.put(i, j);
                        if (maxDivisibleSubsetLength < dp[i]) {
                            maxDivisibleSubsetLength = dp[i];
                            maxDivisibleSubsetLengthIndex = i;
                        }
                    }
                }
            }

        }
        List<Integer> ans = new ArrayList<>();
        if (maxDivisibleSubsetLengthIndex == -1) {
            ans.add(nums[0]);
            return ans;
        }
        ;
        while (parentToChildMap.containsKey(maxDivisibleSubsetLengthIndex)) {
            ans.add(nums[maxDivisibleSubsetLengthIndex]);
            maxDivisibleSubsetLengthIndex = parentToChildMap.get(maxDivisibleSubsetLengthIndex);
        }
        ans.add(nums[maxDivisibleSubsetLengthIndex]);
        Collections.reverse(ans);
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
