package ScalerAcademySolutions.backtracking;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / VerticalAndHorizontalSums
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.
 *
 * A special operation involves multiplying any element by -1 i.e. changing its sign.
 *
 * Return 1 if it is possible to achieve the answer, otherwise 0.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 10
 *
 * 0 <= A <= 5
 *
 * -105 <= B[i][j], C <= 105
 *
 *
 *
 * Input Format
 *
 * The first argument is an integer A, representing the number of special operations allowed.
 * The second argument has the N x M integer matrix, B.
 * The third argument is an integer C, as described in the problem statement.
 *
 *
 *
 * Output Format
 *
 * Return 1 if it is possible to achieve the answer, otherwise 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = 3
 * B = [
 * [1, 1, 1]
 * [1, 1, 1]
 * [1, 1, 1]
 * ]
 * C = 2
 * Input 2:
 *
 * A = 1
 * B = [
 * [1, 1, 1]
 * [1, 1, 1]
 * [1, 1, 1]
 * ]
 * C = 2
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The given matrix does not satisfy the conditions, but if we apply the special operation to B[0][0], B[1][1], B[2][2],
 * then the matrix would satisfy the given conditions i.e. no row or column has a sum greater than 2.
 * Explanation 2:
 *
 * It is not possible to apply the special operation to 1 element to satisfy the conditions.
 **/
public class VerticalAndHorizontalSums {
    public int solve(int ops, int[][] array, int sum) {

        return backtrack(0, 0, ops, sum, array) ? 1 : 0;
    }

    private boolean backtrack(int row, int col, int ops, int sum, int[][] array) {
        if (col >= array[row].length) {
            col = 0;
            row++;
            if (row >= array.length) {
                if (ops >= 0) {
                    return checkIfRowSumAndColumnSumIsValid(array, sum);
                }
                return false;
            }
        }
        if (ops == 0 && !checkIfRowSumAndColumnSumIsValid(array, sum)) {
            return false;
        }
        int value = array[row][col];
        if (ops > 0) {
            array[row][col] = -value;
            boolean res = backtrack(row, col + 1, ops - 1, sum, array);
            array[row][col] = value;
            if (res) {
                return true;
            }
        }
        return backtrack(row, col + 1, ops, sum, array);

    }

    private boolean checkIfRowSumAndColumnSumIsValid(int[][] array, int maxSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                long curSum = 0;
                for (int k = j; k < array[i].length; k++) {
                    curSum += array[i][k];
                    if (curSum > maxSum) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                long curSum = 0;
                for (int k = j; k < array.length; k++) {
                    curSum += array[k][i];
                    if (curSum > maxSum) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new VerticalAndHorizontalSums().solve(3, new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        }, 2));
    }
}
