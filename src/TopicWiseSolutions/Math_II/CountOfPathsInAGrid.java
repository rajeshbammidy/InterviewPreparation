package TopicWiseSolutions.Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math_II|CountOfPathsInAGrid| on Dec,2019
 * Happy Coding :)
 *
 * Count of paths in a grid
 * Given an integer A, find and return the number of paths in a grid of size (A x A) that starts from (1, 1) and reaches (A, A) without crossing the major diagonal. Since the result can be large, return the result modulo (10^9 + 7). NOTE
 * The major diagonal of a matrix A is the collection of entries A[i][j] where i == j
 *
 * Input Format
 * The only argument given is integer A.
 * Output Format
 * Return the number of paths modulo (10^9 + 7).
 * Constraints
 * 1 <= A <= 10^6
 * For Example
 * Input 1:
 *     A = 2
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = 5
 * Output 2:
 *     14
 */
public class CountOfPathsInAGrid {
    /*
   Approach:Find the (n-1)th catalan number
     */
    public static int solve(int n) {
        int mod = (1000000000 + 7);

        int ncr = find(n);
        return ncr;
    }

    private static int find(int r) {
        int mod = (1000000000 + 7);
        long catalan[] = new long[r];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i < r; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum = (sum % mod + (((catalan[j] % mod) * (catalan[i - j - 1] % mod)) % mod) % mod) % mod;

            }
            catalan[i] = sum;
        }
        return (int) catalan[r - 1];
    }
}
