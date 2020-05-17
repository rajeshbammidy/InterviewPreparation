package Sorting;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|SumtheDifference| on May,2020
 *  
 * Happy Coding :)
 *
 * Problem Description
 * Given an integer array A of size N. You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number. As the number may be large, output the number modulo 1e9 + 7 (1000000007). NOTE: Subsequence can be non-contiguous.
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000 1<= A[i] <=1000
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer denoting the output.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2]
 *   Input 2:
 * A = [1]
 *
 *
 *
 * Example Output
 * Output 1:
 *  1
 *   Output 2:
 *  0
 *
 *
 *
 * Example Explanation
 * Explanation 1:
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 *   Explanation 2:
 *  Only 1 subsequence of 1 element is formed.
 *
 **/
public class SumtheDifference {
    public static final int mod = (int) (1e9 + 7);

    public int solve(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int min = Math.min(arr[i], arr[j]);
                int max = Math.max(arr[i], arr[j]);
                int combinations = fast_exp(2, j - i - 1) % mod;
                int curSum = (combinations % mod * (max - min) % mod) % mod;
                sum = (sum % mod + curSum % mod) % mod;
            }

        }
        return sum;
    }

    private int fast_exp(int m, int n) {
        if (n == 0) return 1;

        if ((n & 1) == 0) {
            return fast_exp(m * m, n / 2) % mod;
        } else
            return (m % mod * fast_exp(m, (n - 1)) % mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new SumtheDifference().fast_exp(2, 0));
    }
}
