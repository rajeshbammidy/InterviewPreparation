package ScalerAcademy.math_II;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / PairSumDivisibleByM
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 28
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 *  So total 4 pairs.
 */
public class PairSumDivisibleByM {
    static int mod = (int) (1e9 + 7);

    public int solve(int[] nums, int k) {
        long divisorCount[] = new long[k];
        for (int i = 0; i < nums.length; i++) {
            int remainder = nums[i] % k;
            ++divisorCount[remainder];
        }
        long sum = 0;
        sum = (divisorCount[0] * (divisorCount[0] - 1) / 2) % mod;

        for (int i = 1; i <= (k / 2) && i != (k - i); i++) {
            sum = (sum % mod + (divisorCount[i] % mod * divisorCount[k - i] % mod) % mod) % mod;
        }

        if ((k % 2) == 0) {
            sum = (sum % mod + (divisorCount[k / 2] * (divisorCount[k / 2] - 1) / 2) % mod) % mod;
        }

        return (int) ((sum));
    }

    public static void main(String[] args) {
    }
}
