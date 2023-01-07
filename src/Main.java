

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Main {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int cumSum[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            cumSum[0][i] = mat[0][i];
        }
        /**
         * Row-wise sum
         */
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cumSum[i][j] = mat[i][j] + cumSum[i - 1][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cumSum[i][j] += cumSum[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(cumSum));
        int ans[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int tr = i - k;
                int br = i + k;
                int lc = j - k;
                int rc = j + k;

                if (br >= m) {
                    br = (m - 1);
                }
                if (rc >= n) {
                    rc = (n - 1);
                }
                if (lc < 0) lc = 0;
                if (tr < 0) tr = 0;
                int bottomRightTotal = cumSum[br][rc];
                int topRightDelete = 0;
                if (tr - 1 >= 0 && rc < n) {
                    topRightDelete = cumSum[tr - 1][rc];
                }
                int bottomLeftToDelete = 0;
                if (br < m && lc - 1 >= 0) {
                    bottomLeftToDelete = cumSum[br][lc - 1];
                }
                int diagonalDelete = 0;
                if (tr - 1 >= 0 && lc - 1 >= 0) {
                    diagonalDelete = cumSum[tr - 1][lc - 1];
                }

                ans[i][j] = bottomRightTotal + diagonalDelete - topRightDelete - bottomLeftToDelete;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Main().matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}},2)));
    }

}

