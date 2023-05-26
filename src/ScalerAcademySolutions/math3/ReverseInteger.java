package ScalerAcademySolutions.math3;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_III / ReverseInteger
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 *
 * You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer
 *
 * Look at the example for clarification.
 *
 *
 *
 * Problem Constraints
 *
 * N belongs to the Integer limits.
 *
 *
 *
 * Input Format
 *
 * Input an Integer.
 *
 *
 *
 * Output Format
 *
 * Return a single integer denoting the reverse of the given integer.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  x = 123
 *
 * Input 2:
 *
 *  x = -123
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  321
 *
 * Ouput 2:
 *
 *  -321
 *
 *
 * Example Explanation
 *
 *  If the given integer is negative like -123 the output is also negative -321.
 */
public class ReverseInteger {
    public int reverse(int num) {
        int sign = (int) Math.signum(num);
        long res = 0;
        int temp = Math.abs(num);
        while (temp != 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
            int aux = sign * (int) (res);
            if (aux != (sign * res)) {
                return 0;
            }

        }
        return (int) (sign * res);
    }
}
