package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given an integer array nums of unique elements, return all possible subsets (
 * the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 *
 * Related Topics Array Backtracking Bit Manipulation 👍 14536 👎 211
 */

import java.util.*;

class Subsets {
    public static void main(String args[]) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int total = (int) Math.pow(2, nums.length);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for (int i = 1; i < total; i++) {
                String binaryString = new StringBuilder(Integer.toBinaryString(i)).reverse().toString();
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < binaryString.length(); j++) {
                    if (binaryString.charAt(j) == '1') {
                        temp.add(nums[j]);
                    }
                }
                ans.add(temp);

            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
