package LeetCode.MonthlyChallenges_23.Jan23;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize
 * the numbers seen so far as a list of disjoint intervals.
 *
 * Implement the SummaryRanges class:
 *
 *
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in the stream
 * currently as a list of disjoint intervals [starti, endi]. The answer should be sorted
 * by starti.
 *
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum",
 * "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * Output
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
 * null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * Explanation
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= value <= 10⁴
 * At most 3 * 10⁴ calls will be made to addNum and getIntervals.
 *
 *
 *
 * Follow up: What if there are lots of merges and the number of disjoint
 * intervals is small compared to the size of the data stream?
 *
 * Related Topics Binary Search Design Ordered Set 👍 1452 👎 315
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Approach: Add them into TreeSet to avoid duplicates and can obtain the numbers in sorted order
 */
class SummaryRanges352 {
    TreeSet<Integer> set;

    public SummaryRanges352() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        ArrayList<Pair> list = new ArrayList<>();
        /**
         * Copy the elements into ArrayList for easier access, you can also use iterator
         */
        ArrayList<Integer> sortedStartsList = new ArrayList<>(set);
        int start = 0;
        for (int i = 1; i < sortedStartsList.size(); i++) {
            /**
             * If the element at i is not consecutive to element at i-1 add the pair into list
             */
            if (sortedStartsList.get(i - 1) + 1 != sortedStartsList.get(i)) {
                list.add(new Pair(sortedStartsList.get(start), sortedStartsList.get(i - 1)));
                start = i;
            }
        }
        /**
         * To handle some edges cases, easy to understand
         */
        if (start < sortedStartsList.size() - 1) {
            list.add(new Pair(sortedStartsList.get(start), sortedStartsList.get(sortedStartsList.size() - 1)));
        } else if (start == sortedStartsList.size() - 1) {
            list.add(new Pair(sortedStartsList.get(sortedStartsList.size() - 1), sortedStartsList.get(sortedStartsList.size() - 1)));
        }

        /**
         * Copy the elements to 2D array
         */
        int result[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> pair = list.get(i);
            result[i][0] = pair.getKey();
            result[i][1] = pair.getValue();
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)
