package TopicWiseSolutions.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MergeIntervals| on Dec,2019
 * Happy Coding :)
 *
 * Merge Intervals
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume that the intervals were initially sorted according to their start times. Example 1: Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9]. Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {
    /**
     * Definition for an interval.
     *
     *
     * Approach:Stack based approach
     */
    public class Interval {

        int start;

        int end;

        Interval() { start = 0; end = 0; }

        Interval(int s, int e) { start = s; end = e; }
    }
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
        ArrayList<Interval> list=new ArrayList<>(stack);
        return list;
    }
}
