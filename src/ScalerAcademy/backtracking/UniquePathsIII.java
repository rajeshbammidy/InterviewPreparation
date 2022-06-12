package ScalerAcademy.backtracking;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / UniquePathsIII
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 *
 * Problem Description
 * Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 *
 * 1. 1 represents the starting square.  There is exactly one starting square.
 * 2. 2 represents the ending square.  There is exactly one ending square.
 * 3. 0 represents empty squares we can walk over.
 * 4. -1 represents obstacles that we cannot walk over.
 * Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 2 <= N * M <= 20
 * -1 <= A[i] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 0, 0, 0]
 * [0, 0, 0, 0]
 * [0, 0, 2, -1]   ]
 * Input 2:
 *
 * A = [   [0, 1]
 * [2, 0]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Explanation 1:
 *
 * Answer is evident here.
 **/
public class UniquePathsIII {
    public int solve(int[][] array) {
        int sr = 0, sc = 0;
        boolean startFound = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    sr = i;
                    sc = j;
                    array[i][j] = -1;
                    startFound = true;
                }
            }
        }
        if (!startFound) {
            return 0;
        }
        return backtrack(array, sr, sc);

    }

    private int backtrack(int[][] array, int sr, int sc) {
        if (array[sr][sc] == 2) {
            if (isAllVisisted(array)) {
                return 1;
            }
            return 0;
        }

        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int ans = 0;
        for (int d[] : dir) {
            int row = sr + d[0];
            int col = sc + d[1];

            if (isValid(array, row, col)) {
                if (array[row][col] != -1) {
                    if (array[row][col] == 0) array[row][col] = -1;
                    ans += backtrack(array, row, col);
                    if (array[row][col] == -1) array[row][col] = 0;
                }
            }
        }
        return ans;
    }

    private boolean isAllVisisted(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) return false;
            }
        }
        return true;
    }

    private boolean isValid(int[][] array, int row, int col) {
        int m = array.length;
        int n = array[0].length;
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
