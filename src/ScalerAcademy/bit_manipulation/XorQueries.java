package ScalerAcademy.bit_manipulation;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.bit_manipulation / XorQueries
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * You are given an array A (containing only 0 and 1) as element of N length.
 * Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.
 *
 *
 *
 * Problem Constraints
 *
 * 1<=N,Q<=100000
 * 1<=L<=R<=N
 *
 *
 * Input Format
 *
 * First argument contains the array of size N containing 0 and 1 only.
 * Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.
 *
 *
 * Output Format
 *
 * Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.
 *
 *
 * Example Input
 *
 * A=[1,0,0,0,1]
 * B=[ [2,4],
 *     [1,5],
 *     [3,5] ]
 *
 *
 * Example Output
 *
 * [[0 3]
 * [0 3]
 * [1 2]]
 *
 *
 * Example Explanation
 *
 * In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1.
 * For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3.
 * Similarly for other queries.
 *
 * Approach: preprocess number of zeroes and ones
 * and also xor values depends on number of ones but not number of zeroes, because xor of any number of zeroes is always 0
 */
public class XorQueries {
    public int[][] solve(int[] array, int[][] queries) {
        int n = array.length;
        int res[][] = new int[queries.length][2];
        int preZeroes[] = new int[n];
        int preOnes[] = new int[n];
        preOnes[0] = array[0];
        preZeroes[0] = array[0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == 1) preOnes[i] = preOnes[i - 1] + 1;
            else preOnes[i] = preOnes[i - 1];
        }
        for (int i = 1; i < n; i++) {
            if (array[i] == 0) preZeroes[i] = preZeroes[i - 1] + 1;
            else preZeroes[i] = preZeroes[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int leftIndex = queries[i][0] - 1;
            int rightIndex = queries[i][1] - 1;
            int numberOfOnes = 0;
            int numberOfZeroes = 0;
            if (leftIndex == 0) {
                numberOfOnes = preOnes[rightIndex];
                numberOfZeroes = preZeroes[rightIndex];
            } else {
                leftIndex--;
                numberOfOnes = preOnes[rightIndex] - preOnes[leftIndex];
                numberOfZeroes = preZeroes[rightIndex] - preZeroes[leftIndex];
            }
            if ((numberOfOnes & 1) > 0) res[i][0] = 1;
            res[i][1] = numberOfZeroes;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new XorQueries().solve(new int[]{1, 0, 0, 0, 1}, new int[][]{{2, 4},
                {1, 5},
                {3, 5}})));
    }
}
