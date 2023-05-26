package TopicWiseSolutions.DynamicProgramming;

public class MinimumnumberofCoins {
    public static int arr[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    static int minCoint(int sum) {
        int dp[][] = new int[arr.length][sum + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - arr[0]] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - arr[i]] + 1, dp[i - 1][j]);
                }
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        System.out.println(minCoint(43));
    }
}
