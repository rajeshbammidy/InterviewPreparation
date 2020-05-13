package Backtracking;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|Sudoku| on May,2020
 *  
 * Happy Coding :)
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 **/
public class Sudoku {
    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        backtrack(board, n, 0, 0);
    }


    private boolean backtrack(char[][] board, int n, int row, int col) {
        if (col == n) {
            row++;
            col = 0;
            if (row == n) return true;
        }
        if (board[row][col] != '.') return backtrack(board, n, row, col + 1);
        for (int i = 1; i <= n; i++) {
            char ch = (char) (i + '0');
            if (valid(board, ch, row, col)) {
                board[row][col] = ch;
                if (backtrack(board, n, row, col + 1)) return true;
            }

        }
        board[row][col] = '.';
        return false;


    }

    private boolean valid(char board[][], char ch, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch) return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == ch) return false;
        }


        int regsize = (int) Math.sqrt(board.length);
        int i = row / regsize;
        int j = col / regsize;
        int srow = regsize * i;
        int scol = regsize * j;
        for (int k = 0; k < regsize; k++) {
            for (int l = 0; l < regsize; l++) {

                if (board[srow + k][scol + l] == ch) return false;

            }
        }
        return true;
    }
}
