package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|MatrixSearch| on Apr,2020
 *  
 * Happy Coding :)
 * Matrix Search
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integar B in matrix A.
 * This matrix A has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0. NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * 1 <= A[i][j], B <= 106
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * Output Format
 * Return 1 if B is present in A, else return 0.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [
 * [1,   3,  5,  7]
 * [10, 11, 16, 20]
 * [23, 30, 34, 50]
 * ]
 * B = 3
 * Input 2:
 * A = [
 * [5, 17, 100, 111]
 * [119, 120, 127, 131]
 * ]
 * B = 3
 * <p>
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * 3 is present in the matrix at A[0][1] position so return 1.
 * Explanation 2:
 * 3 is not present in the matrix so return 0.
 **/

import java.util.Arrays;

public class MatrixSearch {
    public int searchMatrix(int[][] arr, int tar) {
        int m = 0;
        int n = arr[0].length - 1;
        while (m >= 0 && m < arr.length) {
            if (arr[m][n] >= tar) {
                return Arrays.binarySearch(arr[m], tar) >= 0 ? 1 : 0;
            } else {
                m++;
            }
        }


        return 0;
    }
}
