package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|RepeatingSubSequence| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class RepeatingSubSequence {
    public int anytwo(String a) {
        String b = a;
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[m - 1][n - 1] >= 2 ? 1 : 0;

    }
}
