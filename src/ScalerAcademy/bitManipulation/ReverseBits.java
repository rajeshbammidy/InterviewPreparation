package ScalerAcademy.bitManipulation;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.bit_manipulation / ReverseBits
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * 0
 * Input 2:
 *
 * 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 0
 * Output 2:
 *
 * 3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 * 00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */

public class ReverseBits {
   /* public long reverse(long n) {
        String binaryString = new StringBuilder(Long.toBinaryString(n)).reverse().toString();
        char paddingZeroes[] = new char[32 - binaryString.length()];
        Arrays.fill(paddingZeroes, '0');
        String finalBinaryForm = binaryString + String.valueOf(paddingZeroes);
        return Long.parseLong(finalBinaryForm, 2);
    }*/

    public long reverse(long n) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                ans = (long) (ans + Math.pow(2, 32 - i - 1));
            }
        }
        return ans;
    }
}
