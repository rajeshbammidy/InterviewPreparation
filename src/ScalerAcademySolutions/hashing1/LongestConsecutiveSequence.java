package ScalerAcademySolutions.hashing1;

import java.util.HashSet;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / LongestConsecutiveSequence
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 *
 * A = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 *
 * The set of consecutive elements will be [1, 2].
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int longestConsecutiveLength = Integer.MIN_VALUE;
        for (int x : array
        ) {
            set.add(x);
        }
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i]) && !set.contains(array[i] - 1)) {
                int element = array[i];
                int count = 0;
                while (set.contains(element)) {
                    count++;
                    element++;
                }
                longestConsecutiveLength = Math.max(longestConsecutiveLength, count);
            }
        }
        return longestConsecutiveLength;

    }

}
