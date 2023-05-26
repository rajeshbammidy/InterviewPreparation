package LeetCode.Nov22;

/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the
 * total area covered by the two rectangles.
 * <p>
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its
 * top-right corner (ax2, ay2).
 * <p>
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its
 * top-right corner (bx2, by2).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 =
 * 2
 * Output: 16
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * -10⁴ <= ax1 <= ax2 <= 10⁴
 * -10⁴ <= ay1 <= ay2 <= 10⁴
 * -10⁴ <= bx1 <= bx2 <= 10⁴
 * -10⁴ <= by1 <= by2 <= 10⁴
 * <p>
 * <p>
 * Related Topics TopicWiseSolutions.Strings.Math Geometry 👍 1592 👎 1507
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        // r1
        int r1Breadth = Math.abs(ax1 - ax2);
        int r1Height = Math.abs(ay1 - ay2);
        //r2
        int r2Breadth = Math.abs(bx1 - bx2);
        int r2Height = Math.abs(by1 - by2);

        int area = (r1Height * r1Breadth) + (r2Breadth * r2Height);

        int ix1 = Math.max(ax1, bx1);
        int iy1 = Math.max(ay1, by1);


        int ix2 = Math.min(ax2, bx2);
        int iy2 = Math.min(ay2, by2);

        int iArea = Math.max(ix2 - ix1,0) * Math.max(0,iy2 - iy1);

        return area - iArea;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
