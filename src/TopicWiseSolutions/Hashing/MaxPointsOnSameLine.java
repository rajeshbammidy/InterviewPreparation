package TopicWiseSolutions.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Maximum Points on the same line
 * Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2-D plane. A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane. Find and return the maximum number of points which lie on the same line.
 * Input Format
 * The arguments given are integer arrays A and B.
 * Output Format
 * Return the maximum number of points which lie on the same line.
 * Constraints
 * 1 <= (length of the array A = length of array B) <= 1000
 * -10^5 <= A[i], B[i] <= 10^5
 * For Example
 * Input 1:
 * A = [-1, 0, 1, 2, 3, 3]
 * B = [1, 0, 1, 2, 3, 4]
 * Output 1:
 * 4
 * The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}
 * <p>
 * Input 2:
 * A = [3, 1, 4, 5, 7, -9, -8, 6]
 * B = [4, -8, -3, -2, -1, 5, 7, -4]
 * Output 2:
 * 2
 */
public class MaxPointsOnSameLine {
    public int solve(ArrayList<Integer> x, ArrayList<Integer> y) {

        int n = x.size();
        if (n < 2) return 0;
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        /**
         * !set.contains(x.get(i) + "-" + y.get(i)) is to avoid checking for the duplicates
         */
        for (int i = 0; i < n && !set.contains(x.get(i) + "-" + y.get(i)); i++) {

            int fixed[] = {x.get(i), y.get(i)};
            int same = 0;
            LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();

            int localMax = 0;           //to find local maxima
            for (int j = i + 1; j < n; j++) {

                if (isSame(fixed, x.get(j), y.get(j))) {
                    same++;
                    continue;
                }
                double slope = getSlope(fixed, x.get(j), y.get(j));
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            set.add(x.get(i) + "-" + y.get(i));
            max = Math.max(max, localMax + same);
        }
        return max;
    }

    private double getSlope(int[] fixed, Integer x2, Integer y2) {
        int x1 = fixed[0];
        int y1 = fixed[1];
        int x = x2 - x1;
        int y = y2 - y1;
        if (x == 0) return Double.MAX_VALUE;
        if (y == 0) return 0;

        return (double) (y) / (double) (x);
    }

    private boolean isSame(int[] fixed, Integer x2, Integer y2) {
        int x1 = fixed[0];
        int y1 = fixed[1];
        return x1 == x2 && y1 == y2;
    }
}
