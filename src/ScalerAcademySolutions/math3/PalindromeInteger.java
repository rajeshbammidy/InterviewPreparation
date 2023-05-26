package ScalerAcademySolutions.math3;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_III / PalindromeInteger
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.
 *
 * Example :
 *
 * Input : 12121
 * Output : True
 *
 * Input : 123
 * Output : False
 */
public class PalindromeInteger {
    public int isPalindrome(int num) {

        int res = 0;
        int temp = num;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;

        }
        return res == Math.abs(temp) ? 1 : 0;
    }
}
