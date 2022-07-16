package ScalerAcademy.arraysAndMath;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays_and_math / MaximumConsecutiveGap
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given an unsorted integer array A of size N.
 * Find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 * Return 0 if the array contains less than 2 elements.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The first argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum difference.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 10, 5]
 * Input 2:
 *
 * A = [10, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 * 5
 * Output 2:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * After sorting, the array becomes [1, 5, 10]
 * Maximum difference is (10 - 5) = 5.
 * Explanation 2:
 *
 * Maximum difference is (10 - 9) = 1.
 *
 *
 * Approach:
 * -> Used RadixSort which takes d(n+k) where d is 10 and k is also 10 here
 * Where d could be number of digits in a number
 */
public class MaximumConsecutiveGap {

    void countSortForRadixSort(int array[], int n, int exp) {
        int count[] = new int[10];
        for (int value : array) {
            count[(value / exp) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int currentElement = array[i];
            int indexOfElement = (currentElement / exp) % 10;
            int numberOfNumbersLessthanCurElement = count[indexOfElement] - 1;
            output[numberOfNumbersLessthanCurElement] = currentElement;
            count[indexOfElement] -= 1;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    public int maximumGap(final int[] A) {
        if (A.length < 2) return 0;
        int array[] = Arrays.copyOf(A, A.length);// had to copy this because org array is of type final
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            maxValue = Math.max(maxValue, value);
        }

        for (int exp = 1; (maxValue / exp) > 0; exp *= 10) {
            countSortForRadixSort(array, array.length, exp);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            ans = Math.max(ans, array[i] - array[i - 1]);
        }
        return ans;
    }
}
