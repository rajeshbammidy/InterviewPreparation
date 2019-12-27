package Math_I;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_I|RepeatedSubtraction| on Dec,2019
 * Happy Coding :)
 *
 * Repeated Subtraction
 * You are given 2 numbers P and Q. An operation on these 2 numbers is defined as follows: Take the smaller number of the 2 numbers and subtract it from the bigger number. Keep performing this operation till either of the following criterion is met:
 * Both numbers become equal.
 * Either of the number becomes 0.
 * Find the sum of the final values of P and Q. Constraints:
 *  0 <= P,Q <= 1e9
 * Input:
 * Two integers P and Q
 * Output:
 * Sum of the final values of P and Q
 * Example: Input:
 * P : 5
 * Q : 15
 * Output:
 * 10
 * Explanation:
 * For the first operation, smaller of P and Q is P.
 * So we subtract P from Q which gives us the new values of P and Q as 5 and 10 resp.
 * For the second operation, smaller of P and Q is P.
 * So we subtract P from Q which gives us the new values of P and Q as 5 and 5 resp.
 * Since the values of P and Q are now same, we output the sum of these values=10.
 */
public class RepeatedSubtraction {
    public int getFinal(int a, int b) {
        /**
         * This is becuase if one among them equals to 1,it will decrement the other number till it becomes equal to it there for we return 2
         */
        if (a == 1 || b == 1) return 2;
        if (a == 0) return b;
        if (a == b) return a + b;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return getFinal(min, max - min);
    }
}
