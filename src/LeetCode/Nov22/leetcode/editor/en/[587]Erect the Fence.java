package LeetCode.Nov22.leetcode.editor.en;

import java.util.*;

/**
 * You are given an array trees where trees[i] = [xi, yi] represents the location
 * of a tree in the garden.
 *
 * You are asked to fence the entire garden using the minimum length of rope as
 * it is expensive. The garden is well fenced only if all the trees are enclosed.
 *
 * Return the coordinates of trees that are exactly located on the fence
 * perimeter.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
 *
 *
 * Example 2:
 *
 *
 * Input: points = [[1,2],[2,2],[4,2]]
 * Output: [[4,2],[2,2],[1,2]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= points.length <= 3000
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 * All the given points are unique.
 *
 *
 * Related Topics Array Math Geometry 👍 1096 👎 565
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution587 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int getOrientation(Point x, Point y, Point z) {
        /*
        x -> onHull
        y -> next point
        z -> target
        If x,y,z are three points we have to find the slope of these three points to find the orientation
        1. slope of xy
        2. slope of yz
        if( slope of xy > yz) then it is clockwise
        else if(slope of xy < yz) then it is anti-clockwise
        else collinear
        You can do the cross product and you can transform it into a equation.
         */

        int x1 = x.x;
        int y1 = x.y;
        int x2 = y.x;
        int y2 = y.y;
        int x3 = z.x;
        int y3 = z.y;

        int distance = (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);
        if (distance > 0) return 1;
        else if (distance < 0) return -1;
        else return 0;


    }

    public int[][] outerTrees(int[][] trees) {
        ArrayList<Point> points = new ArrayList<>();
        /*
        Adding into ArrayList for convenience [Optional]
         */
        for (int i = 0; i < trees.length; i++) {
            points.add(new Point(trees[i][0], trees[i][1]));
        }

        LinkedHashSet<Point> list = new LinkedHashSet<>();

        Point startPoint = getStartPoint(points);
        Point onHull = startPoint;
        list.add(onHull);

        while (true) {

            Point next = points.get(0);
            ArrayList<Point> collinearPoint = new ArrayList<>();
            boolean isNextFound = false;
            for (Point p : points) {
                int orientation = getOrientation(onHull, next, p);
                if ((next == onHull || orientation == 1)) {
                    next = p;
                    collinearPoint.clear();
                }

               else if ((orientation == 0)) {
                    if ((getDistance(onHull, p) > getDistance(onHull, next))) {
                        collinearPoint.add(next);
                        next = p;
                    } else {
                        collinearPoint.add(p);
                    }

                }
            }
            for (Point cp : collinearPoint) list.add(cp);
            onHull = next;
            if (onHull == startPoint) {
                break;
            }
            list.add(onHull);
            if(points.size()==list.size())break;

        }
        int ans[][] = new int[list.size()][2];
        int i = 0;
        for (Point p : list) {
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }

        return ans;

    }

    static int getDistance(Point p1, Point p2) {
        /**
         * To calculate the distance between two points
         */
        return (int) Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2));
    }

    private Point getStartPoint(ArrayList<Point> points) {
        Point point = points.get(0);
        for (Point p : points) {
            if (p.x < point.x) {
                point = p;
            }
        }
        return point;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution587().outerTrees(new int[][]{{2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}})));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
