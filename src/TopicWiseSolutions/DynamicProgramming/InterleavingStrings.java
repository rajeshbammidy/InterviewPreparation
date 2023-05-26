package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|InterleavingStrings| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class InterleavingStrings {
    public int isInterleave(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) return 0;
        boolean dp[][] = new boolean[b.length() + 1][a.length() + 1];
        dp[0][0] = true;
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < n; i++) {
            if (a.charAt(i - 1) == c.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < m; i++) {
            if (b.charAt(i - 1) == c.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] && (b.charAt(i - 1) == c.charAt(i + j - 1))) ||
                        (dp[i][j - 1] && (a.charAt(j - 1) == c.charAt(j + i - 1)));
            }
        }
        return dp[m - 1][n - 1] == true ? 1 : 0;


    }
}
