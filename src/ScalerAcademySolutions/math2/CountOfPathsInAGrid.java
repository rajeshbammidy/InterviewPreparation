package ScalerAcademySolutions.math2;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / CountOfPathsInAGrid
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/***
 * Given an integer A, find and return the number of paths in a grid of size (A x A) that starts from (1, 1) and reaches (A, A) without crossing the major diagonal.
 *
 * Since the result can be large, return the result modulo (10^9 + 7).
 *
 * NOTE
 *
 * The major diagonal of a matrix A is the collection of entries A[i][j] where i == j
 *
 * Input Format
 *
 * The only argument given is integer A.
 * Output Format
 *
 * Return the number of paths modulo (10^9 + 7).
 * Constraints
 *
 * 1 <= A <= 10^6
 * For Example
 *
 * Input 1:
 *     A = 2
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = 5
 * Output 2:
 *     14
 *
 */
public class CountOfPathsInAGrid {
    public int solve(int n) {

        return findNthCatalanNumber(n);
    }

    private int findNthCatalanNumber(int n) {
        int mod = (int) (Math.pow(10, 9) + 7);
        long catalan[] = new long[n];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i < catalan.length; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum = (sum % mod + (((catalan[j] % mod) * (catalan[i - j - 1] % mod)) % mod) % mod) % mod;
            }
            catalan[i] = sum;
        }
        return (int) catalan[n - 1];
    }

}
