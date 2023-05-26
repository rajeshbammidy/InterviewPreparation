package ScalerAcademySolutions.math2;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / SizeThreeSubsequencesDivisibleByB
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Given an array of integers A and an integer B. Find and return the number of subsequences of length 3 whose sum is divisible by B.
 *
 * Since the total number of subsequences may be very large.
 *
 * Return the total number of subsequences of length 3 whose sum is divisible by B modulo (109+7).
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the number of subsequences of length 3 whose sum is divisible by B modulo (10^9+7).
 * Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^3
 * For Example
 *
 * Input 1:
 *     A = [6, 1, 1, 4, 1, 5, 3]
 *     B = 2
 * Output 1:
 *     20
 *
 * Input 2:
 *     A = [4, 10, 9]
 *     B = 5
 * Output 2:
 *     0
 **/
public class SizeThreeSubsequencesDivisibleByB {
    public int solve(ArrayList<Integer> list, int k) {
        long modValues[] = new long[k];
        for (int x : list) {
            modValues[x % k]++;
        }
        int mod = (int) (1e9 + 7);
        long ans = 0;
        for (int i = 0; i < modValues.length; i++) {
            for (int j = i; j < modValues.length; j++) {
                int rem = (k - (i + j) % k) % k;
                if (rem < j) continue;
                if (i == j && rem == j) {
                    ans = ans + (modValues[i] * (modValues[i] - 1) * (modValues[i] - 2)) / 6;
                    ans = ans % mod;
                } else if (i == j) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[rem]) / 2;
                    ans = ans % mod;
                } else if (i == rem) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[j]) / 2;
                    ans = ans % mod;
                } else if (j == rem) {
                    ans = ans + ((modValues[j] * (modValues[j] - 1)) * modValues[i]) / 2;
                    ans = ans % mod;
                } else {
                    ans = ans + (modValues[i] * modValues[j] * modValues[rem]);
                    ans = ans % mod;
                }
            }

        }
        return (int) ans;
    }
}
