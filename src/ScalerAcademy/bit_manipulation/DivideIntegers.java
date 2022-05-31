package ScalerAcademy.bit_manipulation;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.bit_manipulation / DivideIntegers
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Return the floor of the result of the division.
 *
 * Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
 *
 * NOTE: INT_MAX = 2^31 - 1
 *
 *
 *
 * Problem Constraints
 * -231 <= A, B <= 231-1
 *
 * B != 0
 *
 *
 *
 * Input Format
 * The first argument is an integer A denoting the dividend.
 * The second argument is an integer B denoting the divisor.
 *
 *
 *
 * Output Format
 * Return an integer denoting the floor value of the division.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 5
 * B = 2
 * Input 2:
 *
 * A = 7
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * floor(5/2) = 2
 *
 *
 * Approach:
 * First of all, As we all know already the basic idea for solving the problem with out the mod operator is simply identifying the number of times the divisor can fully SUBSTRACT the dividend as a whole but iterations are so costly and it will not work for large numbers. The obvious secret is to identify effective way to reduce the number of substractions
 *
 * The following is simply my idea but there can be many as well,
 *
 * 1. Exponentially increase the divisor until before it surpass the dividend then substract with it.
 * 2. Add up the divisor and find the remainder.
 * 3. Repeat the same until it brings to 0
 */
public class DivideIntegers {
    public int divide(int a, int b) {
        //Edge case
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        long count = 0;
        //get the sign of the numbers
        int signA = Integer.signum(a);
        int signB = Integer.signum(b);
        boolean isIntegerMinValue = false;
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);
        //fix the overflow
        if (num1 == Integer.MIN_VALUE) {
            isIntegerMinValue = true;
            num1 = Math.abs(a) - 1; // subtract -1 to fit into the int range ie.. 2^31-1
        }
        while (num1 - num2 >= 0) {
            int x = 0;
            while (num1 - (num2 << 1 << x) >= 0) x++;
            num1 -= (num2 << x);
            count += (1 << x);

        }
        if (isIntegerMinValue) {
            // add the subtracted -1 if needed
            count = count + 1 > Integer.MAX_VALUE ? Integer.MAX_VALUE + 1 : (num1 > 0 ? count : count + 1);
        }
        return (int) (count * signA * signB);
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
