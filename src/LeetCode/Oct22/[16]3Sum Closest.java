package LeetCode.Oct22;//Given an integer array nums of length n and an integer target, find three
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 7842 👎 430

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiffSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum == target) return curSum;
                if (curSum < target) left++;
                else right--;
                minDiffSum = Math.abs(target - curSum) < Math.abs(target - minDiffSum) ? curSum : minDiffSum;
            }

        }
        return minDiffSum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
