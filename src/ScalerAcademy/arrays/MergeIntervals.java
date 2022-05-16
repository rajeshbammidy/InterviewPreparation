package ScalerAcademy.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / MergeIntervals
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 * 0 <= |intervals| <= 105
 *
 *
 *
 * Input Format
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 * Return the vector of intervals after merging
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 * Output 2:
 *
 *  [ [1, 9] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval peek = stack.peek();
            Interval cur = intervals.get(i);

            if (peek.end < cur.start) stack.push(cur);
            else if (peek.end < cur.end) {
                stack.pop();
                peek.end = cur.end;
                stack.push(peek);
            }


        }
        ArrayList<Interval> list = new ArrayList<>(stack);
        return list;
    }
}
