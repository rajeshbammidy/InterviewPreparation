package ScalerAcademy.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / SumTheDifference
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2]
 * Input 2:
 *
 * A = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 *
 * Only 1 subsequence of 1 element is formed.
 **/
public class SumTheDifference {

    public int solve(ArrayList<Integer> list) {
        Collections.sort(list);
        int mod = (int) (1e9 + 7);
        int n = list.size();
        long maxElementSum = 0, minElementSum = 0;
        for (int i = 0; i < n; i++) {

            maxElementSum = (maxElementSum % mod + ((fastExp(2, i, mod) % mod * list.get(i) % mod) % mod)) % mod;
            minElementSum = (minElementSum % mod + (fastExp(2, n - i - 1, mod) % mod * list.get(i) % mod) % mod) % mod;

        }
        return (int) (maxElementSum - minElementSum + mod) % mod;
    }

    private long fastExp(long m, int n, int mod) {
        if (n == 0) return 1;
        if ((n & 1) == 0) {
            return fastExp((m % mod * m % mod) % mod, n / 2, mod) % mod;
        }
        return (m % mod * fastExp(m, (n - 1), mod) % mod) % mod;
    }
}
