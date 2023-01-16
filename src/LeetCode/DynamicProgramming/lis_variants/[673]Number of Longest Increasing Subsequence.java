package LeetCode.DynamicProgramming.lis_variants;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 Given an integer array nums, return the number of longest increasing
 subsequences.

 Notice that the sequence has to be strictly increasing. 


 Example 1: 


 Input: nums = [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3,
 5, 7].


 Example 2: 


 Input: nums = [2,2,2,2,2]
 Output: 5
 Explanation: The length of the longest increasing subsequence is 1, and there
 are 5 increasing subsequences of length 1, so output 5.



 Constraints: 


 1 <= nums.length <= 2000 
 -10⁶ <= nums[i] <= 10⁶ 


 Related Topics Array Dynamic Programming Binary Indexed Tree Segment Tree 👍 44
 50 👎 198

 */
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        int LIS = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];// the number of ways to reach i would be equal to number of way to reach j
                } else if (dp[i] == dp[j] + 1) {
                    count[i] += count[j]; // the total number of ways you can reach to i

                }
            }
            LIS = Math.max(LIS, dp[i]);

        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == LIS) res += count[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
