package ScalerAcademy.arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / SearchInARowWiseAndColumnWiseSortedMatrix
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * -100000 <= B <= 100000
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 *
 * Return the position of B and if it is not present in A return -1 instead.
 *
 *
 * Example Input
 *
 * A = [ [1, 2, 3]
 *           [4, 5, 6]
 *           [7, 8, 9] ]
 * B = 2
 *
 *
 * Example Output
 *
 * 1011
 *
 *
 * Example Explanation
 *
 * A[1][2]= 2
 * 1*1009 + 2 =1011
 */
public class SearchInARowWiseAndColumnWiseSortedMatrix {
    public int solve(int[][] array, int value) {
        int totalRows = array.length;
        /**
         * top right row,col
         */
        int row = 0;
        int col = array[0].length - 1;

        int i = -1, j = -1;
        while (row < totalRows && col >= 0) {
            if (value <= array[row][col]) {
                i = row;
                j = col;
                if (value == array[row][col]) {
                    if (col > 0 && value != array[row][col - 1]) break;
                }
                col--;//move left
            } else {
                row++;//move down
            }

        }

        return (i != -1 && j != -1 && array[i][j] == value) ? ((i + 1) * 1009 + (j + 1)) : -1;

    }

    public static void main(String[] args) {
        System.out.println(new SearchInARowWiseAndColumnWiseSortedMatrix().solve(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 2));
        ;
    }
}
