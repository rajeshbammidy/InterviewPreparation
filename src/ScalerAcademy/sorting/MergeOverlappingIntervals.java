package ScalerAcademy.sorting;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / MergeOverlappingIntervals
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a collection of intervals, merge all overlapping intervals.
 *
 *
 *
 * Problem Constraints
 * 1 <= Total number of intervals <= 100000.
 *
 *
 *
 * Input Format
 * First argument is a list of intervals.
 *
 *
 *
 * Output Format
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1,3],[2,6],[8,10],[15,18]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1,6],[8,10],[15,18]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merge intervals [1,3] and [2,6] -> [1,6].
 * so, the required answer after merging is [1,6],[8,10],[15,18].
 * No more overlapping intervals present.
 **/

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

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prevInterval = res.get(res.size() - 1);
            Interval currInterval = intervals.get(i);
            if (prevInterval.end >= currInterval.start) {
                res.remove(res.size() - 1);
                res.add(new Interval(prevInterval.start, Math.max(prevInterval.end, currInterval.end)));
            } else {
                res.add(currInterval);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        System.out.println(new MergeOverlappingIntervals().merge(list));
    }
}
