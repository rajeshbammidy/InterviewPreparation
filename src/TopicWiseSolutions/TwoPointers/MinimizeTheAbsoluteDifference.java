package TopicWiseSolutions.TwoPointers;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.TwoPointers|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Minimize the absolute difference
 * Given three sorted arrays A, B and Cof not necessarily same sizes. Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |. Example : Input:
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output:
 * 1
 * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeTheAbsoluteDifference {
    public int solve(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int ia = 0, ib = 0, ic = 0;

        int m = a.size(), n = b.size(), o = c.size();

        int res = Integer.MAX_VALUE;

        while (ia < m && ib < n && ic < o) {
            int o1 = a.get(ia);
            int o2 = b.get(ib);
            int o3 = c.get(ic);
            /**
             * Find the min value among the o1,o2,o3 once you identify from which array we are getting the min value we explore the rest of the array to minimize the difference.
             *
             */
            res = Math.min(res, Math.abs(getMax(o1, o2, o3) - getmin(o1, o2, o3)));

            if (a.get(ia) == getmin(o1, o2, o3)) ia++;
            else if (b.get(ib) == getmin(o1, o2, o3)) ib++;
            else ic++;
        }
        return res;
    }

    private int getmin(int o1, int o2, int o3) {
        return Math.min(Math.min(o1, o2), o3);
    }

    private int getMax(int o1, int o2, int o3) {
        return Math.max(Math.max(o1, o2), o3);
    }
}
