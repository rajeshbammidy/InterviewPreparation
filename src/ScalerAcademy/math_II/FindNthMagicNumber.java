package ScalerAcademy.math_II;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / FindNthMagicNumber
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given an integer A, find and return the Ath magic number.
 *
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 *
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 5000
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the Ath magic number.
 *
 *
 *
 * Example Input
 * Example Input 1:
 *
 * A = 3
 * Example Input 2:
 *
 * A = 10
 *
 *
 * Example Output
 * Example Output 1:
 *
 * 30
 * Example Output 2:
 *
 * 650
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 * 3rd element in this is 30
 * Explanation 2:
 *
 * In the sequence shown in explanation 1, 10th element will be 650.
 *
 *
 *
 * Approach: Just think about the binary representation of a number which is sum of uniq of powers of base ie.. 2,5,10
 */
public class FindNthMagicNumber {


    public int solve(int n) {
        long binaryForm = Long.parseLong(Integer.toBinaryString(n));
        int c = 1;
        int ans = 0;
        while (binaryForm > 0) {
            long lsb = binaryForm % 10;
            ans += Math.pow(5, c) * lsb;
            c++;
            binaryForm /= 10;
        }
        return ans;
    }
}
