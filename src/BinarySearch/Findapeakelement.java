package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|Findapeakelement| on Apr,2020
 *  
 * Happy Coding :)
 * <p>
 * Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element. Following corner cases give better idea about the problem.
 * 1) If input array is sorted in strictly increasing order, the last element is always a peak element.
 * For example, 5 is peak element in {1, 2, 3, 4, 5}.
 * 2) If input array is sorted in strictly decreasing order, the first element is always a peak element.
 * 10 is the peak element in {10, 9, 8, 7, 6}.
 * Note: It is guranteed that the answer is unique.
 * Input Format
 * The only argument given is the integer array A.
 * Output Format
 * Return the peak element.
 * Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * For Example
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * Output 1:
 * 5
 * <p>
 * Input 2:
 * A = [5, 17, 100, 11]
 * Output 2:
 * 100
 **/
public class Findapeakelement {
    public int solve(int[] arr) {
        if (arr.length == 1) return arr[0];

        return binaryserach(arr, 0, arr.length - 1);
    }

    private int binaryserach(int[] arr, int beg, int end) {
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]))
                return arr[mid];
            if (mid == arr.length - 1 || arr[mid] < arr[mid + 1]) beg = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
