package LeetCode.Jan23.leetcode.editor.en;

import java.util.HashMap;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-
 * Y plane, return the maximum number of points that lie on the same straight line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10⁴ <= xi, yi <= 10⁴
 * All the points are unique.
 *
 *
 * Related Topics Array Hash Table Math Geometry 👍 1812 👎 268
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution149 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxPoints(int[][] points) {
        /**
         * Hashmap to store the frequencies of slope
         */
        HashMap<Double, Integer> slotToFrequencyMap = new HashMap<>();
        int maxPoints = 0;
        /**
         *  -> points.length - maxPoints is an optimization that we have added.
         *  If we have already found a max points using i-th point, then we can len-max points.
         */
        for (int i = 0; i < points.length - maxPoints; i++) {
            Node prevNode = new Node(points[i][0], points[i][1]);

            for (int j = i + 1; j < points.length; j++) {
                double slope = 0.0;
                Node curNode = new Node(points[j][0], points[j][1]);
                /**
                 * If x2-x2 = 0, then slope would be infinite, instead we consider the infinite value as (1e4 + 1).
                 * And also we are considering the double values for the preciseness.
                 */
                if (prevNode.x - curNode.x == 0) {
                    slope = (double) (1e4 + 1);
                } else {
                    slope = (double) (curNode.y - prevNode.y) / (curNode.x - prevNode.x);
                    /**
                     * An edge case that we have to handle.
                     */
                    if (slope == 0.0) slope = Math.abs(slope);

                }
                slotToFrequencyMap.put(slope, slotToFrequencyMap.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, slotToFrequencyMap.get(slope));

            }
            slotToFrequencyMap.clear();
        }
        /**
         * We are adding +1 to the maxPoints,since first point wont be included.
         */
        return maxPoints + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
