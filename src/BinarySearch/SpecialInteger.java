package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|SpecialInteger| on Apr,2020
 *  
 * Happy Coding :)
 * Special Integer
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * Output Format
 * Return the maximum value of K (sub array length).
 * Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 * For Example
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Output 1:
 * 2
 * <p>
 * Input 2:
 * A = [5, 17, 100, 11]
 * B = 130
 * Output 2:
 * 3
 **/
public class SpecialInteger {
    public int solve(int[] arr, int k) {
        int beg = 1;
        int end = arr.length;
        int ans = 0;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;

            int sum = 0;
            for (int i = 0; i < mid; i++) {
                sum += arr[i];
                if (sum > k) break;
            }
            if (sum <= k) {
                for (int i = mid; i < arr.length; i++) {
                    sum -= arr[i - mid];
                    sum += arr[i];
                    if (sum > k) break;
                }
            }

            if (sum >= k) end = mid - 1;
            else {
                ans = mid;
                beg = mid + 1;
            }

        }
        return ans;
    }
}
