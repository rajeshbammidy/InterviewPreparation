package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|MaxSumWithoutAdjacentElements| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] arr) {
        int n = arr[0].length;
        int dp[] = new int[n];
        for (int i = 0; i < arr[0].length; i++) {
            dp[i] = Math.max(arr[0][i], arr[1][i]);
        }

        if (n == 1) {

            return dp[0];
        }
        if (n == 2) {
            dp[1] = Math.max(dp[0], dp[1]);
            return Math.max(dp[0], dp[1]);
        }
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
