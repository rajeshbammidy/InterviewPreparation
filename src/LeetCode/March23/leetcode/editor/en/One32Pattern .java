package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] <
 * nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0
 * ] and [-1, 2, 0].
 *
 *
 *
 * Constraints:
 *
 *
 * n == nums.length
 * 1 <= n <= 2 * 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 *
 *
 * Related Topics Array Binary Search Stack Monotonic Stack Ordered Set 👍 5507 👎
 * 310
 */

import java.util.*;

class One32Pattern {
    public static void main(String args[]) {
        Solution solution = new One32Pattern().new Solution();
        solution.find132pattern(new int[]{3,1,4,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length ;
            ArrayList<Integer> nearestSmallLeft = new ArrayList<>();
            ArrayList<Integer> nearestSmallRight = new ArrayList<>();
            nearestSmallRight.add(Integer.MIN_VALUE);
            nearestSmallLeft.add(Integer.MIN_VALUE);
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            for (int i = 1; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
                nearestSmallLeft.add(stack.isEmpty() ? Integer.MIN_VALUE : nums[stack.peek()]);
                stack.add(i);
            }
            stack.clear();
            stack.add(n-1);

            for (int i = n-2; i >=0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
                nearestSmallRight.add(stack.isEmpty() ? Integer.MIN_VALUE : nums[stack.peek()]);
                stack.add(i);
            }
            Collections.reverse(nearestSmallRight);
            stack.clear();

            System.out.println(nearestSmallLeft);
            System.out.println(nearestSmallRight);
            for (int i = 0; i <n ; i++) {
                int smallOnLeft = nearestSmallLeft.get(i);
                int smallOnRight = nearestSmallRight.get(i);
                if(smallOnLeft!=Integer.MIN_VALUE && smallOnRight!=Integer.MIN_VALUE){
                    if(smallOnLeft<smallOnRight)return true;
                }
            }
            return false;





        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
