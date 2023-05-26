package LeetCode.Jan23;

import java.util.*;
import java.util.function.Consumer;

/**
 * Given an integer array nums, return all the different possible non-decreasing
 * subsequences of the given array with at least two elements. You may return the
 * answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 *
 *
 * Related Topics Array Hash Table TopicWiseSolutions.Strings.Backtracking Bit Manipulation 👍 1869 👎 164
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution491 {
    private List<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> list) {
        /**
         * Basecase when list.size() gte 2
         */
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> hashSet = new HashSet<>();
        /**
         * Set to make sure the same element shouldn't be the start of the list
         */

        for (int i = start; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) continue;
            hashSet.add(nums[i]);
            /**
             * Backtrack only when list is empty or when the prev element in the list is less than or equal to current element
             *
             */
            if (list.isEmpty() || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                backtrack(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
