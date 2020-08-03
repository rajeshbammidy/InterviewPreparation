package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|LongestArithmeticProgression| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Find longest Arithmetic Progression in an integer array A of size N, and return its length.
 *
 * More formally, find longest sequence of indices, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression.
 *
 * Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2]
 *
 * Note: The common difference can be positive, negative or 0.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains an integer array, A.
 * Output Format:
 *
 * Return an integer, representing the length of the longest possible arithmetic progression.
 * Constraints:
 *
 * 1 <= N <= 1000
 * 1 <= A[i] <= 1e9
 * Examples:
 *
 * Input 1:
 *     A = [3, 6, 9, 12]
 *
 * Output 1:
 *     4
 *
 * Explanation 1:
 *     [3, 6, 9, 12] form an arithmetic progression.
 *
 * Input 2:
 *     A = [9, 4, 7, 2, 10]
 *
 * Output 2:
 *     3
 *
 * Explanation 2:
 *     [4, 7, 10] form an arithmetic progression.
 **/
public class LongestArithmeticProgression {
    /**
     * Approach:Similar to LIS
     * dp list stores endingwith given difference and corresponding length
     */
    public int solve(final int[] arr) {
        if (arr.length <= 2) return arr.length;
        ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            dp.add(map);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                if (dp.get(i).get(diff) != null) {
                    dp.get(j).put(diff, dp.get(i).get(diff) + 1);
                } else {

                    dp.get(j).put(diff, 2);
                }
                ans = Math.max(ans, dp.get(j).get(diff));
            }

        }
        return ans;
    }
}
