package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|LengthofLongestSubsequence| on Jun,2020
 *  
 * Happy Coding :)
 * <p>
 * Problem Description
 * <p>
 * Given an 1D integer array A of length N, find the length of longest subsequence which is first increasing then decreasing.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= N <= 3000
 * <p>
 * -107 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer representing the answer as described in the problem statement.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 1]
 * Input 2:
 * <p>
 * A = [1, 11, 2, 10, 4, 5, 2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * [1, 2, 1] is the longest subsequence.
 * Explanation 2:
 * <p>
 * [1 2 10 4 2 1] is the longest subsequence.
 * <p>
 * Approach:
 * 1.Find the LIS from left side
 * 2.find the lis from right side
 **/
public class LengthofLongestSubsequence {
    int preDp[] = null;
    int sufDp[] = null;

    public int longestSubsequenceLength(final int[] arr) {
        if (arr.length == 0) return 0;
        preDp = new int[arr.length];
        Arrays.fill(preDp, 1);
        sufDp = new int[arr.length];
        Arrays.fill(sufDp, 1);
        lis(preDp, arr);
        int revArr[] = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            revArr[j++] = arr[i];
        }
        lis(sufDp, revArr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, (preDp[i] + sufDp[arr.length - 1 - i] - 1));
        }
        return max;
    }

    private void lis(int[] preDp, int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j]) {
                    preDp[j] = Math.max(preDp[j], preDp[i] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1};
        System.out.println(new LengthofLongestSubsequence().longestSubsequenceLength(arr));
    }
}
