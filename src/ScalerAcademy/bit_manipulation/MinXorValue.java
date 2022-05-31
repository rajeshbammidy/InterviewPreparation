package ScalerAcademy.bit_manipulation;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.bit_manipulation / MinXorValue
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 *
 *
 * Problem Constraints
 * 2 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting minimum xor value.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [0, 2, 5, 7]
 * Input 2:
 *
 * A = [0, 4, 7, 9]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 0 xor 2 = 2
 *
 * Appraoch: The xor of two consecutive numbers will be always less than any two other numbers
 *
 * Proof:
 * a
 * a-1 -- the values will get toglled from the first set bit of a
 */
public class MinXorValue {
    public int findMinXor(int[] array) {
        Arrays.sort(array);
        int ans = array[0] ^ array[1];
        for (int i = 2; i < array.length; i++) {
            ans = Math.min(ans, array[i] ^ array[i - 1]);
        }
        return ans;
    }
}
