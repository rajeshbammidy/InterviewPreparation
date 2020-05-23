package Arrays;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|IntervalListIntersections| on May,2020
 *  
 * Happy Coding :)
 **/
public class IntervalListIntersections {
    static class node {
        int start;
        int end;

        public node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        int k = 0;
        ArrayList<node> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            // check if the interval A[i] intersects with B[j]
            // check if one of the interval's start time lies within the other interval
            if ((A[i][0] >= B[j][0] && A[i][0] <= B[j][1]) ||
                    (B[j][0] >= A[i][0] && B[j][0] <= A[i][1])) {
                // store the intersection part

                list.add(new node(Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])));

            }
            // move next from the interval which is finishing first
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        int res[][] = new int[list.size()][2];

        for (node x : list) {
            res[k][0] = x.start;
            res[k++][1] = x.end;
        }
        return res;

    }
}
