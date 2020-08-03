package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|KthManhattanDistanceNeighbourhood| on Jul,2020
 *  
 * Happy Coding :)
 * Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood for all elements in nxm matrix.
 * In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.
 *
 * Note: Expected time complexity is O(N*N*K)
 *
 * Constraints:
 *
 * 1 <= n <= 300
 * 1 <= m <= 300
 * 1 <= K <= 300
 * 0 <= M[i][j] <= 1000
 * Example:
 *
 * Input:
 * M  = [[1,2,4],[4,5,8]] , K = 2
 *
 * Output:
 * ans = [[5,8,8],[8,8,8]]
 **/
public class KthManhattanDistanceNeighbourhood {
    public int[][] solve(int l, int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr[i], 0, dp[i], 0, n);
        }

        for (int k = 1; k <= l; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    int max = arr[i][j];

                    if (isValid(i - 1, j, m, n)) {
                        max = Math.max(arr[i - 1][j], max);
                    }
                    if (isValid(i + 1, j, m, n)) {
                        max = Math.max(arr[i + 1][j], max);
                    }
                    if (isValid(i, j - 1, m, n)) {
                        max = Math.max(arr[i][j - 1], max);
                    }
                    if (isValid(i, j + 1, m, n)) {
                        max = Math.max(arr[i][j + 1], max);
                    }
                    dp[i][j] = max;

                }

            }
            for (int i = 0; i < m; i++) {
                System.arraycopy(dp[i], 0, arr[i], 0, n);
            }

        }
        return dp;

    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
