package LeetCode.Oct22;//Given an integer array nums, return the largest perimeter of a triangle with
//a non-zero area, formed from three of these lengths. If it is impossible to form 
//any triangle of a non-zero area, return 0. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,1,2]
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics Array TopicWiseSolutions.Strings.Math TopicWiseSolutions.Greedy TopicWiseSolutions.Strings.Sorting 👍 2086 👎 286


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution976 {
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        while (n >= 0) {
            if (n - 1 >= 0 && n - 2 >= 0) {
                int a = nums[n ];
                int b = nums[n - 1];
                int c = nums[n - 2];
                if (b + c > a) return a + b + c;
            }
            n--;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
