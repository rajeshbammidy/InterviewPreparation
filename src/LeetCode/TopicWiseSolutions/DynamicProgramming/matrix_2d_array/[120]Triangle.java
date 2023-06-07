package LeetCode.TopicWiseSolutions.DynamicProgramming.matrix_2d_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either index i or
 * index i + 1 on the next row.
 *
 *
 * Example 1:
 *
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above)
 * .
 *
 *
 * Example 2:
 *
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10⁴ <= triangle[i][j] <= 10⁴
 *
 *
 *
 * Follow up: Could you do this using only
 * O(n) extra space, where
 * n is the total number of rows in the triangle?
 *
 * Related Topics Array Dynamic Programming 👍 7447 👎 454
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    left = triangle.get(i).get(j) + result.get(i - 1).get(j - 1);
                }
                if (j < result.get(i - 1).size()) {
                    right = triangle.get(i).get(j) + result.get(i - 1).get(j);
                }

                result.get(i).add(Math.min(left, right));

            }
        }

        int m = result.size();
        int minValue = Integer.MAX_VALUE;
        for (int x : result.get(m - 1)) minValue = Math.min(minValue, x);
        return minValue;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
