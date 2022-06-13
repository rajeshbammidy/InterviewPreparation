package ScalerAcademy.backtracking;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / Sixlets
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a array of integers A of size N and an integer B.
 *
 * Return number of non-empty subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 20
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= N
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
 * Return number of subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     A = [1, 2, 8]
 *     B = 2
 * Input 2:
 *
 *     A = [5, 17, 1000, 11]
 *     B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  {1, 2}, {1, 8}, {2, 8}
 * Explanation 1:
 *
 *  No valid subsequence
 **/
public class Sixlets {

    public int solve(int[] array, int n) {
        return backtrack(0, 0, 0, array, n);
    }

    private int backtrack(int start, int curLen, int curSum, int[] array, int n) {
        if (curLen == n && curSum <= 1000) {
            return 1;
        }
        if (curSum > 1000) return 0;
        int ans = 0;
        for (int i = start; i < array.length; i++) {
            ans += backtrack(i + 1, curLen + 1, curSum + array[i], array, n);
        }
        return ans;
    }
}
