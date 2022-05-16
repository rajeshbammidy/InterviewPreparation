package ScalerAcademy.math_II;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / TrailingZerosInFactorial
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Approach:
 * Number of 5's in factorial of number is always less than number of 2's, therefore we just have to find the number of 5's
 *
 */
public class TrailingZerosInFactorial {

    public int trailingZeroes(int n) {
        int c = 5;
        int ans = 0;
        while (c <= n) {
            ans += n / c;
            c *= 5;
        }
        return ans;
    }
}
