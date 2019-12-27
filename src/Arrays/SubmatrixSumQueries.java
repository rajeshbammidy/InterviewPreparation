package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|SubmatrixSumQueries| on Dec,2019
 * Happy Coding :)
 *
 * Sub-matrix Sum Queries
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum. Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out. Note: Rows are numbered from top to bottom and columns are numbered from left to right. Sum may be large so return the answer mod 10^9 + 7.
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 * Output Format
 * Return the submatrix sum (% 10^9 + 7) for each query in the form of an integer array.
 * Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 * For Example
 * Input 1:
 *     A = [   [1, 2, 3]
 *             [4, 5, 6]
 *             [7, 8, 9]   ]
 *     B = [1, 2]
 *     C = [1, 2]
 *     D = [2, 3]
 *     E = [2, 3]
 * Output 1:
 *     [12, 28]
 *
 * Input 2:
 *     A = [   [5, 17, 100, 11]
 *             [0, 0,  2,   8]    ]
 *     B = [1, 1]
 *     C = [1, 4]
 *     D = [2, 2]
 *     E = [2, 4]
 * Output 2:
 *     [22, 19]
 */
public class SubmatrixSumQueries {
    public int[] solve(int[][] arr, int[] b, int[] c, int[] d, int[] e) {
        int mod = (int) (1e9 + 7);
        int m = arr.length;
        int n = arr[0].length;
        //long to avoid overflow issues
        long aux[][] = new long[m][n];
        //copy the first row into the aux;
        for (int i = 0; i < n; i++) aux[0][i] = arr[0][i];

        //sum up the columns vertically in the aux array
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                aux[i][j] = ((arr[i][j] + aux[i - 1][j]) % mod + mod) % mod;
            }
        }

        //sum up the rows horizontally
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                aux[i][j] = ((aux[i][j - 1] + aux[i][j]) % mod + mod) % mod;
            }
        }

        int q = b.length;
        int rest[] = new int[q];
        int r = 0;
        //process the queries
        for (int i = 0; i < q; i++) {
            int tli = b[i] - 1;
            int tlj = c[i] - 1;
            int bri = d[i] - 1;
            int brj = e[i] - 1;
            long res = aux[bri][brj];
            //if top left row is greater than 0
            if (tli > 0)
                res = ((res - aux[tli - 1][brj]) % mod + mod) % mod;
            //if top left col is greater than 0
            if (tlj > 0) res = ((res - aux[bri][tlj - 1]) % mod + mod) % mod;

            //If both are greater than zero then we must be deleting the cells twice so we add them again
            if (tli > 0 && tlj > 0) {
                res = ((res + aux[tli - 1][tlj - 1]) % mod + mod) % mod;
            }
            rest[r++] = (int) ((res % mod + mod) % mod);
        }
        return rest;
    }

}
