package ScalerAcademy.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / SingleElementInASortedArray
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the single element that appears only once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 7]
 * Input 2:
 *
 * A = [2, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * 7
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 7 appears once
 * Explanation 2:
 *
 * 2 appears once
 *
 * Approach: if the mid is even the mid+1 and mid must be same , if mid is odd mid-1 and mid must be same, when there is no single
 * repeated elements
 **/
public class SingleElementInASortedArray {
    public int solve(int[] array) {
        return bSearch(array);
    }

    private int bSearch(int[] array) {
        int beg = 0;
        int end = array.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;

            if ((mid == 0 || array[mid - 1] != array[mid])
                    &&
                    (mid + 1 >= array.length || array[mid + 1] != array[mid])) {
                return array[mid];
            }

            if ((mid & 1) == 0) {
                if (mid + 1 >= array.length || array[mid + 1] != array[mid]) {
                    end = mid - 1;
                } else {
                    beg = mid + 1;
                }
            } else {
                if (mid - 1 >= 0 && array[mid - 1] != array[mid]) {
                    end = mid - 1;
                } else {
                    beg = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArray().solve(new int[]{1, 1000000000, 1000000000}));
    }
}
