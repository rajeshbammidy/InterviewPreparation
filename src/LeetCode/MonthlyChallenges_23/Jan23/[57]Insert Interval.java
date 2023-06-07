package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.ArrayList;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i]
 * = [starti, endi] represent the start and the end of the iᵗʰ interval and
 * intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10⁵
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10⁵
 *
 *
 * Related Topics Array 👍 7666 👎 528
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution57 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Node(intervals[i][0], intervals[i][1]));
        }
        list.add(new Node(newInterval[0], newInterval[1]));
        list.sort((o1, o2) -> {
            return o1.x - o2.x;
        });
        ArrayList<Node> tempList = new ArrayList<>();
        tempList.add(list.get(0));
        int i = 1;
        while (i < list.size()) {
            Node cureNode = tempList.get(tempList.size() - 1);
            Node newNode = list.get(i);

            if (isOverlapping(newNode, cureNode)) {
                tempList.set(tempList.size() - 1, new Node(Math.min(cureNode.x, newNode.x), Math.max(
                        cureNode.y, newNode.y
                )));
            } else {
                tempList.add(newNode);
            }
            i++;
        }
        int ans[][] = new int[tempList.size()][2];
        i = 0;
        for (Node node : tempList) {
            ans[i][0] = node.x;
            ans[i++][1] = node.y;
        }
        return ans;
    }

    private boolean isOverlapping(Node prevNode, Node curNode) {
        return prevNode.x <= curNode.y && curNode.x <= prevNode.y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
