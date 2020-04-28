package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|MaximalSquare| on Apr,2020
 *  
 * Happy Coding :)
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 **/
public class MaximalSquare {


    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[row + 1][col + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                dp[i][j] = min + 1;
                Math.max(ans, dp[i][j]);


            }

        }
        return ans;

    }
}
