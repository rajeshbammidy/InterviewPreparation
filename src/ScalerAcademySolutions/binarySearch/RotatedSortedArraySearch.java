package ScalerAcademySolutions.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / RotatedSortedArraySearch
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B.
 *
 * array A is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * 1 <= A[i] <= 10^9
 *
 * all elements in A are distinct.
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return index of B in array A, otherwise return -1
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 *
 * A = [1]
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 *
 *
 * Target 1 is found at index 0 in A.
 **/
public class RotatedSortedArraySearch {
    public int search(final int[] array, int k) {
        return bSearch(array, k);
    }

    private int bSearch(int[] array, int k) {
        int beg = 0;
        int end = array.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;

            if (array[mid] == k) {
                return mid;
            } else if (array[beg] < array[mid]) {

                if (array[beg] <= k && k < array[mid]) {
                    end = mid - 1;
                } else {
                    beg = mid + 1;
                }

            } else {
                if (array[mid] < k && k <= array[end]) {
                    beg = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedSortedArraySearch().search(new int[]{4},4));
    }
}
