package ScalerAcademy.backtracking;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / NQueens
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 *
 * Problem Description
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First argument is an integer n denoting the size of chessboard
 *
 *
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Output 1:
 *
 * [
 * [Q]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 *
 * There exist only one distinct solutions to the 1-queens puzzle:
 *
 * Approach:
 * Queen shouldnt present on the diagonals,same row,same column
 **/
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        String str = "";
        for (int i = 0; i < a; i++) {
            str += '.';
        }
        for (int i = 0; i < a; i++) {
            path.add(str);
        }
        backtrack(0, a, path, res);
        return res;

    }

    private void backtrack(int row, int n, ArrayList<String> path, ArrayList<ArrayList<String>> res) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(path, row, i)) {
                String currentRowString = path.get(row);
                StringBuilder builder = new StringBuilder(currentRowString);
                builder.setCharAt(i, 'Q');
                path.set(row, builder.toString());
                backtrack(row + 1, n, path, res);
                builder.setCharAt(i, '.');
                path.set(row, builder.toString());
            }
        }
    }

    private boolean isValid(ArrayList<String> path, int row, int col) {
        return checkSameColumn(path, row, col) && isTopLeftDiagonalValid(path, row, col) && isTopRightDiagonalValid(path, row, col);
    }

    private boolean isTopRightDiagonalValid(ArrayList<String> path, int row, int col) {
        if (row < 0 || col >= path.get(0).length()) return true;
        if (path.get(row).charAt(col) == 'Q') {
            return false;
        }
        return isTopRightDiagonalValid(path, row - 1, col + 1);
    }

    private boolean isTopLeftDiagonalValid(ArrayList<String> path, int row, int col) {
        if (row < 0 || col < 0) return true;
        if (path.get(row).charAt(col) == 'Q') {
            return false;
        }
        return isTopLeftDiagonalValid(path, row - 1, col - 1);
    }

    private boolean checkSameColumn(ArrayList<String> path, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (path.get(i).charAt(col) == 'Q') return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(2));
    }
}
