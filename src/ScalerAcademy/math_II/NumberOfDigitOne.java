package ScalerAcademy.math_II;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / NumberOfDigitOne
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= A <= 109
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer A.
 *
 *
 *
 * Output Format
 *
 * Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = 10
 * Input 2:
 *
 * A = 11
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
 * Explanation 2:
 *
 * Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
 */

/**
 * Appraoch:
 * Number of 1's in ones place:
 *  0-10 :1
 *  0:20:2
 *  0:30:3
 *  0:40:4
 *
 *  so number of 1's in ones place : n/10 + ((n%10>0)?1:0)
 *  ex: 84
 *   84/100 = 4
 *   84%10 = 4 > 1 ? 1:0
 * ---------------------------------------------------------
 *
 * Number of 1's in 10's place
 * 0-10 :1
 * 0-20 :10;
 * 0-30 :10
 * 0-40 :10
 *
 *
 * so number of 1's in 10's place :
 *
 * n/100 + min(max(n%100 - 9, 0), 10)
 *
 *
 *
 *so formula would be (n/i*10 )* i  + min (  max( n% (i*10)  - (i-1),  0), i  )
 *
 * where i =1,10,100
 */
public class NumberOfDigitOne {

    public int solve(int number) {
        int numberOfDigits = (int) (Math.log10(number) + 1);
        int sum = 0;

        for (int i = 0; i < numberOfDigits; i++) {
            int tenMultiplier = (int) (Math.pow(10, i));
            int a = ((number / (tenMultiplier * 10)) * tenMultiplier);
            int b = Math.max((number % (tenMultiplier * 10)) - (tenMultiplier - 1), 0);
            int c = Math.min(b, tenMultiplier);
            sum = sum + (a + c);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(20 / 100);
        System.out.println(new NumberOfDigitOne().solve(20));
    }
}
