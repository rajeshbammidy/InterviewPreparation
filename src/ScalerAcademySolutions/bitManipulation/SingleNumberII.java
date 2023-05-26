package ScalerAcademySolutions.bitManipulation;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.bit_manipulation / SingleNumberII
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Given an array of integers, every element appears thrice except for one, which occurs once.
 *
 * Find that element that does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 *
 *
 *
 * Problem Constraints
 * 2 <= A <= 5*106
 *
 * 0 <= A <= INTMAX
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Input 2:
 *
 *  A = [0, 0, 0, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 occurs exactly once in Input 1.
 *  1 occurs exactly once in Input 2.
 *
 *  Appraoch: You can make use of 32 bit sized array check for 3 1's or 3 0's
 */
public class SingleNumberII {
    public int singleNumber(final int[] array) {
        int bits[] = new int[32];
        for (int num : array) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((1 << i) * bits[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{1, 1, 1, 2, 2, 2, 3}));
    }
}
