package TopicWiseSolutions.Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math_II|TrailingZerosInFactorial| on Dec,2019
 * Happy Coding :)
 *
 * Trailing Zeros in Factorial
 * Given an integer n, return the number of trailing zeroes in n!. Note: Your solution should be in logarithmic time complexity. Example :
 * n = 5
 * n! = 120
 * Number of trailing zeros = 1
 * So, return 1
 */
public class TrailingZerosInFactorial {
    public int trailingZeroes(int num) {
        int num2 = 0, num5 = 0;
        int a = num, b = num;
        while (a > 0) {
            a = a / 2;
            num2 += a;
            if (a < 2) break;


        }
        while (b > 0) {
            b = b / 5;
            num5 += b;
            if (b < 5) break;


        }
        return Math.min(num2, num5);
    }
}
