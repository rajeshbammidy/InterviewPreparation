package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * You are given an array nums of n positive integers.
 *
 * You can perform two types of operations on any element of the array any number
 * of times:
 *
 *
 * If the element is even, divide it by 2.
 *
 *
 *
 * For example, if the array is [1,2,3,4], then you can do this operation on the
 * last element, and the array will be [1,2,3,2].
 *
 *
 * If the element is odd, multiply it by 2.
 *
 * For example, if the array is [1,2,3,4], then you can do this operation on the
 * first element, and the array will be [2,2,3,4].
 *
 *
 *
 *
 * The deviation of the array is the maximum difference between any two elements
 * in the array.
 *
 * Return the minimum deviation the array can have after performing some number
 * of operations.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then
 * the deviation will be 3 - 2 = 1.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,1,5,20,3]
 * Output: 3
 * Explanation: You can transform the array after two operations to [4,2,5,5,3],
 * then the deviation will be 5 - 2 = 3.
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [2,10,8]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * n == nums.length
 * 2 <= n <= 5 * 10⁹
 *
 *
 * Related Topics Array TopicWiseSolutions.Greedy Heap (Priority TopicWiseSolutions.Strings.Queue) Ordered Set 👍 2560 👎 134
 */

import java.util.*;

class MinimizeDeviationInArray {
    public static void main(String args[]) {
        Solution solution = new MinimizeDeviationInArray().new Solution();
        solution.minimumDeviation(new int[]{1, 2, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeviation(int[] nums) {
            TreeSet<Integer> set = new TreeSet<>();
            int min = Integer.MAX_VALUE;
            for (int n : nums) {
                n = (n & 1) == 0 ? n : n * 2;
                set.add(n);
                min = Math.min(n, min);
            }

            int last = set.last();
            int diff = last - min;

            while ((last & 1) == 0) {
                diff = Math.min(last - min, diff);
                set.remove(last);
                last /= 2;
                min = Math.min(min, last);
                set.add(last);
                last = set.last();
            }
            return Math.min(last - min, diff);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
