package ScalerAcademy.binarySearch;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / MatrixMedian
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a matrix of integers A of size N x M in which each row is sorted.
 *
 * Find and return the overall median of matrix A.
 *
 * NOTE: No extra memory is allowed.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 10^5
 *
 * 1 <= N*M <= 10^6
 *
 * 1 <= A[i] <= 10^9
 *
 * N*M is odd
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the overall median of matrix A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 3, 5],
 *         [2, 6, 9],
 *         [3, 6, 9]   ]
 * Input 2:
 *
 * A = [   [5, 17, 100]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  17
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 *
 * Median is 17.
 **/
public class MatrixMedian {
    public int findMedian(int[][] array) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i][0]);
            max = Math.max(max, array[i][array[i].length - 1]);
        }
        return bSearchMedian(array, min, max);
    }

    private int bSearchMedian(int[][] array, int min, int max) {
        int beg = min;
        int end = max;
        int nl = (array.length * array[0].length) / 2;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                count += countNumbersLessThanEqualToMid(array[i], mid);
            }

            if (count <= nl) beg = mid + 1;
            else end = mid - 1;

        }

        return beg;

    }

    private int countNumbersLessThanEqualToMid(int[] array, int mid) {
        int index = Arrays.binarySearch(array, mid);
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        while (index < array.length && array[index] == mid) index++;
        return index;

    }


    public static void main(String[] args) {
        System.out.println(new MatrixMedian().findMedian(new int[][]{
                {1, 1, 3, 3, 3}
        }));

        System.out.println(Arrays.binarySearch(new int[]{1, 2, 4}, 3));
    }
}
