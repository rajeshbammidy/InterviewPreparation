package ScalerAcademy.arrays;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / MinimumOperationsOfGivenTypeToMakeAllElementsOfAMatrixEqual
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * In a single operation, B can be added to or subtracted from any element of the matrix.
 *
 * Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -1000 <= A[i] <= 1000
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A. The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 *
 *
 * Example Input
 *
 * A = [
 * [0, 2, 8]
 * [8, 2, 0]
 * [0, 2, 8]
 * ]
 * B = 2
 *
 *
 * Example Output
 *
 * 12
 *
 *
 * Example Explanation
 *
 * We can make all value equal to 2 by adding 2 one time to 0's and subtracting 2 three times from 8's.
 * So there are all total 12 operations needed to be done.
 *
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * In a single operation, B can be added to or subtracted from any element of the matrix.
 *
 * Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -1000 <= A[i] <= 1000
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A. The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 *
 *
 * Example Input
 *
 * A = [
 * [0, 2, 8]
 * [8, 2, 0]
 * [0, 2, 8]
 * ]
 * B = 2
 *
 *
 * Example Output
 *
 * 12
 *
 *
 * Example Explanation
 *
 * We can make all value equal to 2 by adding 2 one time to 0's and subtracting 2 three times from 8's.
 * So there are all total 12 operations needed to be done.
 */

/**
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * In a single operation, B can be added to or subtracted from any element of the matrix.
 *
 * Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -1000 <= A[i] <= 1000
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A. The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.
 *
 *
 *
 * Example Input
 *
 * A = [
 * [0, 2, 8]
 * [8, 2, 0]
 * [0, 2, 8]
 * ]
 * B = 2
 *
 *
 * Example Output
 *
 * 12
 *
 *
 * Example Explanation
 *
 * We can make all value equal to 2 by adding 2 one time to 0's and subtracting 2 three times from 8's.
 * So there are all total 12 operations needed to be done.
 */


/**
 * Approach:The catch here is:It is given in the question that we can add or substract k from arr[i][j] that means x % K = (x + K) % K = (x – K) % K so mod of all the elements(arr[i][j]) with k should be same.We will make use of this factor to find if it is possible to make all the elements of the 2D array same.
 */
public class MinimumOperationsOfGivenTypeToMakeAllElementsOfAMatrixEqual {
    public int solve(int[][] array, int x) {
        int rows = array.length;
        int columns = array[0].length;
        int res[] = new int[rows * columns];
        int modValue = array[0][0] % x;
        //If mod gives negative make it positive by adding x to it
        if (modValue < 0) {
            modValue = (modValue + x) % x;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentModValue = array[i][j] % x;
                if (currentModValue < 0) currentModValue = (currentModValue + x) % x;
                if (currentModValue != modValue) {
                    return -1;
                }
                res[i * columns + j] = array[i][j];
            }
        }
        Arrays.sort(res);
        int resLength = res.length;
        int mid = resLength / 2;
        int minOps = 0;
        if (resLength % 2 == 0) {
            //find the median because it is the central tendency
            int median = (res[mid] + res[mid - 1]) / 2;
            for (int i = 0; i < resLength; i++) {
                //we divide with x to get the num of operations
                minOps += (Math.abs(median - res[i]) / x);
            }
            return minOps;
        }
        int median = (res[mid]);
        for (int i = 0; i < resLength; i++) {
            minOps += (Math.abs(median - res[i]) / x);
        }
        return minOps;
    }
}
