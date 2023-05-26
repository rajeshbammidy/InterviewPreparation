package ScalerAcademySolutions.backtracking;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / Sudoku
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 *
 *
 * Problem Constraints
 * N = 9
 *
 *
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 *
 *
 * Output Format
 * Modify the given input to the required answer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 *
 *
 * Example Output
 * Output 1:
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Look at the diagrams given in the question.
 *
 *
 *
 * See Expected Output
 **/
public class Sudoku {

    public void solveSudoku(char[][] puzzle) {
        backtrack(0, 0, puzzle.length, puzzle[0].length, puzzle);
    }

    private boolean backtrack(int row, int col, int m, int n, char[][] puzzle) {
        if (col >= n) {
            row++;
            col = 0;
            if (row >= m) {
                return true;
            }
        }

        if (puzzle[row][col] != '.') {
            return backtrack(row, col + 1, m, n, puzzle);
        }
        for (int num = 1; num < 10; num++) {
            char ch = (char) (num + '0');
            if (isValid(puzzle, ch, row, col)) {
                puzzle[row][col] = ch;
                boolean result = backtrack(row, col + 1, m, n, puzzle);
                if (result) return true;
            }

        }
        puzzle[row][col] = '.';
        return false;

    }

    private boolean isValid(char[][] puzzle, char ch, int row, int col) {

        return isRowValid(puzzle, row, ch) && isColumnValid(puzzle, col, ch) && isRegiomValid(puzzle, row, col, ch);

    }

    private boolean isRegiomValid(char[][] puzzle, int row, int col, char ch) {
        int regionSize = (int) Math.sqrt(puzzle.length);
        int rowMulFactor = row / regionSize;
        int colMulFactor = col / regionSize;
        int srow = regionSize * rowMulFactor;
        int scol = regionSize * colMulFactor;
        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (puzzle[i + srow][j + scol] == ch) return false;
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] puzzle, int col, char ch) {
        for (int i = 0; i < puzzle[0].length; i++) {
            if (puzzle[i][col] == ch) return false;
        }
        return true;
    }

    private boolean isRowValid(char[][] puzzle, int row, char ch) {
        for (int i = 0; i < puzzle[0].length; i++) {
            if (puzzle[row][i] == ch) return false;
        }
        return true;
    }
}
