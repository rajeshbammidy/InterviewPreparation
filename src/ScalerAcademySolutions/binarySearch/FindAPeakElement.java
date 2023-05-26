package ScalerAcademySolutions.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / FindAPeakElement
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
 *
 * For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the peak element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  100
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  5 is the peak.
 * Explanation 2:
 *
 *  100 is the peak.
 **/
public class FindAPeakElement {
    public int solve(int[] array) {
        return bSearch(array);
    }

    private int bSearch(int[] array) {
        int beg = 0;
        int end = array.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;

            if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid + 1 >= array.length || array[mid + 1] <= array[mid])) {
                return array[mid];
            } else if (mid > 0 && array[mid - 1] > array[mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindAPeakElement().solve(new int[]{2, 3}));
    }
}
