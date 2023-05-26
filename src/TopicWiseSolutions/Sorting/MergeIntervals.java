package TopicWiseSolutions.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Sorting|MergeIntervals| on May,2020
 *  
 * Happy Coding :)
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 **/
public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int arr[][]) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < arr.length; i++) {
            intervals.add(new Interval(arr[i][0], arr[i][1]));
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Stack<Interval> stack = new Stack<>();
        for (Interval cur : intervals) {
            if (stack.isEmpty()) {
                stack.add(cur);
                continue;
            }
            int beforeLast = stack.peek().end;
            int currStart = cur.start;
            if (currStart <= beforeLast) {
                Interval temp = stack.pop();
                temp.end = beforeLast < cur.end ? cur.end : beforeLast;
                stack.add(temp);
            } else {
                stack.add(cur);
            }
        }
        ArrayList<Interval> list = new ArrayList<Interval>(stack);
        int res[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).start;
            res[i][1] = list.get(i).end;
        }

        return res;
    }
}
