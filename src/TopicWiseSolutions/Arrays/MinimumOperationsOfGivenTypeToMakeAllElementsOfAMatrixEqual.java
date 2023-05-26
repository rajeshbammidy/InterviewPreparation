package TopicWiseSolutions.Arrays;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MinimumOperationsOfGivenTypeToMakeAllElementsOfAMatrixEqual| on Dec,2019
 * Happy Coding :)
 *
 * Minimum operations of given type to make all elements of a matrix equal
 * Given a matrix of integers A of size N x M and an integer B. In a single operation, B can be added to or subtracted from any element of the matrix. Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead. Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 * Output Format
 * Return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 * Constraints
 * 1 <= N, M <= 1000
 * -1000 <= A[i] <= 1000
 * 1 <= B <= 1000
 * For Example
 * Input 1:
 * A = [   [0, 2, 8]
 * [8, 2, 0]
 * [0, 2, 8]   ]
 * B = 2
 * Output 1:
 * 12
 *
 * Input 2:
 * A = [   [5, 17, 100, 11]
 * [0, 0,  2,   8]    ]
 * B = 3
 * Output 2:
 * -1
 */
public class MinimumOperationsOfGivenTypeToMakeAllElementsOfAMatrixEqual {
    /**
     * Approach:The catch here is:It is given in the question that we can add or substract k from arr[i][j] that means x % K = (x + K) % K = (x – K) % K so mod of all the elements(arr[i][j]) with k should be same.We will make use of this factor to find if it is possible to make all the elements of the 2D array same.
     */
    public int solve(int[][] arr, int k) {
        int mod = arr[0][0] % k;
        //If mod gives negative make it positive by adding k to it
        if (mod < 0) mod = (mod + k) % k;
        int m = arr.length;
        int n = arr[0].length;
        int res[] = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //copying the elements into 1D array
                res[i * n + j] = arr[i][j];
                int curmod = arr[i][j] % k;
                if (curmod < 0) curmod = (curmod + k) % k;
                //If the mod is not same for all the elements then it is not possible to make the all the elements equal
                if (curmod != mod) return -1;
            }
        }
        Arrays.sort(res);
        int l = res.length;
        if (l % 2 == 0) {//if the len is of even size
            int mid = l / 2;
            //find the median because it is the central tendency
            int median = (res[mid] + res[mid - 1]) / 2;
            int op = 0;
            //Now check how many operations are required to make each element equal to the median
            for (int i = 0; i < l; i++) {
                op += Math.abs(res[i] - median) / k;//we divide with k to get the num of operations
            }
            return op;
        } else {//if the len is of odd size
            int mid = l / 2;
            int median = res[mid];
            int op = 0;
            for (int i = 0; i < l; i++) {
                op += Math.abs(res[i] - median) / k;
            }
            return op;
        }
    }

    public static void main(String[] args) {

    }
}
